/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeon;

public class SupriseAttack implements AttackInterface
{
	private RegularAttack attack = new RegularAttack();
	
	public void Attack(DungeonCharacter attacker, DungeonCharacter defender) 
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								attacker.getName() + " attacks twice.");
			attack.Attack(attacker, defender);
			attack.Attack(attacker, defender);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + defender.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
			attack.Attack(attacker, defender);
	}
	
	public String toString()
	{
		return "Suprise Attack on opponent";
	}

}
