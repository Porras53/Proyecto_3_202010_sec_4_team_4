package model.data_structures;

public class Grafo<K extends Comparable <K>, V, C> {

	private HashSeparateChaining <K, Vertice<K,V,C>> nodos ;

	private HashSeparateChaining <K,Integer> marked ;

	private HashSeparateChaining <K,Integer> id ;

	private ListaDoblementeEncadenada<Arco> list;

	private int count;
	private int count2;

	public Grafo() {

		marked = new HashSeparateChaining<K,Integer>();
		id= new HashSeparateChaining<K,Integer>();
		nodos=new HashSeparateChaining<K, Vertice<K,V,C>>();
		
		list=new ListaDoblementeEncadenada<Arco>();

	}


	public void addVertex(K idVertex, V infoVertex,Double latitud, Double longitud) {
		Vertice <K,V,C> vertex=new Vertice(idVertex, infoVertex);
		vertex.setLatitud(latitud);
		vertex.setLongitud(longitud);
		nodos.putInSet(idVertex, vertex);
		
	}
	
	public void addVertex(Vertice nuevo) 
	{
		K idVertex= (K)nuevo.getKey();
		nodos.putInSet(idVertex, nuevo);
		
	}
	
	


	public V getInfoVertex(K idVertex) {
		if(nodos.getSet(idVertex)==null)
			return null;

		return nodos.getSet(idVertex).darCabeza().getValue();


	}
	
	public Vertice<K, V, C> getVertex(K idVertex) {
		if(nodos.getSet(idVertex)==null)
			return null;

		return nodos.getSet(idVertex).darCabeza();


	}


	public void setInfoVertex(K idVertex, V infoVertex)	{
		if(nodos.getSet(idVertex)!=null )

			nodos.getSet(idVertex).darCabeza().setValue(infoVertex);

	}
	
	public void addEdge(Arco nuevoarco) {

		if( nuevoarco!=null) {

			list.insertarFinal(nuevoarco);

		}

	}

	public void addEdge(K idVertexIni, K idVertexFin, Double cost,Double cost2) {

		if( nodos.getSet(idVertexFin)!=null && nodos.getSet(idVertexIni)!=null) {

			Vertice v1=nodos.getSet(idVertexIni).darCabeza();
			Vertice v2=nodos.getSet(idVertexFin).darCabeza();
			Arco object=new Arco (v1, v2, cost,cost2);
			Arco object2=new Arco (v2, v1, cost,cost2);
			list.insertarFinal(object);
			v1.anadiraListadeVertices(v2);
			v2.anadiraListadeVertices(v1);
			v1.anadiraListadeArcos(object);
			v2.anadiraListadeArcos(object2);

		}

	}
	
	public void addEdge4(K idVertexIni, K idVertexFin, Double cost,Double cost2, K id) {

		if( nodos.getSet(idVertexFin)!=null && nodos.getSet(idVertexIni)!=null) {

			Vertice v1=nodos.getSet(idVertexIni).darCabeza();
			Vertice v2=nodos.getSet(idVertexFin).darCabeza();
			Arco object=new Arco (v1, v2, cost,cost2);
			Arco object2=new Arco (v2, v1, cost,cost2);
			object.setId(id);
			object2.setId(id);
			list.insertarFinal(object);
			v1.anadiraListadeArcos(object);
			v2.anadiraListadeArcos(object2);

		}

	}
	
	public void addEdge2(K idVertexIni, K idVertexFin, Double cost,Double cost2) {

		if( nodos.getSet(idVertexFin)!=null && nodos.getSet(idVertexIni)!=null) {

			Vertice v1=nodos.getSet(idVertexIni).darCabeza();
			Vertice v2=nodos.getSet(idVertexFin).darCabeza();
			Arco object=new Arco (v1, v2, cost,cost2);
			list.insertarFinal(object);
			v1.anadiraListadeArcos(object);
			v1.anadiraListadeVertices(v2);
			v2.anadiraListadeVertices(v1);

		}

	}
	
	public void addEdge3(K idVertexIni, K idVertexFin, Double cost,Double cost2) {

		if( nodos.getSet(idVertexFin)!=null && nodos.getSet(idVertexIni)!=null) {

			Vertice v1=nodos.getSet(idVertexIni).darCabeza();
			Vertice v2=nodos.getSet(idVertexFin).darCabeza();
			Arco object=new Arco (v1, v2, cost,cost2);
			list.insertarFinal(object);

		}

	}


	public double getCostArc(K idVertexIni, K idVertexFin) {

		if( nodos.getSet(idVertexFin)!=null&&nodos.getSet(idVertexIni)!=null) {

			Vertice v1=nodos.getSet(idVertexIni).darCabeza();
			Vertice v2=nodos.getSet(idVertexFin).darCabeza();
			Arco <K,V,Double>actual= v1.darConexion(v2);

			if(actual==null)
				return 0;
			else
				return actual.getCosto();

		}
		return 0;
	}
	public void setCostArc(K idVertexIni, K idVertexFin, double cost) {

		if( nodos.getSet(idVertexFin)!=null&&nodos.getSet(idVertexIni)!=null) {

			Vertice v1=nodos.getSet(idVertexIni).darCabeza();
			Vertice v2=nodos.getSet(idVertexFin).darCabeza();
			Arco <K,V,Double>actual= v1.darConexion(v2);

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

	public Iterable<K> adj(K v) {
		return nodos.getSet(v).darCabeza().darListaArcos();
	}

	
	public ListaDoblementeEncadenada<Arco> adj3(K v) {
		return nodos.getSet(v).darCabeza().darListaArcos();
	}
	
	public ListaDoblementeEncadenada<Integer> adj2(K v) {
		
		ListaDoblementeEncadenada<Integer> retorno= new ListaDoblementeEncadenada<Integer>();
	
		for(Vertice act: nodos.getSet(v).darCabeza().getVerticesadyacentes()) 
		{
			
			retorno.insertarFinal((Integer)act.getKey());
			
		}
		
		return retorno;
	}
	public void uncheck() 
	{
		count2=0;
		count=0;
		NodoHash22[] array=marked.getNodosSet();

		for(int i=0; i<array.length;i++) 
		{
			if(array[i]!=null) 
			{
				array[i].cambiarV(0);
			}
		}

		array=id.getNodosSet();

		for(int i=0; i<array.length;i++) 
		{
			if(array[i]!=null) 
			{
				array[i].cambiarV(0);
			}
		}
	}

	/**
	 * True==1 y false==0
	 * @param v
	 */
	 public void dfs(K v) 
	 {
		 count2++;
		 marked.getSet(v).darCabeza2().cambiarE(1);
		 id.getSet(v).darCabeza2().cambiarE(count);
		 for (K w : adj(v)) {
			 if (marked.getSet(w).darCabeza()==0) {
				 dfs(w);
			 }
		 }

	 }


	/** public int cc() 
	 {	
	 uncheck();

	 if(V()!=0) 
	 {
		 K primero=null;
		 boolean terminado=false;
		 NodoHash22[] array= nodos.getNodosSet();
		 for(int i=0; i<array.length && !terminado;i++) 
		 {
			 if(array[i]!=null) {
				 primero=(K)array[i].darE();
				 terminado=true;
			 }
		 }


		 for (K v: adj(primero)) {
			 if (marked.getSet(v).darCabeza()==0) {
				 dfs(v);
				 count++;
			 }
		 }
	 }
	 return count;
	 }**/
	 
	 public int cc() 
	 {
		CC nuevo= new CC(this);
		return  nuevo.count();
	 }

	 
	 
	 public Iterable<K> getCC(K idVertex)
	 {
		 /**
		  * faltaaaa
		  */
		 return null;
	 }


	public HashSeparateChaining<K, Vertice<K, V, C>> getNodos() {
		return nodos;
	}


	public ListaDoblementeEncadenada<Arco> getList() {
		return list;
	}


	public HashSeparateChaining<K, Integer> getMarked() {
		return marked;
	}


	public void setMarked(HashSeparateChaining<K, Integer> marked) {
		this.marked = marked;
	}


	public HashSeparateChaining<K, Integer> getId() {
		return id;
	}


	public void setId(HashSeparateChaining<K, Integer> id) {
		this.id = id;
	}


	public void setNodos(HashSeparateChaining<K, Vertice<K, V, C>> nodos) {
		this.nodos = nodos;
	}


	public void setList(ListaDoblementeEncadenada<Arco> list) {
		this.list = list;
	}




}
