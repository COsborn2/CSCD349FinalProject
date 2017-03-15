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
			case 1: return new Ogre("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);

			case 2: return new Gremlin("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

			case 3: return new Skeleton("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);

			default: System.out.println("invalid choice, returning Skeleton");
				     return new Skeleton("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
		}//end switch
		
	}
	
	public Monster generateMonster()
	{
		int choice;

		choice = (int)(Math.random() * 3) + 1;

		return (Monster)spawnMonster(choice);
	}//end generateMonster method

}
