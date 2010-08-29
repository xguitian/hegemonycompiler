package hegemony.main;

import hegemony.exception.IllegalCharactersException;
import hegemony.exception.ParserFatalErrorException;
import hegemony.main.HegemonyCountry.PowerStatus;
import hegemony.main.HegemonyOrder.Unit;
import hegemony.main.HegemonyTerritory.Territory;
import hegemony.scanner.HegemonyScanner;
import hegemony.scanner.UnicodeEscapes;
import cup.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hegemony
{
	
	private static final String FILENAME_EXTENSION="-turno.txt"; 

	private static Map<String, HegemonyTerritory> map;
	private static Map<String, HegemonyCountry> countries;

	public static void main(String[] args)
	{
		String orderFilesPath = (args.length > 0 ? args[0] : "");
		if ((orderFilesPath.length() > 0) && (orderFilesPath.charAt(orderFilesPath.length() - 1) != '/'))
		{
			orderFilesPath = orderFilesPath + "/";
		}
		
		System.out.println("Generando Mapa de Hegemonía...");
		HegemonyInit init = new HegemonyInit();
		
		System.out.println("Mapa generado. Validando Mapa...");
		List<String> mapErrors = init.checkMap();
		
		if (mapErrors.size() != 0)
		{
			System.out.println("\nEncontrados " + mapErrors.size() + " errores en el mapa:");
			for (String error : mapErrors)
			{
				System.out.println(error);
			}
			System.out.println("\nTotal: " + mapErrors.size() + " errores\n");
			
			return;
		}
		
		
		map = init.getMap();
		countries = init.getCountries();

		// Count territories
		int landCount = 0;
		int seaCount = 0;
		int coastCount = 0;
		for (HegemonyTerritory ht : map.values())
		{
			if (ht.getType() == Territory.LAND)
			{
				landCount++;
			}
			else if (ht.getType() == Territory.COAST)
			{
				coastCount++;
			}
			else
			{
				seaCount++;
			}
		}
		
		// Count countries & get player country names
		int playerCount = 0;
		int minorCount = 0;
		List<String> playerNames = new ArrayList<String>();
		
		for (HegemonyCountry hc : countries.values())
		{
			if (hc.getPowerStatus() == PowerStatus.MAJOR)
			{
				playerCount++;
				playerNames.add(hc.getName());
			}
			else
			{
				minorCount++;
			}
		}
		
		System.out.println("\nTodo Ok, no hay errores en el Mapa de Hegemonía\n");
		System.out.println(map.size() + " territorios (" + landCount + " tierra, " + coastCount + " costa, " + seaCount + " mar)");
		System.out.println(countries.size() + " países (" + playerCount + " jugadores, " + minorCount + " menores)\n");
		System.out.println("Leyendo los ficheros de turnos de los jugadores...");
		
		// Read and scan player turn files
		Map<String, OrdersFile> playerOrders = new HashMap<String, OrdersFile>();
		Map<String, List<String>> playerErrors = new HashMap<String, List<String>>();
		List<String> errors;
		OrdersFile orders;
		String filename;
		
		for (String player : playerNames)
		{
      		try 
			{
      			filename = orderFilesPath + Util.normalizeName(player) + FILENAME_EXTENSION;
        		System.out.print("Leyendo fichero \'" + filename + "\'...");
        		HegemonyScanner s = new HegemonyScanner(new UnicodeEscapes(new FileReader(filename)));
        		parser p = new parser(s);

        		orders = (OrdersFile) p.parse().value;
				
				// Check this player errors
				errors = checkPlayerOrders(Util.normalizeName(player), orders);

				playerOrders.put(player, orders);
				playerErrors.put(player, errors);

        
        		System.out.println("Ok.");

			}
      		catch (FileNotFoundException e)
      		{
      			System.out.println("fichero no encontrado!");
      			playerOrders.put(player, null);
      			continue;
      		}
      		catch (IllegalCharactersException e)
      		{
      			System.out.println("fichero con errores de sintaxis!");
      			playerErrors.put(player, Util.convertIllegalCharacterErrorsToString(e.getErrors()));
      			continue;
      		}
      		catch (ParserFatalErrorException e)
      		{
      			System.out.println("fichero con errores de sintaxis!");
      			errors = new ArrayList<String>();
      			errors.add(e.getMessage());
      			playerErrors.put(player, errors);
      			continue;
      		}
			catch (Exception e) 
			{
        		e.printStackTrace(System.out);
        		System.exit(1);
      		}
		
		}
		
		System.out.println("\nValidando turnos...\n");
		for (String player : playerNames)
		{
			System.out.println("\n" + player);
			for (int i=0; i<player.length(); i++)
			{
				System.out.print("-");
			}
			System.out.println();
			
			errors = playerErrors.get(player);
			if (errors != null)
			{
			
				if (errors.size() > 0)
				{
					for (String e : errors)
					{
						System.out.println(e);
					}
					System.out.println("Total: " + errors.size() + " errores");
				}
				else
				{
					System.out.println("NO HAY ERRORES");
				}
			}
			else
			{
				System.out.println("El jugador no entregó fichero de turno");
			}
		}

	}
	
	private static List<String> checkPlayerOrders(String normalizedPlayerName, OrdersFile orders)
	{
		List<String> errors = new ArrayList<String>();
		OrdersFile o;
		HegemonyCountry c;
		HegemonyTerritory s, t;
		
		o = orders;
		while (o != null)
		{
			switch (o.order.getOrderType())
			{
				case DECLARE_PEACE:
					if (o.order.getNormalizedTarget().equals(normalizedPlayerName))
					{
						errors.add(o.order.prettyPrintEsp() + " -> No puede declararse la paz a sí mismo");
					}
					else if (countries.get((o.order.getNormalizedTarget())) == null)
					{
						errors.add(o.order.prettyPrintEsp() + " -> El país al que intenta declarar la paz no existe");
					}
				break;
			
				case DECLARE_WAR:
					if (o.order.getNormalizedTarget().equals(normalizedPlayerName))
					{
						errors.add(o.order.prettyPrintEsp() + " -> No puede declararse la guerra a sí mismo");
					}
					else if (countries.get((o.order.getNormalizedTarget())) == null)
					{
						errors.add(o.order.prettyPrintEsp() + " -> El país al que intenta declarar la guerra no existe");
					}
				break;
				
				case POLITIC_POINTS:
					c = countries.get(o.order.getNormalizedTarget());
					if (c == null)
					{
						errors.add(o.order.prettyPrintEsp() + " -> El país en el que intenta invertir puntos políticos no existe");
					}
					else if (c.getPowerStatus() == PowerStatus.MAJOR)
					{
						errors.add(o.order.prettyPrintEsp() + " -> No se pueden invertir puntos políticos en una Potencia Mayor");
					}
					else if ((o.order.getAmount() < 1) || (o.order.getAmount() > 100))
					{
						errors.add(o.order.prettyPrintEsp() + " -> La cantidad de puntos políticos que desea invertir es errónea");
					}
				break;
				
				case MOVE:
					s = map.get(o.order.getNormalizedSource());
					t = map.get(o.order.getNormalizedTarget());
					
					if (s == null)
					{
						errors.add(o.order.prettyPrintEsp() + " -> El territorio origen no existe");
					}
					else if (t == null)
					{
						errors.add(o.order.prettyPrintEsp() + " -> El territorio destino no existe");
					}
					else if (!s.isAdjacentToTerritory(t.getNormalizedName()))
					{
						errors.add(o.order.prettyPrintEsp() + " -> Los territorios origen y destino no son adyacentes");
					}
					else if ((s.getType() == Territory.LAND) && (o.order.getUnit() == Unit.NAVY))
					{
						
						errors.add(o.order.prettyPrintEsp() + " -> Una flota no puede estar en un territorio terrestre");
					}
					else if ((s.getType() == Territory.SEA) && (o.order.getUnit() == Unit.ARMY))
					{
						
						errors.add(o.order.prettyPrintEsp() + " -> Un ejército no puede estar en un territorio marítimo");
					}
					else if ((t.getType() == Territory.LAND) && (o.order.getUnit() == Unit.NAVY))
					{
						
						errors.add(o.order.prettyPrintEsp() + " -> Una flota no puede mover a un territorio terrestre");
					}
					else if ((t.getType() == Territory.SEA) && (o.order.getUnit() == Unit.ARMY))
					{
						errors.add(o.order.prettyPrintEsp() + " -> Un ejército no puede mover a un territorio marítimo");
					}
				break;

				case SUPPORT:
					s = map.get(o.order.getNormalizedSource());
					t = map.get(o.order.getNormalizedTarget());
					
					if (s == null)
					{
						errors.add(o.order.prettyPrintEsp() + " -> El territorio origen no existe");
					}
					else if (t == null)
					{
						errors.add(o.order.prettyPrintEsp() + " -> El territorio destino no existe");
					}
					else if (!s.isAdjacentToTerritory(t.getNormalizedName()))
					{
						errors.add(o.order.prettyPrintEsp() + " -> Los territorios origen y destino no son adyacentes");
					}
					else if ((s.getType() == Territory.LAND) && (o.order.getUnit() == Unit.NAVY))
					{
						
						errors.add(o.order.prettyPrintEsp() + " -> Una flota no puede estar en un territorio terrestre");
					}
					else if ((s.getType() == Territory.SEA) && (o.order.getUnit() == Unit.ARMY))
					{
						
						errors.add(o.order.prettyPrintEsp() + " -> Un ejército no puede estar en un territorio marítimo");
					}
					else if ((t.getType() == Territory.LAND) && (o.order.getUnit() == Unit.NAVY))
					{
						
						errors.add(o.order.prettyPrintEsp() + " -> Una flota no puede apoyar a un territorio terrestre");
					}
					else if ((t.getType() == Territory.SEA) && (o.order.getUnit() == Unit.ARMY))
					{
						errors.add(o.order.prettyPrintEsp() + " -> Un ejército no puede apoyar a un territorio marítimo");
					}
				break;
			}
			
			o = o.orders;
		}
		
		return errors;
	}
}
