package hegemony.main;

public class HegemonyCountry
{

	public enum PowerStatus { MAJOR, MINOR }
	
	private String name;
	private PowerStatus powerStatus;
	
	public HegemonyCountry(String name, PowerStatus powerStatus)
	{
		this.name = name;
		this.powerStatus = powerStatus;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNormalizedName()
	{
		return Util.normalizeName(name);
	}
	
	public PowerStatus getPowerStatus()
	{
		return powerStatus;
	}
	
}
