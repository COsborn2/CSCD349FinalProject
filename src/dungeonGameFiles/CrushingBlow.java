package dungeonGameFiles;

public class CrushingBlow implements AttackInterface {

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

}
