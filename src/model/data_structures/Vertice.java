package model.data_structures;

public class Vertice<K extends Comparable <K>, V, C>implements Comparable<Vertice<K , V, C>> {

	private K key;
	private V value;
	private ListaDoblementeEncadenada<Arco>list;
	private ListaDoblementeEncadenada<Vertice>verticesadyacentes;
	private ListaDoblementeEncadenada<Arco> caminomascercanoaestacion;
	private Double costoaestacion;
	private Integer numeroestacion;
	private String color;
	
	private Double longitud;
	private Double latitud;
	
	public Vertice(K key, V value) {
		
		this.key = key;
		this.value = value;
		list= new ListaDoblementeEncadenada();
		verticesadyacentes=new ListaDoblementeEncadenada();
		caminomascercanoaestacion= new ListaDoblementeEncadenada<Arco>();
		costoaestacion=100.0;
		numeroestacion=-1;
	}
    public void anadiraListadeArcos(Arco arco) {
    	list.insertarFinal(arco);
    }
    
    public void anadiraListadeVertices(Vertice ver) {
    	verticesadyacentes.insertarFinal(ver);
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
		Integer valor=((ListaDoblementeEncadenada)getValue()).darLongitud()-2;
		Integer valor2=((ListaDoblementeEncadenada)o.getValue()).darLongitud()-2;
		
		if(valor>valor2) 
		{
			return 1;
		}
		else if(valor==valor2) 
		{
			return 0;
		}
		else 
		{
			return -1;
		}
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
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public ListaDoblementeEncadenada<Arco> getList() {
		return list;
	}
	public void setList(ListaDoblementeEncadenada<Arco> list) {
		this.list = list;
	}
	public ListaDoblementeEncadenada<Vertice> getVerticesadyacentes() {
		return verticesadyacentes;
	}
	public void setVerticesadyacentes(ListaDoblementeEncadenada<Vertice> verticesadyacentes) {
		this.verticesadyacentes = verticesadyacentes;
	}
	@Override
	public String toString() {
		return "Vertice [key=" + key.toString() + ", value=" + value + ", longitud=" + longitud + ", latitud=" + latitud + "]";
	}
	public ListaDoblementeEncadenada<Arco> getCaminomascercanoaestacion() {
		return caminomascercanoaestacion;
	}
	public void setCaminomascercanoaestacion(ListaDoblementeEncadenada<Arco> caminomascercanoaestacion) {
		this.caminomascercanoaestacion = caminomascercanoaestacion;
	}
	public Double getCostoaestacion() {
		return costoaestacion;
	}
	public void setCostoaestacion(Double costoaestacion) {
		this.costoaestacion = costoaestacion;
	}
	public Integer getNumeroestacion() {
		return numeroestacion;
	}
	public void setNumeroestacion(Integer numeroestacion) {
		this.numeroestacion = numeroestacion;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
