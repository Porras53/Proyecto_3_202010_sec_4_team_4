package model.data_structures;

public class grafo<K extends Comparable <K>, V, C> {

	private HashSeparateChaining <K, vertice<K,V,C>> nodos ;
	private ListaDoblementeEncadenada<arco> list;
	public grafo(int ejemplo) {
		nodos=new HashSeparateChaining();
		list=new ListaDoblementeEncadenada<arco>();
	}
	public void addVertex(K idVertex, V infoVertex) {
	vertice <K,V,C> vertex=new vertice(idVertex, infoVertex);
	nodos.putInSet(idVertex, vertex);
	}
	public V getInfoVertex(K idVertex) {
		if(nodos.getSet(idVertex)==null)
			return null;
		return nodos.getSet(idVertex).darCabeza().getValue();
		 
	}
	public void setInfoVertex(K idVertex, V infoVertex)	{
		if(nodos.getSet(idVertex)!=null )
			nodos.getSet(idVertex).darCabeza().setValue(infoVertex);
		
	}
	public void addEdge(K idVertexIni, K idVertexFin, double cost) {
	if( nodos.getSet(idVertexFin)!=null&&nodos.getSet(idVertexIni)!=null) {
		vertice v1=nodos.getSet(idVertexIni).darCabeza();
	    vertice v2=nodos.getSet(idVertexFin).darCabeza();
	    arco object=new arco (v1, v2, -1);
	    list.insertarComienzo(object);
	    v1.anadiraListadeArcos(object);
	    v2.anadiraListadeArcos(object);
	}
	
	}
	public double getCostArc(K idVertexIni, K idVertexFin) {
		if( nodos.getSet(idVertexFin)!=null&&nodos.getSet(idVertexIni)!=null) {
			vertice v1=nodos.getSet(idVertexIni).darCabeza();
		    vertice v2=nodos.getSet(idVertexFin).darCabeza();
		    arco <K,V,Double>actual= v1.darConexion(v2);
		    
		    if(actual==null)
		    	return 0;
		    else
		    	return actual.getCosto();
		    
		}
		return 0;
	}
	public void setCostArc(K idVertexIni, K idVertexFin, double cost) {
		if( nodos.getSet(idVertexFin)!=null&&nodos.getSet(idVertexIni)!=null) {
			vertice v1=nodos.getSet(idVertexIni).darCabeza();
		    vertice v2=nodos.getSet(idVertexFin).darCabeza();
		    arco <K,V,Double>actual= v1.darConexion(v2);
		    
		    if(actual==null)
		    actual.setCosto(cost);
		    	
		    
		}
		
	}
	public int V() {
		return nodos.getTamActual();
	}
	public int E() {
		return list.darLongitud();
	}
}
