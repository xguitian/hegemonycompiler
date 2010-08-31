package hegemony.main;

import java.util.ArrayList;
import java.util.List;

public class Util
{
	/**
	 * Transforms territory names to lowercase and removes accent mark (to be a bit lenient with player's mistakes)
	 */
	public static String normalizeName(String name)
	{
		String normalizedName = name.toLowerCase();
		normalizedName = normalizedName.replace("á", "a");
		normalizedName = normalizedName.replace("é", "e");
		normalizedName = normalizedName.replace("í", "i");
		normalizedName = normalizedName.replace("ó", "o");
		normalizedName = normalizedName.replace("ú", "u");
		normalizedName = normalizedName.replace("ñ", "n");
		return normalizedName;
	}
	
	public static List<String> convertIllegalCharacterErrorsToString (List<IllegalCharacterError> illegalCharacterErrors)
	{
		List<String> errors = new ArrayList<String>();
		
		for (IllegalCharacterError e : illegalCharacterErrors)
		{
			errors.add("Caracter ilegal \"" + e.getIllegalCharacter() + "\" en la línea " + e.getLine() +
							", columna "+ e.getColumn());
		}
		
		return errors;
	}
	

}
