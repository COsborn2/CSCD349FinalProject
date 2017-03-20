/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

import dungeon.*;

/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class Dungeon
{
	
    public static void main(String[] args) throws Exception
	{
		System.out.println("Welcome to Monsters and Heros!");
		System.out.print("Enter 'l' to load game, anything else to start a new game: ");
		Character selection = Keyboard.readChar();
		
		if(selection == 'l'){
			System.out.println("Loading game save!");
			GameLogic gl = new GameLogic();
			gl.load();
			importBattle(gl);
		}
		else{
			performBattle();
		}
    }//end main method
    
    public static void performBattle() throws Exception{
    	DungeonCharacterStore mStore = new DungeonCharacterStore();

		GameLogic gl = null;
    	Hero[] theHeros;
    	Monster[] theMonsters;
    	do
		{
    		System.out.print("Select the number of Heros (1-5): ");
    		int numberHeros = Keyboard.readInt();
    		theHeros = new Hero[numberHeros];
    		theMonsters = new Monster[numberHeros];
    		
			for(int i = 0; i < numberHeros; i++){
				theHeros[i] = chooseHero(mStore);
				theMonsters[i] = mStore.generateMonster();
				gl = new GameLogic(theHeros, theMonsters);
			}
			battle(gl);

		} while (playAgain());
    }
    
    public static void importBattle(GameLogic gl) throws Exception{
    	battle(gl);
    	
    	if(playAgain())
    		performBattle();
    }

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
	public static Hero chooseHero(DungeonCharacterStore mStore)
	{
		int choice;
		Hero theHero;

		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief \n" +
						   "4. Capaulasourous \n" +
						   "5. Pimp Daddy Peters");
		choice = Keyboard.readInt();
		theHero = mStore.spawnHero(choice);
		
		return theHero;
		
	}//end chooseHero method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		return (again == 'Y' || again == 'y');
	}//end playAgain method


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(GameLogic gl) throws Exception
	{
		char pause = 'p';
		
		Hero[] curHeros = gl.getHeros();
		Monster[] curMonsters = gl.getMonsters();
		
		gl.printInfoAboutHeros();
		
		System.out.println("are battling");
		
		gl.printInfoAboutMonsters();
		System.out.println("---------------------------------------------");

		//do battle
		while (gl.areAnyHerosAlive() && gl.areAnyMonstersAlive() && pause != 'q' && pause != 's')
		{
			/*
			 * The heros are allowed to attack first, and then the monsters, provided they are alive.
			 * Iterate through the Hero array to attack the first Monster then
			 * Iterate through the Monster array to attack the first Hero
			 */
			curHeros = gl.getHeros();
			curMonsters = gl.getMonsters();
			
		    //heros go first
			for(int i = 0; i < curHeros.length; i++){
				gl.printInfoAboutMonsters();
				if(gl.firstMonsterAlive() > -1){
					System.out.println(curHeros[i].getName() + " is attacking!");
					curHeros[i].battleChoices(curMonsters[gl.firstMonsterAlive()]);
				}
				else{
					curHeros = gl.getHeros();
					for(int j = 0; j < curHeros.length; j++){
						System.out.println(curHeros[j].getName());
					}
					System.out.println("were victorious!");
					return;
				}
			}//end Hero for loop
			
			//monster's turn (provided it's still alive!)
			curHeros = gl.getHeros();
			curMonsters = gl.getMonsters();
			
			for(int i = 0; i < curMonsters.length; i++){
				gl.printInfoAboutHeros();
				if(gl.firstHeroAlive() > -1)
					curMonsters[i].attack(curHeros[gl.firstHeroAlive()]);
				else{
					curMonsters = gl.getMonsters();
					for(int j = 0; j < curMonsters.length; j++){
						System.out.println(curMonsters[j].getName());
					}
					System.out.println("were victorious!");
					return;
				}
			}//end Monster for loop

			//let the player bail out if desired
			System.out.println("BATTLE UPDATE");
			gl.printInfoAboutHeros();
			gl.printInfoAboutMonsters();
			System.out.println("-------------------------------------");
			System.out.print("\n-->q to quit, -->s to save and quit, anything else to continue: ");
			pause = Keyboard.readChar();
			if(pause == 's'){
				System.out.println("Saving game!");
				gl.save();
				System.exit(0);
			}

		}//end battle loop

		//Determine which heros and monsters are alive
		if (gl.areAnyMonstersAlive()){
		    Monster[] startingMonsters = gl.getInitMonsters();
		    for(int i = 0; i < startingMonsters.length; i++){
		    	System.out.println(startingMonsters[i].getName());
		    }
		    System.out.println("were victorious!");
		}
		else if (gl.areAnyHerosAlive()){
			Hero[] startingHeros = gl.getInitHeros();
		    for(int i = 0; i < startingHeros.length; i++){
		    	System.out.println(startingHeros[i].getName());
		    }
		    System.out.println("were victorious!");
		}
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method


}//end Dungeon class