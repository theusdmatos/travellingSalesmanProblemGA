//TSP PROBLEM 
package tsp.br.facamp.COM738;

public class City {

//Coordenada X e Y da cidade
private int x;
private int y;
//Nome da cidade
private String nameCity;

public City( String nameCity, int x, int y) {
	this.x = x;
	this.y = y;
	this.nameCity = nameCity;
}

//Calcular a distância que separa uma cidade da outra cidade

public double distanceToCity(City city) {
	int _x = Math.abs(this.x - city.x);
	int _y = Math.abs(this.y - city.y);
	
	double distance = Math.sqrt(Math.pow(_x, 2) + Math.pow(_y, 2));
	
	return distance;
}

public int getX() {
	return x;
}

public int getY() {
	return y;
}

public String getNameCity() {
	return nameCity;
}

@Override
public String toString() {
	return "City [x: " + x + " y: " + y + " - " + nameCity + "]";
}


	
}
