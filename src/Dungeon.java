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
	
    public static void main(String[] args)
	{
		DungeonCharacterStore mStore = new DungeonCharacterStore();
		
		Keyboard kb = new Keyboard();
		
		System.out.print("Select the number of Heros (1-5):");
		int numberHeros = Keyboard.readInt();
		Hero[] heros = new Hero[numberHeros];
		Monster[] monsters = new Monster[numberHeros];
		GameLogic gl = new GameLogic(heros, monsters);

		performBattle(gl, mStore);

    }//end main method
    
    public static void performBattle(GameLogic gl, DungeonCharacterStore mStore){
    	Hero[] heros = gl.getHeros();
		Monster[] monsters = gl.getMonsters();
    	do
		{
			for(int i = 0; i < heros.length; i++){
				heros[i] = chooseHero(mStore);
				monsters[i] = mStore.generateMonster();
			}
			battle(gl);

		} while (playAgain());
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
						   "5. Captain Peters");
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
	public static void battle(GameLogic gl)
	{
		char pause = 'p';
		
		Hero[] curHeros = gl.getHeros();
		Monster[] curMonsters = gl.getMonsters();
		
		for(int i = 0; i < curHeros.length; i++){
			System.out.println(curHeros[i].getName());
		}
		
		System.out.println("are battling");
		
		for(int i = 0; i < curMonsters.length; i++){
			System.out.println(curMonsters[i].getName());
		}
		System.out.println("---------------------------------------------");

		//do battle
		while (gl.areAnyHerosAlive() && gl.areAnyMonstersAlive() && pause != 'q')
		{
			/*
			 * The heros are allowed to attack first, and then the monsters, provided they are alive.
			 * Iterate through the Hero array to attack the first Monster then
			 * Iterate through the Monster array to attack the first Hero
			 */
			curHeros = gl.getHeros();
			curMonsters = gl.getMonsters();
			
			System.out.println("Heros are attacking!");
		    //heros go first
			for(int i = 0; i < curHeros.length; i++){
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
			
			System.out.println("Monsters are attacking!");
			for(int i = 0; i < curMonsters.length; i++){
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
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = Keyboard.readChar();
			

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