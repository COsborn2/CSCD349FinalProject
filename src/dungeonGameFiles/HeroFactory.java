/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeonGameFiles;


public class HeroFactory {

	public DungeonCharacter spawnHero(int selection){
		switch(selection){
		
			/*
			 * String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock
			 */
			case 1: return new Hero("Warrior", 125, 4, .8, 35, 60, .2);

			case 2: return new Hero("Sorceress", 75, 5, .7, 25, 50, .3);

			case 3: return new Hero("Thief", 75, 6, .8, 20, 40, .5);
			
			case 4: return new Hero("Capaulasourous", 100, 7, .6, 20, 60, .3);
			
			case 5: return new Hero("Captain Peters", 40, 2, .9, 60, 90, .2);

			default: System.out.println("invalid choice, returning Thief");
				     return new Hero("Thief", 75, 6, .8, 20, 40, .5);
		}//end switch
	}
	
	
	
}
