/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeon;

import java.io.Serializable;

public class RegularAttack implements AttackInterface, Serializable
{
   public void Attack(DungeonCharacter attacker, DungeonCharacter defender)
   {
      System.out.println(attacker.getName() + " "+ attacker.getToPrint() + " " + defender.getName() + ":");
      boolean canAttack;
		int damage;

		canAttack = Math.random() <= attacker.getChanceToHit();

		if (canAttack)
		{
			damage = (int)(Math.random() * (attacker.getDamageMax() - attacker.getDamageMin() + 1))
						+ attacker.getDamageMin() ;
			defender.subtractHitPoints(damage);



			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(attacker.getName() + "'s attack on " + defender.getName() +
								" failed!");
			System.out.println();
      }
   }
}