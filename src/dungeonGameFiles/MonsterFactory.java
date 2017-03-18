/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeonGameFiles;


public class MonsterFactory {

	/*String name, int hitPoints, int attackSpeed, 
	 * double chanceToHit, double chanceToHeal, int damageMin, 
	 * int damageMax, int minHeal, int maxHeal)
	 */
	public DungeonCharacter spawnMonster(int selection){
		switch(selection)
		{
			case 1: return new Monster("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50, "jabs his kris at");						//Ogre

			case 2: return new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40, "slowly swings a club towards");	//Gremlin

			case 3: return new Monster("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50, "slices his rusty blade at");		//Skeleton

			default: System.out.println("invalid choice, returning Gremlin");
				     return new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40, "slowly swings a club towards");	//Gremlin
		}//end switch
		
	}
	
	public Monster generateMonster()
	{
		int choice;

		choice = (int)(Math.random() * 3) + 1;

		return (Monster)spawnMonster(choice);
	}//end generateMonster method

}
