/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeon;

import java.io.Serializable;

public class HeroFactory implements Serializable{

	public DungeonCharacter spawnHero(int selection){
		switch(selection){
		
			/*
			 * String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock
			 */
			case 1: return new Hero("Warrior", 125, 4, .8, 35, 60, " swings a mighty sword at ", .2, AttackManager.getCrushing());

			case 2: return new Hero("Sorceress", 75, 5, .7, 25, 50, " casts a spell of fireball at ", .3, AttackManager.getHeal(25, 50));

			case 3: return new Hero("Thief", 75, 6, .8, 20, 40, " stabs his dagger at ", .5, AttackManager.getSuprise());
			
			case 4: return new Hero("Capaulasourous", 100, 7, .6, 20, 60, " throws a book at ", .3, AttackManager.getCapaul(20,60));
			
			case 5: return new Hero("Pimp Daddy Peters", 40, 2, .9, 10, 90, " flashes gold chains at ", .2, AttackManager.getPeter());

			default: System.out.println("invalid choice, returning Thief");
					return new Hero("Thief", 75, 6, .8, 20, 40, " casts a spell of fireball at ", .5, AttackManager.getSuprise());
		}//end switch
	}
	
	
	
}
