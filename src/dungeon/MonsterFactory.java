/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeon;

import java.io.Serializable;

public class MonsterFactory implements Serializable{

	/*String name, int hitPoints, int attackSpeed, 
	 * double chanceToHit, double chanceToHeal, int damageMin, 
	 * int damageMax, int minHeal, int maxHeal, String toPrint)
	 */
	public DungeonCharacter spawnMonster(int selection){
		switch(selection)
		{
			case 1: return new Monster("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 100, "jabs his kris at");						//Ogre

			case 2: return new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 50, "slowly swings a club towards");	//Gremlin

			case 3: return new Monster("Sargath the Skeleton", 100, 3, .8, .3, 30, 100, 30, 50, "slices his rusty blade at");		//Skeleton
			
			case 4: return new Monster("FrankenSTEINER", 60, 7, .7, 40, 70, 200, 20, 60, "assigns homework due in one hour!");		//FrankenSTEINER
			
			case 5: return new Monster("CS Grader", 100, 4, .6, .2, 50, 100, 10, 60, "finds minor error! ");						//CS Grader

			default: System.out.println("invalid choice, returning Gremlin");
				     return new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40, "slowly swings a club towards");	//Gremlin
		}//end switch
		
	}
	
	public Monster generateMonster()
	{
		int choice;

		choice = (int)(Math.random() * 5) + 1;

		return (Monster)spawnMonster(choice);
	}//end generateMonster method

}
