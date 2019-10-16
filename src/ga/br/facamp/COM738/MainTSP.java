package ga.br.facamp.COM738;

import java.util.ArrayList;
import java.util.Random;

import tsp.br.facamp.COM738.*;
public class MainTSP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Integer> xList = new ArrayList<Integer>();
		ArrayList<Integer> yList = new ArrayList<Integer>();
	
		int minX = 100;
		int maxX = 400;
		int minY = 400;
		int maxY = 700;
		int x, y = 0;
		/*
		 * String[] str = {"São Paulo", "Rio de Janeiro", "Belo Horizonte", "Guarulhos",
		 * "Campinas", "São Gonçalo", "Duque de Caixas", "São Bernado do Campo",
		 * "Nova Iguaçu", "Santo André", "Osasco", "São José dos Campos",
		 * "Ribeirão Preto", "Uberlândias", "Sorocada", "Contagem", "Juiz de Fora",
		 * "Serra", "Niterói", "Belford Roxo" };
		 */
		
		for (int i = 0; i < 400; i++) {
			x = (int) (minX + (Math.random() * (maxX - minX ) + 1));
			xList.add(x);
		} for (int i = 0; i < 1000; i++) {
			y = (int) (minY + (Math.random() * (maxY - minY ) + 1));
			yList.add(y);
		} 
		
		
		City c1 = new City("", xList.get(1) , yList.get(1));
		RouteManager.addCity(c1);
		City c2 = new City("", xList.get(2) , yList.get(2));
		RouteManager.addCity(c2);
		City c3 = new City("", xList.get(3) , yList.get(3));
		RouteManager.addCity(c3);
		City c4 = new City("", xList.get(4) , yList.get(4));
		RouteManager.addCity(c4);
		City c5 = new City("", xList.get(5) , yList.get(5));
		RouteManager.addCity(c5);
		City c6 = new City("", xList.get(6) , yList.get(6));
		RouteManager.addCity(c6);

		City c7 = new City("", xList.get(7) , yList.get(7));
		RouteManager.addCity(c7);
		City c8 = new City("", xList.get(8) , yList.get(8));
		RouteManager.addCity(c8);
		City c9 = new City("", xList.get(9) , yList.get(9));
		RouteManager.addCity(c9);
		City c10 = new City("", xList.get(10) , yList.get(10));
		RouteManager.addCity(c10);
		City c11 = new City("", xList.get(11) , yList.get(11));
		RouteManager.addCity(c11);
		City c12 = new City("", xList.get(12) , yList.get(12));
		RouteManager.addCity(c12);
		

		City c13 = new City("", xList.get(13) , yList.get(13));
		RouteManager.addCity(c13);
		City c14 = new City("", xList.get(14) , yList.get(14));
		RouteManager.addCity(c14);
		City c15 = new City("", xList.get(15) , yList.get(15));
		RouteManager.addCity(c15);
		City c16 = new City("", xList.get(16) , yList.get(16));
		RouteManager.addCity(c16);
		City c17 = new City("", xList.get(17) , yList.get(17));
		RouteManager.addCity(c17);
		City c18 = new City("", xList.get(18) , yList.get(18));
		RouteManager.addCity(c18);
		

		City c19 = new City("", xList.get(19) , yList.get(19));
		RouteManager.addCity(c19);
		City c20 = new City("", xList.get(20) , yList.get(20));
		RouteManager.addCity(c20);
	
	
		
		Population pop = new Population(100, true);
		
		System.out.println("Distância inicial: " + pop.getBestRoute().getDistance());
		
		for (int i = 0; i < 100; i++) {
			pop = Ga.evolvePop(pop);
			System.out.println(pop.getRoute(i));
		}
		
		System.out.println("Distância final: " + (int) pop.getBestRoute().getDistance());
		System.out.println("Solução final: ");
		System.out.println(pop.getBestRoute());
	}

}
