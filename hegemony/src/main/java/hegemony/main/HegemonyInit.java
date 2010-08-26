package hegemony.main;

import hegemony.main.HegemonyCountry.PowerStatus;
import hegemony.main.HegemonyTerritory.Territory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HegemonyInit
{
	
	private Map<String, HegemonyTerritory> hegemonyMap = new HashMap<String, HegemonyTerritory>();
	private Map<String, HegemonyCountry> hegemonyCountries = new HashMap<String, HegemonyCountry>();
	
	public HegemonyInit()
	{

		/** Generate countries **/
		HegemonyCountry hc;
		
		// Major countries (players)
		hc = new HegemonyCountry("España", PowerStatus.MAJOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Francia", PowerStatus.MAJOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Inglaterra", PowerStatus.MAJOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Prusia", PowerStatus.MAJOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Austria", PowerStatus.MAJOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Rusia", PowerStatus.MAJOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Turquía", PowerStatus.MAJOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		
		// Minor countries
		hc = new HegemonyCountry("Portugal", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Países Bajos", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Suecia", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Dinamarca", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Sajonia", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Palatinado", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Baviera", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Saboya", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Venecia", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Nápoles", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		hc = new HegemonyCountry("Libia", PowerStatus.MINOR);
		hegemonyCountries.put(hc.getNormalizedName(), hc);
		
		
		/** Generate map (territory adjacencies) **/
		HegemonyTerritory ht;
		
		// Declare sea territories
		ht = new HegemonyTerritory("Atlántico Norte", Territory.SEA);
		ht.addAdjacentTerritory("Mar de Noruega");
		ht.addAdjacentTerritory("Edimburgo");
		ht.addAdjacentTerritory("Irlanda");
		ht.addAdjacentTerritory("Mar de Irlanda");
		ht.addAdjacentTerritory("Atlántico Central");
		ht.addAdjacentTerritory("Bahía de Vizcaya");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Atlántico Central", Territory.SEA);
		ht.addAdjacentTerritory("Atlántico Norte");
		ht.addAdjacentTerritory("Bahía de Vizcaya");
		ht.addAdjacentTerritory("Atlántico Sur");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Atlántico Sur", Territory.SEA);
		ht.addAdjacentTerritory("Atlántico Central");
		ht.addAdjacentTerritory("Bahía de Vizcaya");
		ht.addAdjacentTerritory("León");
		ht.addAdjacentTerritory("Portugal");
		ht.addAdjacentTerritory("Mediterráneo Occidental");
		ht.addAdjacentTerritory("Cádiz");
		ht.addAdjacentTerritory("Marruecos");		
		ht.addAdjacentTerritory("Canarias");		
		hegemonyMap.put(ht.getNormalizedName(), ht);

		ht = new HegemonyTerritory("Canarias", Territory.SEA);
		ht.addAdjacentTerritory("Atlántico Sur");
		ht.addAdjacentTerritory("Marruecos");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		ht = new HegemonyTerritory("Mar de Irlanda", Territory.SEA);
		ht.addAdjacentTerritory("Atlántico Norte");
		ht.addAdjacentTerritory("Irlanda");
		ht.addAdjacentTerritory("Edimburgo");
		ht.addAdjacentTerritory("Yorkshire");
		ht.addAdjacentTerritory("Gales");
		ht.addAdjacentTerritory("Canal Inglés");
		ht.addAdjacentTerritory("Bahía de Vizcaya");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Canal Inglés", Territory.SEA);
		ht.addAdjacentTerritory("Mar de Irlanda");
		ht.addAdjacentTerritory("Bahía de Vizcaya");
		ht.addAdjacentTerritory("Gales");
		ht.addAdjacentTerritory("Londres");
		ht.addAdjacentTerritory("Mar del Norte");
		ht.addAdjacentTerritory("Brest");
		ht.addAdjacentTerritory("Picardía");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Bahía de Vizcaya", Territory.SEA);
		ht.addAdjacentTerritory("Atlántico Norte");
		ht.addAdjacentTerritory("Atlántico Central");
		ht.addAdjacentTerritory("Atlántico Sur");
		ht.addAdjacentTerritory("Mar de Irlanda");
		ht.addAdjacentTerritory("Canal Inglés");
		ht.addAdjacentTerritory("Brest");
		ht.addAdjacentTerritory("Gascuña");
		ht.addAdjacentTerritory("León");
		ht.addAdjacentTerritory("Portugal");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		ht = new HegemonyTerritory("Mar del Norte", Territory.SEA);
		ht.addAdjacentTerritory("Mar de Noruega");
		ht.addAdjacentTerritory("Edimburgo");
		ht.addAdjacentTerritory("Yorkshire");
		ht.addAdjacentTerritory("Londres");
		ht.addAdjacentTerritory("Canal Inglés");
		ht.addAdjacentTerritory("Picardía");
		ht.addAdjacentTerritory("Bélgica");
		ht.addAdjacentTerritory("Paises Bajos");
		ht.addAdjacentTerritory("Skagerrak");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Mar de Noruega", Territory.SEA);
		ht.addAdjacentTerritory("Atlántico Norte");
		ht.addAdjacentTerritory("Edimburgo");
		ht.addAdjacentTerritory("Mar del Norte");
		ht.addAdjacentTerritory("Skagerrak");
		ht.addAdjacentTerritory("Noruega");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		ht = new HegemonyTerritory("Skagerrak", Territory.SEA);
		ht.addAdjacentTerritory("Noruega");
		ht.addAdjacentTerritory("Mar de Noruega");
		ht.addAdjacentTerritory("Mar del Norte");
		ht.addAdjacentTerritory("Paises Bajos");
		ht.addAdjacentTerritory("Hannover");
		ht.addAdjacentTerritory("Dinamarca");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Mar Báltico Sur", Territory.SEA);
		ht.addAdjacentTerritory("Suecia");
		ht.addAdjacentTerritory("Dinamarca");
		ht.addAdjacentTerritory("Hannover");
		ht.addAdjacentTerritory("Berlín");
		ht.addAdjacentTerritory("Danzing");
		ht.addAdjacentTerritory("Prusia");
		ht.addAdjacentTerritory("Lituania");
		ht.addAdjacentTerritory("Mar Báltico Norte");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Mar Báltico Norte", Territory.SEA);
		ht.addAdjacentTerritory("Finlandia");
		ht.addAdjacentTerritory("Suecia");
		ht.addAdjacentTerritory("Mar Báltico Sur");
		ht.addAdjacentTerritory("Lituania");
		ht.addAdjacentTerritory("San Petersburgo");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Golfo de León", Territory.SEA);
		ht.addAdjacentTerritory("Marsella");
		ht.addAdjacentTerritory("Gascuña");
		ht.addAdjacentTerritory("Barcelona");
		ht.addAdjacentTerritory("Cartagena");
		ht.addAdjacentTerritory("Mediterráneo Occidental");
		ht.addAdjacentTerritory("Cerdeña");
		ht.addAdjacentTerritory("Mar Tirreno");
		ht.addAdjacentTerritory("Saboya");
		ht.addAdjacentTerritory("Alpes");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Mediterráneo Occidental", Territory.SEA);
		ht.addAdjacentTerritory("Golfo de León");
		ht.addAdjacentTerritory("Cartagena");
		ht.addAdjacentTerritory("Cádiz");
		ht.addAdjacentTerritory("Atlántico Sur");
		ht.addAdjacentTerritory("Marruecos");
		ht.addAdjacentTerritory("Argelia");
		ht.addAdjacentTerritory("Mar de Túnez");
		ht.addAdjacentTerritory("Cerdeña");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Mar Tirreno", Territory.SEA);
		ht.addAdjacentTerritory("Toscana");
		ht.addAdjacentTerritory("Milán");
		ht.addAdjacentTerritory("Saboya");
		ht.addAdjacentTerritory("Golfo de León");
		ht.addAdjacentTerritory("Cerdeña");
		ht.addAdjacentTerritory("Mar de Túnez");
		ht.addAdjacentTerritory("Sicilia");
		ht.addAdjacentTerritory("Mar Jónico");
		ht.addAdjacentTerritory("Nápoles");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		ht = new HegemonyTerritory("Mar de Túnez", Territory.SEA);
		ht.addAdjacentTerritory("Mar Tirreno");
		ht.addAdjacentTerritory("Cerdeña");
		ht.addAdjacentTerritory("Mediterráneo Occidental");
		ht.addAdjacentTerritory("Argelia");
		ht.addAdjacentTerritory("Libia");
		ht.addAdjacentTerritory("Mar Jónico");
		ht.addAdjacentTerritory("Sicilia");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		ht = new HegemonyTerritory("Mar Adriático", Territory.SEA);
		ht.addAdjacentTerritory("Dalmacia");
		ht.addAdjacentTerritory("Venecia");
		ht.addAdjacentTerritory("Toscana");
		ht.addAdjacentTerritory("Nápoles");
		ht.addAdjacentTerritory("Mar Jónico");
		ht.addAdjacentTerritory("Balcanes");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Mar Jónico", Territory.SEA);
		ht.addAdjacentTerritory("Mar Adriático");
		ht.addAdjacentTerritory("Nápoles");
		ht.addAdjacentTerritory("Mar Tirreno");
		ht.addAdjacentTerritory("Sicilia");
		ht.addAdjacentTerritory("Mar de Túnez");
		ht.addAdjacentTerritory("Libia");
		ht.addAdjacentTerritory("Mediterráneo Oriental");
		ht.addAdjacentTerritory("Mar Egeo");
		ht.addAdjacentTerritory("Balcanes");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Mar Egeo", Territory.SEA);
		ht.addAdjacentTerritory("Constantinopla");
		ht.addAdjacentTerritory("Balcanes");
		ht.addAdjacentTerritory("Mar Jónico");
		ht.addAdjacentTerritory("Mediterráneo Oriental");
		ht.addAdjacentTerritory("Esmirna");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Mar Negro", Territory.SEA);
		ht.addAdjacentTerritory("Azov");
		ht.addAdjacentTerritory("Bessarabia");
		ht.addAdjacentTerritory("Constantinopla");
		ht.addAdjacentTerritory("Trabzón");
		ht.addAdjacentTerritory("Cosacos");
		ht.addAdjacentTerritory("Don");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		ht = new HegemonyTerritory("Mediterráneo Oriental", Territory.SEA);
		ht.addAdjacentTerritory("Esmirna");
		ht.addAdjacentTerritory("Mar Egeo");
		ht.addAdjacentTerritory("Mar Jónico");
		ht.addAdjacentTerritory("Libia");
		ht.addAdjacentTerritory("Egipto");
		ht.addAdjacentTerritory("Oriente Medio");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		
		// Spanish territories
		ht = new HegemonyTerritory("León", Territory.COAST);
		ht.addAdjacentTerritory("Bahía de Vizcaya");
		ht.addAdjacentTerritory("Atlántico Sur");
		ht.addAdjacentTerritory("Portugal");
		ht.addAdjacentTerritory("Madrid");
		ht.addAdjacentTerritory("Cartagena");
		ht.addAdjacentTerritory("Barcelona");
		ht.addAdjacentTerritory("Gascuña");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Madrid", Territory.LAND);
		ht.addAdjacentTerritory("León");
		ht.addAdjacentTerritory("Portugal");
		ht.addAdjacentTerritory("Cádiz");
		ht.addAdjacentTerritory("Cartagena");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Barcelona", Territory.COAST);
		ht.addAdjacentTerritory("Gascuña");
		ht.addAdjacentTerritory("León");
		ht.addAdjacentTerritory("Cartagena");
		ht.addAdjacentTerritory("Golfo de León");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Cartagena", Territory.COAST);
		ht.addAdjacentTerritory("León");
		ht.addAdjacentTerritory("Madrid");
		ht.addAdjacentTerritory("Cádiz");
		ht.addAdjacentTerritory("Mediterráneo Occidental");
		ht.addAdjacentTerritory("Golfo de León");
		ht.addAdjacentTerritory("Barcelona");	
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Cádiz", Territory.COAST);
		ht.addAdjacentTerritory("Madrid");
		ht.addAdjacentTerritory("Portugal");
		ht.addAdjacentTerritory("Atlántico Sur");
		ht.addAdjacentTerritory("Marruecos");
		ht.addAdjacentTerritory("Mediterráneo Occidental");
		ht.addAdjacentTerritory("Cartagena");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Marruecos", Territory.COAST);
		ht.addAdjacentTerritory("Cádiz");
		ht.addAdjacentTerritory("Atlántico Sur");
		ht.addAdjacentTerritory("Canarias");
		ht.addAdjacentTerritory("Argelia");
		ht.addAdjacentTerritory("Mediterráneo Occidental");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		// French territories
		ht = new HegemonyTerritory("Brest", Territory.COAST);
		ht.addAdjacentTerritory("Canal Inglés");
		ht.addAdjacentTerritory("Bahía de Vizcaya");
		ht.addAdjacentTerritory("Gascuña");
		ht.addAdjacentTerritory("Marsella");
		ht.addAdjacentTerritory("París");
		ht.addAdjacentTerritory("Picardía");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Picardía", Territory.COAST);
		ht.addAdjacentTerritory("Canal Inglés");
		ht.addAdjacentTerritory("Brest");
		ht.addAdjacentTerritory("París");
		ht.addAdjacentTerritory("Burgandía");
		ht.addAdjacentTerritory("Palatinado");
		ht.addAdjacentTerritory("Bélgica");
		ht.addAdjacentTerritory("Mar del Norte");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Bélgica", Territory.COAST);
		ht.addAdjacentTerritory("Mar del Norte");
		ht.addAdjacentTerritory("Picardía");
		ht.addAdjacentTerritory("Palatinado");
		ht.addAdjacentTerritory("Paises Bajos");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("París", Territory.LAND);
		ht.addAdjacentTerritory("Picardía");
		ht.addAdjacentTerritory("Brest");
		ht.addAdjacentTerritory("Marsella");
		ht.addAdjacentTerritory("Burgandía");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Burgandía", Territory.LAND);
		ht.addAdjacentTerritory("Picardía");
		ht.addAdjacentTerritory("París");
		ht.addAdjacentTerritory("Marsella");
		ht.addAdjacentTerritory("Alpes");
		ht.addAdjacentTerritory("Suiza");
		ht.addAdjacentTerritory("Suabia");
		ht.addAdjacentTerritory("Palatinado");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Gascuña", Territory.COAST);
		ht.addAdjacentTerritory("Brest");
		ht.addAdjacentTerritory("Bahía de Vizcaya");
		ht.addAdjacentTerritory("León");
		ht.addAdjacentTerritory("Barcelona");
		ht.addAdjacentTerritory("Golfo de León");
		ht.addAdjacentTerritory("Marsella");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Marsella", Territory.COAST);
		ht.addAdjacentTerritory("París");
		ht.addAdjacentTerritory("Brest");
		ht.addAdjacentTerritory("Gascuña");
		ht.addAdjacentTerritory("Golfo de León");
		ht.addAdjacentTerritory("Alpes");
		ht.addAdjacentTerritory("Burgandía");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Alpes", Territory.COAST);
		ht.addAdjacentTerritory("Burgandía");
		ht.addAdjacentTerritory("Marsella");
		ht.addAdjacentTerritory("Golfo de León");
		ht.addAdjacentTerritory("Saboya");
		ht.addAdjacentTerritory("Suiza");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		// English territories
		ht = new HegemonyTerritory("Irlanda", Territory.COAST);
		ht.addAdjacentTerritory("Atlántico Norte");
		ht.addAdjacentTerritory("Mar de Irlanda");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Edimburgo", Territory.COAST);
		ht.addAdjacentTerritory("Atlántico Norte");
		ht.addAdjacentTerritory("Mar de Irlanda");
		ht.addAdjacentTerritory("Yorkshire");
		ht.addAdjacentTerritory("Mar del Norte");
		ht.addAdjacentTerritory("Mar de Noruega");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Yorkshire", Territory.COAST);
		ht.addAdjacentTerritory("Edimburgo");
		ht.addAdjacentTerritory("Mar de Irlanda");
		ht.addAdjacentTerritory("Gales");
		ht.addAdjacentTerritory("Londres");
		ht.addAdjacentTerritory("Mar del Norte");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Gales", Territory.COAST);
		ht.addAdjacentTerritory("Mar de Irlanda");
		ht.addAdjacentTerritory("Canal Inglés");
		ht.addAdjacentTerritory("Londres");
		ht.addAdjacentTerritory("Yorkshire");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Londres", Territory.COAST);
		ht.addAdjacentTerritory("Yorkshire");
		ht.addAdjacentTerritory("Gales");
		ht.addAdjacentTerritory("Canal Inglés");
		ht.addAdjacentTerritory("Mar del Norte");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Hannover", Territory.COAST);
		ht.addAdjacentTerritory("Skagerrak");
		ht.addAdjacentTerritory("Paises Bajos");
		ht.addAdjacentTerritory("Hessen");
		ht.addAdjacentTerritory("Berlín");
		ht.addAdjacentTerritory("Mar Báltico Sur");
		ht.addAdjacentTerritory("Dinamarca");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		// Prussian territories
		ht = new HegemonyTerritory("Hessen", Territory.LAND);
		ht.addAdjacentTerritory("Hannover");
		ht.addAdjacentTerritory("Paises Bajos");
		ht.addAdjacentTerritory("Palatinado");
		ht.addAdjacentTerritory("Wurzburg");
		ht.addAdjacentTerritory("Sajonia");
		ht.addAdjacentTerritory("Berlín");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Berlin", Territory.COAST);
		ht.addAdjacentTerritory("Mar Báltico Sur");
		ht.addAdjacentTerritory("Hannover");
		ht.addAdjacentTerritory("Hessen");
		ht.addAdjacentTerritory("Sajonia");
		ht.addAdjacentTerritory("Silesia");
		ht.addAdjacentTerritory("Danzing");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Danzing", Territory.COAST);
		ht.addAdjacentTerritory("Mar Báltico Sur");
		ht.addAdjacentTerritory("Berlín");
		ht.addAdjacentTerritory("Silesia");
		ht.addAdjacentTerritory("Polonia");
		ht.addAdjacentTerritory("Prusia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Prusia", Territory.COAST);
		ht.addAdjacentTerritory("Mar Báltico Sur");
		ht.addAdjacentTerritory("Danzing");
		ht.addAdjacentTerritory("Polonia");
		ht.addAdjacentTerritory("Lituania");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Silesia", Territory.LAND);
		ht.addAdjacentTerritory("Danzing");
		ht.addAdjacentTerritory("Berlín");
		ht.addAdjacentTerritory("Sajonia");
		ht.addAdjacentTerritory("Bohemia");
		ht.addAdjacentTerritory("Eslovaquia");
		ht.addAdjacentTerritory("Polonia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		// Austrian territories
		ht = new HegemonyTerritory("Bohemia", Territory.LAND);
		ht.addAdjacentTerritory("Sajonia");
		ht.addAdjacentTerritory("Wurzburg");
		ht.addAdjacentTerritory("Baviera");
		ht.addAdjacentTerritory("Viena");
		ht.addAdjacentTerritory("Eslovaquia");
		ht.addAdjacentTerritory("Silesia");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		ht = new HegemonyTerritory("Budapest", Territory.LAND);
		ht.addAdjacentTerritory("Eslovaquia");
		ht.addAdjacentTerritory("Viena");
		ht.addAdjacentTerritory("Dalmacia");
		ht.addAdjacentTerritory("Transilvania");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Eslovaquia", Territory.LAND);
		ht.addAdjacentTerritory("Silesia");
		ht.addAdjacentTerritory("Bohemia");
		ht.addAdjacentTerritory("Budapest");
		ht.addAdjacentTerritory("Viena");
		ht.addAdjacentTerritory("Transilvania");
		ht.addAdjacentTerritory("Galitzia");
		ht.addAdjacentTerritory("Polonia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Galitzia", Territory.LAND);
		ht.addAdjacentTerritory("Polonia");
		ht.addAdjacentTerritory("Eslovaquia");
		ht.addAdjacentTerritory("Transilvania");
		ht.addAdjacentTerritory("Bessarabia");
		ht.addAdjacentTerritory("Ucrania");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Tirol", Territory.LAND);
		ht.addAdjacentTerritory("Baviera");
		ht.addAdjacentTerritory("Suabia");
		ht.addAdjacentTerritory("Suiza");
		ht.addAdjacentTerritory("Milán");
		ht.addAdjacentTerritory("Venecia");
		ht.addAdjacentTerritory("Dalmacia");
		ht.addAdjacentTerritory("Viena");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Dalmacia", Territory.COAST);
		ht.addAdjacentTerritory("Viena");
		ht.addAdjacentTerritory("Tirol");
		ht.addAdjacentTerritory("Venecia");
		ht.addAdjacentTerritory("Mar Adriático");
		ht.addAdjacentTerritory("Balcanes");
		ht.addAdjacentTerritory("Transilvania");
		ht.addAdjacentTerritory("Budapest");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Viena", Territory.LAND);
		ht.addAdjacentTerritory("Bohemia");
		ht.addAdjacentTerritory("Baviera");
		ht.addAdjacentTerritory("Tirol");
		ht.addAdjacentTerritory("Dalmacia");
		ht.addAdjacentTerritory("Budapest");
		ht.addAdjacentTerritory("Eslovaquia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Transilvania", Territory.LAND);
		ht.addAdjacentTerritory("Eslovaquia");
		ht.addAdjacentTerritory("Budapest");
		ht.addAdjacentTerritory("Dalmacia");
		ht.addAdjacentTerritory("Balcanes");
		ht.addAdjacentTerritory("Constantinopla");
		ht.addAdjacentTerritory("Bessarabia");
		ht.addAdjacentTerritory("Galitzia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		// Russian territories
		ht = new HegemonyTerritory("Tundra", Territory.LAND);
		ht.addAdjacentTerritory("Finlandia");
		ht.addAdjacentTerritory("San Petersburgo");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		ht = new HegemonyTerritory("San Petersburgo", Territory.COAST);
		ht.addAdjacentTerritory("Finlandia");
		ht.addAdjacentTerritory("Mar Báltico Norte");
		ht.addAdjacentTerritory("Lituania");
		ht.addAdjacentTerritory("Moscú");
		ht.addAdjacentTerritory("Cosacos");
		ht.addAdjacentTerritory("Tundra");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Lituania", Territory.COAST);
		ht.addAdjacentTerritory("Mar Báltico Norte");
		ht.addAdjacentTerritory("Mar Báltico Sur");
		ht.addAdjacentTerritory("Prusia");
		ht.addAdjacentTerritory("Polonia");
		ht.addAdjacentTerritory("Ucrania");
		ht.addAdjacentTerritory("Moscú");
		ht.addAdjacentTerritory("San Petersburgo");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Moscú", Territory.LAND);
		ht.addAdjacentTerritory("San Petersburgo");
		ht.addAdjacentTerritory("Lituania");
		ht.addAdjacentTerritory("Ucrania");
		ht.addAdjacentTerritory("Don");
		ht.addAdjacentTerritory("Cosacos");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Cosacos", Territory.COAST);
		ht.addAdjacentTerritory("San Petersburgo");
		ht.addAdjacentTerritory("Moscú");
		ht.addAdjacentTerritory("Don");
		ht.addAdjacentTerritory("Mar Negro");
		ht.addAdjacentTerritory("Trabzón");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Ucrania", Territory.LAND);
		ht.addAdjacentTerritory("Lituania");
		ht.addAdjacentTerritory("Polonia");
		ht.addAdjacentTerritory("Galitzia");
		ht.addAdjacentTerritory("Bessarabia");
		ht.addAdjacentTerritory("Azov");
		ht.addAdjacentTerritory("Don");
		ht.addAdjacentTerritory("Moscú");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Don", Territory.COAST);
		ht.addAdjacentTerritory("Moscú");
		ht.addAdjacentTerritory("Ucrania");
		ht.addAdjacentTerritory("Azov");
		ht.addAdjacentTerritory("Mar Negro");
		ht.addAdjacentTerritory("Cosacos");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		// Turkish territories
		ht = new HegemonyTerritory("Azov", Territory.COAST);
		ht.addAdjacentTerritory("Ucrania");
		ht.addAdjacentTerritory("Bessarabia");
		ht.addAdjacentTerritory("Mar Negro");
		ht.addAdjacentTerritory("Don");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Bessarabia", Territory.COAST);
		ht.addAdjacentTerritory("Ucrania");
		ht.addAdjacentTerritory("Galitzia");
		ht.addAdjacentTerritory("Transilvania");
		ht.addAdjacentTerritory("Constantinopla");
		ht.addAdjacentTerritory("Mar Negro");
		ht.addAdjacentTerritory("Azov");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Constantinopla", Territory.COAST);
		ht.addAdjacentTerritory("Transilvania");
		ht.addAdjacentTerritory("Balcanes");
		ht.addAdjacentTerritory("Mar Egeo");
		ht.addAdjacentTerritory("Esmirna");
		ht.addAdjacentTerritory("Trabzón");
		ht.addAdjacentTerritory("Mar Negro");
		ht.addAdjacentTerritory("Bessarabia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Balcanes", Territory.COAST);
		ht.addAdjacentTerritory("Dalmacia");
		ht.addAdjacentTerritory("Mar Adriático");
		ht.addAdjacentTerritory("Mar Jónico");
		ht.addAdjacentTerritory("Mar Egeo");
		ht.addAdjacentTerritory("Constantinopla");
		ht.addAdjacentTerritory("Transilvania");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Trabzón", Territory.COAST);
		ht.addAdjacentTerritory("Mar Negro");
		ht.addAdjacentTerritory("Constantinopla");
		ht.addAdjacentTerritory("Esmirna");
		ht.addAdjacentTerritory("Oriente Medio");
		ht.addAdjacentTerritory("Cosacos");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Esmirna", Territory.COAST);
		ht.addAdjacentTerritory("Constantinopla");
		ht.addAdjacentTerritory("Mar Egeo");
		ht.addAdjacentTerritory("Mediterráneo Oriental");
		ht.addAdjacentTerritory("Oriente Medio");
		ht.addAdjacentTerritory("Trabzón");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Oriente Medio", Territory.COAST);
		ht.addAdjacentTerritory("Trabzón");
		ht.addAdjacentTerritory("Esmirna");
		ht.addAdjacentTerritory("Mediterráneo Oriental");
		ht.addAdjacentTerritory("Egipto");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Egipto", Territory.COAST);
		ht.addAdjacentTerritory("Mediterráneo Oriental");
		ht.addAdjacentTerritory("Libia");
		ht.addAdjacentTerritory("Oriente Medio");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		// Italian minors
		ht = new HegemonyTerritory("Saboya", Territory.COAST);
		ht.addAdjacentTerritory("Suiza");
		ht.addAdjacentTerritory("Alpes");
		ht.addAdjacentTerritory("Golfo de León");
		ht.addAdjacentTerritory("Mar Tirreno");
		ht.addAdjacentTerritory("Milán");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Milán", Territory.COAST);
		ht.addAdjacentTerritory("Suiza");
		ht.addAdjacentTerritory("Saboya");
		ht.addAdjacentTerritory("Mar Tirreno");
		ht.addAdjacentTerritory("Toscana");
		ht.addAdjacentTerritory("Venecia");
		ht.addAdjacentTerritory("Tirol");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Cerdeña", Territory.COAST);
		ht.addAdjacentTerritory("Golfo de León");
		ht.addAdjacentTerritory("Mediterráneo Occidental");
		ht.addAdjacentTerritory("Mar de Túnez");
		ht.addAdjacentTerritory("Mar Tirreno");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Venecia", Territory.COAST);
		ht.addAdjacentTerritory("Tirol");
		ht.addAdjacentTerritory("Milán");
		ht.addAdjacentTerritory("Toscana");
		ht.addAdjacentTerritory("Mar Adriático");
		ht.addAdjacentTerritory("Dalmacia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Toscana", Territory.COAST);
		ht.addAdjacentTerritory("Venecia");
		ht.addAdjacentTerritory("Milán");
		ht.addAdjacentTerritory("Mar Tirreno");
		ht.addAdjacentTerritory("Nápoles");
		ht.addAdjacentTerritory("Mar Adriático");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Nápoles", Territory.COAST);
		ht.addAdjacentTerritory("Mar Adriático");
		ht.addAdjacentTerritory("Toscana");
		ht.addAdjacentTerritory("Mar Tirreno");
		ht.addAdjacentTerritory("Mar Jónico");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Sicilia", Territory.COAST);
		ht.addAdjacentTerritory("Mar Tirreno");
		ht.addAdjacentTerritory("Mar de Túnez");
		ht.addAdjacentTerritory("Mar Jónico");
		hegemonyMap.put(ht.getNormalizedName(), ht);

		// Scandinavian minors
		ht = new HegemonyTerritory("Noruega", Territory.COAST);
		ht.addAdjacentTerritory("Mar de Noruega");
		ht.addAdjacentTerritory("Skagerrak");
		ht.addAdjacentTerritory("Dinamarca");
		ht.addAdjacentTerritory("Suecia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Dinamarca", Territory.COAST);
		ht.addAdjacentTerritory("Noruega");
		ht.addAdjacentTerritory("Skagerrak");
		ht.addAdjacentTerritory("Hannover");
		ht.addAdjacentTerritory("Mar Báltico Sur");
		ht.addAdjacentTerritory("Suecia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Suecia", Territory.COAST);
		ht.addAdjacentTerritory("Noruega");
		ht.addAdjacentTerritory("Dinamarca");
		ht.addAdjacentTerritory("Mar Báltico Sur");
		ht.addAdjacentTerritory("Mar Báltico Norte");
		ht.addAdjacentTerritory("Finlandia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Finlandia", Territory.COAST);
		ht.addAdjacentTerritory("Suecia");
		ht.addAdjacentTerritory("Mar Báltico Norte");
		ht.addAdjacentTerritory("San Petersburgo");
		ht.addAdjacentTerritory("Tundra");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		// German minors
		ht = new HegemonyTerritory("Palatinado", Territory.LAND);
		ht.addAdjacentTerritory("Paises Bajos");
		ht.addAdjacentTerritory("Bélgica");
		ht.addAdjacentTerritory("Picardía");
		ht.addAdjacentTerritory("Burgandía");
		ht.addAdjacentTerritory("Suabia");
		ht.addAdjacentTerritory("Wurzburg");
		ht.addAdjacentTerritory("Hessen");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Suabia", Territory.LAND);
		ht.addAdjacentTerritory("Palatinado");
		ht.addAdjacentTerritory("Burgandía");
		ht.addAdjacentTerritory("Suiza");
		ht.addAdjacentTerritory("Tirol");
		ht.addAdjacentTerritory("Baviera");
		ht.addAdjacentTerritory("Wurzburg");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Wurzburg", Territory.LAND);
		ht.addAdjacentTerritory("Hessen");
		ht.addAdjacentTerritory("Palatinado");
		ht.addAdjacentTerritory("Suabia");
		ht.addAdjacentTerritory("Baviera");
		ht.addAdjacentTerritory("Bohemia");
		ht.addAdjacentTerritory("Sajonia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Baviera", Territory.LAND);
		ht.addAdjacentTerritory("Wurzburg");
		ht.addAdjacentTerritory("Suabia");
		ht.addAdjacentTerritory("Tirol");
		ht.addAdjacentTerritory("Viena");
		ht.addAdjacentTerritory("Bohemia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Sajonia", Territory.LAND);
		ht.addAdjacentTerritory("Berlín");
		ht.addAdjacentTerritory("Hessen");
		ht.addAdjacentTerritory("Wurzburg");
		ht.addAdjacentTerritory("Bohemia");
		ht.addAdjacentTerritory("Silesia");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		// North African minors
		ht = new HegemonyTerritory("Argelia", Territory.COAST);
		ht.addAdjacentTerritory("Mediterráneo Occidental");
		ht.addAdjacentTerritory("Marruecos");
		ht.addAdjacentTerritory("Libia");
		ht.addAdjacentTerritory("Mar de Túnez");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Libia", Territory.COAST);
		ht.addAdjacentTerritory("Mar de Túnez");
		ht.addAdjacentTerritory("Argelia");
		ht.addAdjacentTerritory("Egipto");
		ht.addAdjacentTerritory("Mediterráneo Oriental");
		ht.addAdjacentTerritory("Mar Jónico");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		// Other one province minors
		ht = new HegemonyTerritory("Paises Bajos", Territory.COAST);
		ht.addAdjacentTerritory("Mar del Norte");
		ht.addAdjacentTerritory("Bélgica");
		ht.addAdjacentTerritory("Palatinado");
		ht.addAdjacentTerritory("Hessen");
		ht.addAdjacentTerritory("Hannover");
		ht.addAdjacentTerritory("Skagerrak");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Portugal", Territory.COAST);
		ht.addAdjacentTerritory("Bahía de Vizcaya");
		ht.addAdjacentTerritory("Atlántico Sur");
		ht.addAdjacentTerritory("Cádiz");
		ht.addAdjacentTerritory("Madrid");
		ht.addAdjacentTerritory("León");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		// Neutral provinces
		ht = new HegemonyTerritory("Suiza", Territory.LAND);
		ht.addAdjacentTerritory("Suabia");
		ht.addAdjacentTerritory("Burgandía");
		ht.addAdjacentTerritory("Alpes");
		ht.addAdjacentTerritory("Saboya");
		ht.addAdjacentTerritory("Milán");
		ht.addAdjacentTerritory("Tirol");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
		ht = new HegemonyTerritory("Polonia", Territory.LAND);
		ht.addAdjacentTerritory("Prusia");
		ht.addAdjacentTerritory("Danzing");
		ht.addAdjacentTerritory("Silesia");
		ht.addAdjacentTerritory("Eslovaquia");
		ht.addAdjacentTerritory("Galitzia");
		ht.addAdjacentTerritory("Ucrania");
		ht.addAdjacentTerritory("Lituania");
		hegemonyMap.put(ht.getNormalizedName(), ht);
		
	}
	
	public Map<String, HegemonyCountry> getCountries()
	{
		return hegemonyCountries;
	}
	
	public Map<String, HegemonyTerritory> getMap()
	{
		return hegemonyMap;
	}
		

	public List<String> checkMap()
	{
		List<String> errors = new ArrayList<String>();
		
		for (HegemonyTerritory ht : hegemonyMap.values())
		{
			for (String name : ht.getAdjacentTerritories())
			{
				if (hegemonyMap.get(name) == null)	// Check if adjacent territories exist
				{
					errors.add("\'" + ht.getName() + "\': adjacent territory \'" + name + "\' doesn't exist");
				}
				else if (!hegemonyMap.get(name).isAdjacentToTerritory(ht.getName()))		// Check adjacency reciprocity
				{
					errors.add("\'" + ht.getName() + "\': no adjacency reciprocity with territory \'" + name + "\'");					
				}
			}
		}
		
		return errors;
	}
	
}
