package dungeon;

public class GameLogic {

	private Hero[] theHeros;
	private Hero[] initHeros;
	private Monster[] theMonsters;
	private Monster[] initMonsters;
	
	public GameLogic(Hero[] theHeros, Monster[] theMonsters){
		this.theHeros = theHeros;
		this.initHeros = theHeros;
		this.theMonsters = theMonsters;
		this.initMonsters = theMonsters;
	}
	
	public void setHeros(Hero[] newHeros){
		this.theHeros = newHeros;
	}
	
	public void setMonsters(Monster[] newMonsters){
		this.theMonsters = newMonsters;
	}
	
	public Hero[] getHeros(){
		bringOutYourDead();
		return this.theHeros;
	}
	
	public Hero[] getInitHeros(){
		return this.initHeros;
	}
	
	public Monster[] getInitMonsters(){
		return this.initMonsters;
	}
	
	public Monster[] getMonsters(){
		bringOutYourDead();
		return this.theMonsters;
	}
	
	public void bringOutYourDead(){
		int heroCount = countLivingHeros();
		int monsterCount = countLivingMonsters();
		
		Hero[] livingHeros = new Hero[heroCount];
		Monster[] livingMonsters = new Monster[monsterCount];
		
		int count = 0;
		for(int i = 0; i < this.theHeros.length; i++){
			if(theHeros[i].isAlive()){
				livingHeros[count] = theHeros[i];
				count++;
			}
		}
		
		count = 0;
		for(int i = 0; i < this.theMonsters.length; i++){
			if(theMonsters[i].isAlive()){
				livingMonsters[count] = theMonsters[i];
				count++;
			}
		}
		this.theHeros = livingHeros;
		this.theMonsters = livingMonsters;
	}
	
	public int countLivingHeros(){
		int count = 0;
		for(int i = 0; i < this.theHeros.length; i++){
			if(theHeros[i].isAlive())
				count++;
		}
		return count;
	}
	
	public int countLivingMonsters(){
		int count = 0;
		for(int i = 0; i < this.theMonsters.length; i++){
			if(theMonsters[i].isAlive())
				count++;
		}
		return count;
	}
	
	public boolean areAnyMonstersAlive(){
		bringOutYourDead();
		
		for(Monster mon : this.theMonsters){
			if(mon.isAlive())
				return true;
		}
		
		return false;
	}
	
	public boolean areAnyHerosAlive(){
		bringOutYourDead();
		
		for(Hero hero : this.theHeros){
			if(hero.isAlive())
				return true;
		}
		
		return false;
	}
	
	public int firstMonsterAlive(){
		for(int i = 0; i < this.theMonsters.length; i++){
			if(theMonsters[i].isAlive())
				return i;
		}
		
		return -1;
	}
	
	public int firstHeroAlive(){
		for(int i = 0; i < this.theHeros.length; i++){
			if(theHeros[i].isAlive())
				return i;
		}
		return -1;
	}
}
