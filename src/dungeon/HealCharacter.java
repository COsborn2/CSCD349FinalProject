/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeon;

import java.io.Serializable;

public class HealCharacter implements AttackInterface, Serializable {

	public final int MIN_ADD;
	public final int MAX_ADD;
	
	public HealCharacter(int minAdd, int maxAdd){
		this.MIN_ADD = minAdd;
		this.MAX_ADD = maxAdd;
	}
	
	@Override
	public void Attack(DungeonCharacter defender, DungeonCharacter attacker) 
	{
		int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		defender.addHitPoints(hPoints);
		System.out.println(defender.getName() + " added [" + hPoints + "] points to " + defender.getName() + ".\n"
							+ "Total hit points remaining for "+ defender.getName() +" are: "
							+ defender.getHitPoints());
		 System.out.println();

	}
	
	public String toString()
	{
		return "Heal";
	}

}
