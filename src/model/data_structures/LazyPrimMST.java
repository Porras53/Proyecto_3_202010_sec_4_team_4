package model.data_structures;

public class LazyPrimMST {
	private static final double FLOATING_POINT_EPSILON = 1E-12;

    private double weight;       // total weight of MST
    private ListaDoblementeEncadenada<Arco> mst;     // edges in the MST
    private boolean[] marked;    // marked[v] = true iff v on tree
    private MaxColaCP pq;      // edges with one endpoint in tree

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    public LazyPrimMST(Grafo G) {
        mst = new ListaDoblementeEncadenada<Arco>();
        pq = new MaxColaCP();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)     // run Prim from all vertices to
            if (!marked[v]) prim(G, v);     // get a minimum spanning forest

       
    }

    // run Prim's algorithm
    private void prim(Grafo G, int s) {
        scan(G, s);
        while (!pq.esVacia()) {                        // better to stop when mst has V-1 edges
            Arco e = (Arco)pq.sacarUltimo();                      // smallest edge on pq
            int v = (Integer)e.getvInicio().getKey(), w = e.other(v);        // two endpoints
            assert marked[v] || marked[w];
            if (marked[v] && marked[w]) continue;      // lazy, both v and w already scanned
            mst.insertarFinal(e);                            // add e to MST
            weight += (Double) e.getCosto();
            if (!marked[v]) scan(G, v);               // v becomes part of tree
            if (!marked[w]) scan(G, w);               // w becomes part of tree
        }
    }

    // add all edges e incident to v onto pq if the other endpoint has not yet been scanned
    private void scan(Grafo G, int v) {
        assert !marked[v];
        marked[v] = true;
        for (Object e : G.adj3(v)) 
        {
            if (!marked[((Arco)e).other(v)]) pq.agregar((Arco)e);
        }
    }
        
    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Arco> edges() {
        return mst;
    }
    
    public ListaDoblementeEncadenada<Arco> edges2() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    public double weight() {
        return weight;
    }

  

}
