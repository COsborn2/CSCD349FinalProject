package dungeon;

import java.io.*;
import java.util.ArrayList;

public class GameLogic implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1575957538891539811L;
	private Hero[] theHeros;
	private Hero[] initHeros;
	private ArrayList<Hero> deadHeros;
	private Monster[] theMonsters;
	private Monster[] initMonsters;
	private ArrayList<Monster> deadMonsters;
	
	public GameLogic(Hero[] theHeros, Monster[] theMonsters){
		this.theHeros = theHeros;
		this.initHeros = theHeros;
		this.theMonsters = theMonsters;
		this.initMonsters = theMonsters;
		this.deadHeros = new ArrayList<Hero>();
		this.deadMonsters = new ArrayList<Monster>();
	}
	
	public void save() throws IOException{
		FileOutputStream fout = new FileOutputStream(Long.toString(serialVersionUID));
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		objout.writeObject(this);
	}
	
	public void load() throws IOException, ClassNotFoundException{
		FileInputStream fin = new FileInputStream(Long.toString(serialVersionUID));
		ObjectInputStream objin = new ObjectInputStream(fin);
		Object obj = objin.readObject();
		
		if(obj instanceof GameLogic){
			GameLogic loadState = (GameLogic) obj;
			Hero[] heros = loadState.getHeros();
			Hero[] oldHeros = loadState.getInitHeros();
			ArrayList<Hero> fallenHeros = loadState.getDeadHeros();
			Monster[] monsters = loadState.getMonsters();
			Monster[] oldMonsters = loadState.getInitMonsters();
			ArrayList<Monster> fallenMonsters = loadState.getDeadMonsters();
			this.initializeGameLogic(heros, oldHeros, fallenHeros, monsters, oldMonsters, fallenMonsters);
		}
	}
	
	public void initializeGameLogic(Hero[] heros, Hero[] oldHeros, ArrayList<Hero> fallenHeros, Monster[] monsters, Monster[] oldMonsters, ArrayList<Monster> fallenMonsters){
		this.theHeros = heros;
		this.initHeros = oldHeros;
		this.deadHeros = fallenHeros;
		this.theMonsters = monsters;
		this.initMonsters = oldMonsters;
		this.deadMonsters = fallenMonsters;
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
	
	public ArrayList<Hero> getDeadHeros(){
		return this.deadHeros;
	}
	
	public Monster[] getMonsters(){
		bringOutYourDead();
		return this.theMonsters;
	}
	
	public Monster[] getInitMonsters(){
		return this.initMonsters;
	}
	
	public ArrayList<Monster> getDeadMonsters(){
		return this.deadMonsters;
	}
	
	public void bringOutYourDead(){
		int heroCount = countLivingHeros();
		int monsterCount = countLivingMonsters();
		
		Hero[] livingHeros = new Hero[heroCount];
		Monster[] livingMonsters = new Monster[monsterCount];
		
		for(int i = 0; i < this.theHeros.length; i++){
			if(!theHeros[i].isAlive())
				this.deadHeros.add(theHeros[i]);
		}
		
		for(int i = 0; i < this.theMonsters.length; i++){
			if(!theMonsters[i].isAlive())
				this.deadMonsters.add(theMonsters[i]);
		}
		
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
	
	public void printInfoAboutHeros(){
		bringOutYourDead();
		for(int i = 0; i < this.theHeros.length; i++){
			System.out.println(theHeros[i].getName() + " is still alive and has " + theHeros[i].getHitPoints() + " hitpoints.");
		}
		if(this.deadHeros != null)
			for(Hero RIP : this.deadHeros)
			System.out.println(RIP.getName() + " was killed in battle!");
		System.out.println();
	}
	
	public void printInfoAboutMonsters(){
		bringOutYourDead();
		for(int i = 0; i < this.theMonsters.length; i++){
			System.out.println(theMonsters[i].getName() + " is still alive and has " + theMonsters[i].getHitPoints()+ " hitpoints.");
		}
		if(this.deadMonsters != null)
			for(Monster RIP : this.deadMonsters)
			System.out.println(RIP.getName() + " was slain in battle!");
		System.out.println();
	}
}
