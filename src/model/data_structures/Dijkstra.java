package model.data_structures;

import java.util.Iterator;

public class Dijkstra {
	private Grafo grafoNoDirigido;
	private HashSeparateChaining <Integer, Dijkstraobject>tablaDeHash;
	private MaxHeapCP<Dijkstraobject> Queue ;

	public Dijkstra (Grafo grafo, int id)
	{
		tablaDeHash= new HashSeparateChaining ();
		Iterator iter=grafo.getNodos().keysSet();
		while(iter.hasNext()) {
			int id2=(int) iter.next();
			Dijkstraobject actual = new Dijkstraobject(id2, Double.POSITIVE_INFINITY,-1);
			tablaDeHash.putInSet(id2, actual);

		}
		tablaDeHash.getSet(id).darCabeza().setCosto(0);
		grafoNoDirigido=grafo;
		Queue=new MaxHeapCP();
		Queue.agregar(tablaDeHash.getSet(id).darCabeza());
		while(Queue.estaVacio()==false){
			int actual=Queue.eliminarMayor().getIdOrigen();

			for (Object siguiente :	grafo.adj(actual)) {
				relax(tablaDeHash.getSet((Integer) siguiente).darCabeza(), actual);

			}

		}
	}

	private void relax(Dijkstraobject vertice, int actual) {
		// TODO Auto-generated method stub
		int idOrigen=actual;
		int idActual=vertice.getIdOrigen();
		if(vertice.getCosto()>tablaDeHash.getSet(idOrigen).darCabeza().getCosto()+grafoNoDirigido.getCostArc(idOrigen, idActual)) {
			vertice.setCosto(tablaDeHash.getSet(idOrigen).darCabeza().getCosto()+grafoNoDirigido.getCostArc(idOrigen, idActual));
			tablaDeHash.getSet(idActual).darCabeza().setIdDestino(idOrigen);
			if(Queue.contains(tablaDeHash.getSet(idActual).darCabeza())) {
				Queue.disminuirLlave(idActual,tablaDeHash.getSet(idActual).darCabeza());

			}
			else {
                  Queue.agregar(tablaDeHash.getSet(idActual).darCabeza());
			}
		}
	}
	public ListaDoblementeEncadenada camino(int id)
	{
		ListaDoblementeEncadenada<Dijkstraobject>resp=new ListaDoblementeEncadenada();
		if(tablaDeHash.getSet(id).darCabeza().getCosto()>=Double.POSITIVE_INFINITY) {
			return null;
		}
		else
			for (Dijkstraobject i = tablaDeHash.getSet(id).darCabeza(); i != null; i=tablaDeHash.getSet(i.getIdDestino()).darCabeza()) {
				
				resp.insertarComienzo(i);
				
				
			}
		return resp;
	}

}
