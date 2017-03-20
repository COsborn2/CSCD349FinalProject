/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeon;
import java.util.*;
public class AttackManager 
{	
	private static HashMap<String, AttackInterface> attacks = new HashMap<String, AttackInterface>();
	
	private static void createMap()
	{
		attacks.put("regular", new RegularAttack());
		attacks.put("suprise", new SupriseAttack());
		attacks.put("crushing", new CrushingBlow());
		attacks.put("peter", new PeterAttack());
	}
	
	private static void createMap(String toAdd, int minAdd, int maxAdd){
		if(toAdd.equals("heal"))
			attacks.put("heal", new HealCharacter(minAdd, maxAdd));
		else if(toAdd.equals("capaul"))
			attacks.put("capaul", new CapaulAttack(minAdd, maxAdd));
	}
	
	public static AttackInterface getRegular()
	{
		if (attacks.size() == 0)
				createMap();
		return attacks.get("regular");
	}
	
	public static AttackInterface getSuprise()
	{
		if (attacks.size() == 0)
			createMap();
		return attacks.get("suprise");
	}
	public static AttackInterface getCrushing()
	{
		if (attacks.size() == 0)
			createMap();
		return attacks.get("crushing");
	}
	public static AttackInterface getHeal(int minAdd, int maxAdd)
	{
		if (attacks.size() == 0)
			createMap();
		if(attacks.get("heal") == null)
			createMap("heal", minAdd, maxAdd);
		return attacks.get("heal");
	}
	public static AttackInterface getCapaul(int minAdd, int maxAdd)
	{
		if (attacks.size() == 0)
			createMap();
		if(attacks.get("capaul") == null)
			createMap("capaul", minAdd, maxAdd);
		return attacks.get("capaul");
	}
	public static AttackInterface getPeter()
	{
		if (attacks.size() == 0)
			createMap();
		return attacks.get("peter");
	}

}
