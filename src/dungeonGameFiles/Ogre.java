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

public class Ogre extends Monster
{

    public Ogre(String name, int hitPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin, int damageMax, int minHeal, int maxHeal)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);


    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(super.getName() + " slowly swings a club toward's " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end Monster class