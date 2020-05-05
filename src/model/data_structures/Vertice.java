package model.data_structures;

public class Vertice<K extends Comparable <K>, V, C>implements Comparable<Vertice<K , V, C>> {

	private K key;
	private V value;
	private ListaDoblementeEncadenada<Arco>list;
	
	public Vertice(K key, V value) {
		
		this.key = key;
		this.value = value;
		list= new ListaDoblementeEncadenada();
	}
    public void anadiraListadeArcos(Arco arco) {
    	list.insertarComienzo(arco);
    }
    public ListaDoblementeEncadenada darListaArcos()
    {
    	return list;
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
