package hegemony.main;

import java.util.ArrayList;
import java.util.List;

public class HegemonyTerritory
{

	public enum Territory { LAND, SEA, COAST }
	
	private String name;
	private Territory type;
	private List<String> adjacentTerritories;
	
	public HegemonyTerritory(String name, Territory type)
	{
		this.name = name;
		this.type = type;
		this.adjacentTerritories = new ArrayList<String>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNormalizedName()
	{
		return Util.normalizeName(name);
	}
	
	public Territory getType()
	{
		return type;
	}
	
	public List<String> getAdjacentTerritories()
	{
		return adjacentTerritories;
	}
	
	public void addAdjacentTerritory(String adjacentTerritoryName)
	{
		adjacentTerritories.add(Util.normalizeName(adjacentTerritoryName));
	}
	
	public boolean isAdjacentToTerritory(String name)
	{
		return adjacentTerritories.contains(Util.normalizeName(name));
	}
}
