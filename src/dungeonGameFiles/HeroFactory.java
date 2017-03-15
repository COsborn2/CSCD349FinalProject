package dungeonGameFiles;


public class HeroFactory {

	public DungeonCharacter spawnHero(int selection){
		switch(selection){
			case 1: return new Warrior("Warrior", 125, 4, .8, 35, 60, .2);

			case 2: return new Sorceress("Sorceress", 75, 5, .7, 25, 50, .3);

			case 3: return new Thief("Thief", 75, 6, .8, 20, 40, .5);

			default: System.out.println("invalid choice, returning Thief");
				     return new Thief("Thief", 75, 6, .8, 20, 40, .5);
		}//end switch
	}
	
	
	
}
