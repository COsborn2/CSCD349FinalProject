/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeon;

import java.io.Serializable;

public class PeterAttack implements AttackInterface, Serializable {

	@Override
	public void Attack(DungeonCharacter attacker, DungeonCharacter defender) 
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(attacker.getName() + " tells STORY for " + blowPoints
								+ " damage!");
			defender.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(attacker.getName() + " failed to land STORY");
			System.out.println();
		}//blow failed


	}
	
	public String toString()
	{
		return "Tell Story";
	}

}
