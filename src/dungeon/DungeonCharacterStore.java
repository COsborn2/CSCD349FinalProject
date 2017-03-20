/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeon;

import java.io.Serializable;

public class DungeonCharacterStore implements Serializable{
	private MonsterFactory mFact;
	private HeroFactory hFact;
	
	public DungeonCharacterStore(){
		this.mFact = new MonsterFactory();
		this.hFact = new HeroFactory();
	}
	
	public Monster spawnMonster(int selection){
		DungeonCharacter toReturn;
		
		toReturn = mFact.spawnMonster(selection);
		
		return (Monster)toReturn;
	}
	
	public Hero spawnHero(int selection){
		DungeonCharacter toReturn;
		
		toReturn = hFact.spawnHero(selection);
		
		return (Hero)toReturn;
	}
	
	public Monster generateMonster(){
		return mFact.generateMonster();
	}
}
