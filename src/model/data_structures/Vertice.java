package model.data_structures;

import model.logic.Comparendo;
import model.logic.EstacionPolicia;

public class Vertice<K extends Comparable <K>, V, C>implements Comparable<Vertice<K , V, C>> {

	private K key;
	private V value;
	private double latitud;
	private double longitud;
	private C cost;
	private ListaDoblementeEncadenada<Arco>list;
	private ListaDoblementeEncadenada<Comparendo>listaComparendos;
	private ListaDoblementeEncadenada<EstacionPolicia>listaPolicias;
	public Vertice(K key, V value,C cost, double latitud, double longitud) {
		
		this.key = key;
		this.value = value;
		this.cost= cost;
		this.latitud=latitud;
		this.longitud=longitud;
		list= new ListaDoblementeEncadenada();
		listaComparendos= new ListaDoblementeEncadenada();
		listaPolicias= new ListaDoblementeEncadenada();
		
	}
    public void anadiraListadeArcos(Arco arco) {
    	list.insertarFinal(arco);
    }
    public ListaDoblementeEncadenada darListaArcos()
    {
    	return list;
    }
    public C getCost() {
    	return cost;
    }
    public double getLatitud() {
		return latitud;
	}
    public double getLongitud() {
		return longitud;
	}
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public int compareTo(Vertice o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public Arco darConexion(Vertice v) {
		if (list.esListaVacia())
			return null;
		for (Arco arco : list) {
			if(arco.contiene(this, v))
				return arco;
		}
		return null;
	}

}
