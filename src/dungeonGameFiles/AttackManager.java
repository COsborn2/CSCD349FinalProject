/*
 * Authored by: Cameron Osborn and Joseph Carlson
 */

package dungeonGameFiles;
import java.util.*;
public class AttackManager 
{	
	private static HashMap<String, AttackInterface> attacks = new HashMap<String, AttackInterface>();
	
	private static void createMap()
	{
		attacks.put("regular", new RegularAttack());
		attacks.put("suprise", new SupriseAttack());
		attacks.put("crushing", new CrushingBlow());
		attacks.put("heal", new HealCharacter());
		attacks.put("capaul", new CapaulAttack());
		attacks.put("peter", new PeterAttack());
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
	public static AttackInterface getHeal()
	{
		if (attacks.size() == 0)
			createMap();
		return attacks.get("Heal");
	}
	public static AttackInterface getCapaul()
	{
		if (attacks.size() == 0)
			createMap();
		return attacks.get("capaul");
	}
	public static AttackInterface getPeter()
	{
		if (attacks.size() == 0)
			createMap();
		return attacks.get("peter");
	}

}
