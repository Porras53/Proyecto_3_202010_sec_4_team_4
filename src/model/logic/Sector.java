package model.logic;

import model.data_structures.*;

public class Sector implements Comparable<Sector>{

	private Double latmax;
	
	private Double latmin;
	
	private Double longmax;
	
	private Double longmin;
	
	private ListaDoblementeEncadenada<Vertice> vertices;
	
public Sector(Double latmax, Double latmin, Double longmax, Double longmin) {
		
		this.latmax = latmax;
		this.latmin = latmin;
		this.longmax = longmax;
		this.longmin = longmin;
		vertices= new ListaDoblementeEncadenada<Vertice>();
	}
	
	public boolean verificarIntervalo(Double lat, Double longi) 
	{
		return lat>=latmin && lat<=latmax && longi>=longmin && longi<=longmax; 
		
	}


	public void agregarvertice(Vertice nuevo) 
	{
		vertices.insertarFinal(nuevo);
	}
	
	@Override
	public int compareTo(Sector o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public Double getLatmax() {
		return latmax;
	}


	public void setLatmax(Double latmax) {
		this.latmax = latmax;
	}


	public Double getLatmin() {
		return latmin;
	}


	public void setLatmin(Double latmin) {
		this.latmin = latmin;
	}


	public Double getLongmax() {
		return longmax;
	}


	public void setLongmax(Double longmax) {
		this.longmax = longmax;
	}


	public Double getLongmin() {
		return longmin;
	}


	public void setLongmin(Double longmin) {
		this.longmin = longmin;
	}

	public ListaDoblementeEncadenada<Vertice> getVertices() {
		return vertices;
	}

}
