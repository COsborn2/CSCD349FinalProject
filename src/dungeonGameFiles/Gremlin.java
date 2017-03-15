/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeonGameFiles;



/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Gremlin extends Monster
{

    public Gremlin(String name, int hitPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin, int damageMax, int minHeal, int maxHeal){
		super("Gnarltooth the Gremlin", hitPoints, attackSpeed, chanceToHeal, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(super.getName() + " jabs his kris at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end class Gremlin