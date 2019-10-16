//TSP AND BINPACKING PROBLEM

package ga.br.facamp.COM738;
import tsp.br.facamp.COM738.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;




public class Ga {

	private static int mutation = 0;
	private static double mutationRate = 0.0015;
	private static int tournamentSize = 5;
	private static boolean elitism = true;
	
	public static Population evolvePop(Population population) {
		int setElitism = 0;
		Population newPopulation = new Population(population.populationSize(), false);
		if(elitism) {
			newPopulation.saveRoute(0, population.getBestRoute());
			setElitism = 1;
		}
		
		for(int i = setElitism; i < newPopulation.populationSize(); i++) {
		Route badassOne = tournamentRollet(population);
		Route badassTwo = tournamentRollet(population);
		
		Route sonFuck = crossover(badassOne, badassTwo); 
		newPopulation.saveRoute(i, sonFuck);
		}
		
		mutation = 0;
		for (int i = setElitism; i < newPopulation.populationSize(); i++) {
			mutate(newPopulation.getRoute(i));
		}
		return newPopulation;
	}
	
	public static Route crossover(Route parent1, Route parent2) {
		Route child = new Route();
		
		int startP = (int) (Math.random() * parent1.routeSize());
		int endP   = (int) (Math.random() * parent1.routeSize());
	
		for (int i = 0; i < child.routeSize(); i++) {
			if(startP < endP && i > startP && i < endP) {
				child.setCity(i, parent1.getCity(i));
			} else if(startP > endP) {
				if(!(i < startP && i > endP)) {
					child.setCity(i, parent1.getCity(i));
				}
			}
		}
		
		for (int i = 0; i < parent2.routeSize(); i++) {
			if(!child.containsCity(parent2.getCity(i))) {
				for (int j = 0; j < child.routeSize(); j++) {
					if(child.getCity(j) == null) {
						child.setCity(j, parent2.getCity(i));
						break;
					}
				}
			}
		}
		return child;
	}
	
	private static void mutate(Route route) {
		for (int i = 0; i < route.routeSize(); i++) {
			if(Math.random() < mutationRate) {
				mutation++;
				int j = (int) (route.routeSize() * Math.random());
				
				City c1 = route.getCity(i);
				City c2 = route.getCity(j);
				
			    route.setCity(j, c1);
			    route.setCity(i, c2);
			}
		}
	}
	
	private static Route tournamentRollet(Population population) {
	Population tournament = new Population(tournamentSize, false);
	for (int i = 0; i < tournamentSize; i++) {
		int id = (int) (Math.random() * population.populationSize());
		tournament.saveRoute(i, population.getRoute(id));
	}
	Route bestRoute = tournament.getBestRoute();
	return bestRoute;
	}
	

	
}
