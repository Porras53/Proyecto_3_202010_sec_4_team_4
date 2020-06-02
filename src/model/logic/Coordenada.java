package model.logic;

import model.data_structures.ListaDoblementeEncadenada;

public class Coordenada {
	private double latitud;
	private double longitud;
	private ListaDoblementeEncadenada<Comparendo> comparendos;
	private int cantidadComparendos;
	public Coordenada(double pLat, double pLongi) {
		 latitud=pLat;
		longitud=pLongi;
		comparendos= new ListaDoblementeEncadenada<Comparendo>();
		cantidadComparendos=0;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public ListaDoblementeEncadenada<Comparendo> getComparendos() {
		return comparendos;
	}
	public void setComparendos(ListaDoblementeEncadenada<Comparendo> comparendos) {
		this.comparendos = comparendos;
	}
	public int getCantidadComparendos() {
		return cantidadComparendos;
	}
	public void setCantidadComparendos(int cantidadComparendos) {
		this.cantidadComparendos = cantidadComparendos;
	}
	
	

}
