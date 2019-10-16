//TSP PROBLEM 

package ga.br.facamp.COM738;

import tsp.br.facamp.COM738.Route;

public class Population {

	Route[] routes;
	
	public Population(int popSize, boolean init) {
		routes = new Route[popSize];
		if(init) {
			for (int i = 0; i < populationSize() ; i++) {
			Route newRoute = new Route();
			newRoute.generateIndividual();
			saveRoute(i, newRoute);
			}
		}
	}
	
	public int populationSize(){
		return routes.length;
	}
	
	public void saveRoute(int i, Route route) {
		routes[i] = route;
	}
	
	public Route getRoute(int i) {
		return routes[i];
	}
	
	public Route getBestRoute() {
		Route bestRoute = getRoute(0);
		for(int i = 1; i < populationSize(); i++) {
			if(bestRoute.getFitness() <= getRoute(i).getFitness()) {
				bestRoute = getRoute(i);
			}
		}
		return bestRoute;
	}
}
