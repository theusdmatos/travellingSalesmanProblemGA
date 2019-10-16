//TSP PROBLEM 
package tsp.br.facamp.COM738;

import java.util.ArrayList;
import java.util.Collections;

public class Route {
	//Armazena as cidades da rota 
	private ArrayList<City> route = new ArrayList<City>();
	private double fitness = 0;
	private double distance = 0;
	
	public Route() {
		for (int i = 0; i < RouteManager.numberCities(); i++) {
			route.add(null);
		}
	}
	
	public Route(ArrayList<City> _route) {
		route = _route;
	}
	
	public void generateIndividual() {
		for (int i = 0; i < RouteManager.numberCities(); i++) {
			setCity(i, RouteManager.getCity(i));
		}
		Collections.shuffle(route);
	}
	
	public void setCity(int position, City city) {
		route.set(position, city);
		fitness = 0;
		distance = 0;
	}
	
	public City getCity(int i) {
		return route.get(i);
	}
	
	public int routeSize() {
		return route.size();
	}
	
	public double getDistance() {
	if(distance == 0) {
		double routeDistance = 0;
		for (int i = 0; i < routeSize(); i++) {
			City fromCity = getCity(i);
			City destinationCity;
			
			if(i+1 < routeSize()) {
				destinationCity = getCity(i+1);
			} else {
				destinationCity = getCity(0);
			}
			routeDistance += fromCity.distanceToCity(destinationCity);
		}
		distance = routeDistance;
	}
	return distance;
	}
	
	public double getFitness() {
		if(fitness == 0) {
			fitness = 1/(double) getDistance();
		}
		return fitness;
	}
	
	public boolean containsCity(City city) {
		return route.contains(city);
	}

	@Override
	public String toString() {
		return "Route [route=" + route + ", fitness=" + fitness + ", distance=" + distance + "]";
	}
	
	
}
