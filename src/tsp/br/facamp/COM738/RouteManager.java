//TSP PROBLEM 
package tsp.br.facamp.COM738;

import java.util.ArrayList;

public class RouteManager {

	private static ArrayList<City> destination = new ArrayList<City>();
	
	public static void addCity(City city) {
		destination.add(city);
	}
	
	public static City getCity(int cod){
		return destination.get(cod);
	}
	
	public static int numberCities() {
		return destination.size();
	}

	
}
