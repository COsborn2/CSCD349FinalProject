package dungeonGameFiles;



/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Thief extends Hero
{

    public Thief(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax, double chanceToBlock)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock);



    }//end constructor

	public void surpriseAttack(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								getName() + " gets an additional turn.");
			super.decrementTurns();
			attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    attack(opponent);


	}//end surpriseAttack method


    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;


		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: surpriseAttack(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			this.decrementTurns();
			if (super.getTurns() > 0)
			    System.out.println("Number of turns remaining is: " + super.getTurns());

		} while(super.getTurns() > 0);

    }
}