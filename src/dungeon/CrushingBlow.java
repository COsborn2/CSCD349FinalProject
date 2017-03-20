/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeon;

import java.io.Serializable;

public class CrushingBlow implements AttackInterface, Serializable {

	@Override
	public void Attack(DungeonCharacter attacker, DungeonCharacter defender) 
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(attacker.getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			defender.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(attacker.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed


	}
	
	public String toString()
	{
		return "Crushing Blow on opponent";
	}

}
