package model.data_structures;

public class vertice<K extends Comparable <K>, V, C>implements Comparable<vertice<K , V, C>> {

	private K key;
	private V value;
	private ListaDoblementeEncadenada<arco>list;
	
	public vertice(K key, V value) {
		
		this.key = key;
		this.value = value;
		list= new ListaDoblementeEncadenada();
	}
    public void anadiraListadeArcos(arco arco) {
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
	public int compareTo(vertice o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public arco darConexion(vertice v) {
		if (list.esListaVacia())
			return null;
		for (arco arco : list) {
			if(arco.contiene(this, v))
				return arco;
		}
		return null;
	}

}
