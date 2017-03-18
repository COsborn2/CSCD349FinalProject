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

}
