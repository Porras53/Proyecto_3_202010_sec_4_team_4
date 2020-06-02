package model.data_structures;

public class DijkstraUndirectedSP2 {
	 private double[] distTo;          // distTo[v] = distance  of shortest s->v path
	    private Arco[] edgeTo;            // edgeTo[v] = last edge on shortest s->v path
	    private IndexMinPQ<Double> pq;    // priority queue of vertices

	    /**
	     * Computes a shortest-paths tree from the source vertex {@code s} to every
	     * other vertex in the edge-weighted graph {@code G}.
	     *
	     * @param  G the edge-weighted digraph
	     * @param  s the source vertex
	     * @throws IllegalArgumentException if an edge weight is negative
	     * @throws IllegalArgumentException unless {@code 0 <= s < V}
	     */
	    public DijkstraUndirectedSP2(Grafo G, int s) {
	        for (Object r: G.getList()) {
	        	Arco e=(Arco)r;
	        	
	            if ((Double)e.getCosto2() < 0)
	                throw new IllegalArgumentException("edge " + e + " has negative weight");
	        }

	        distTo = new double[G.V()];
	        edgeTo = new Arco[G.V()];

	        validateVertex(s);

	        for (int v = 0; v < G.V(); v++)
	            distTo[v] = Double.POSITIVE_INFINITY;
	        distTo[s] = 0.0;

	        // relax vertices in order of distance from s
	        pq = new IndexMinPQ<Double>(G.V());
	        pq.insert(s, distTo[s]);
	        while (!pq.isEmpty()) {
	            int v = pq.delMin();
	            for (Object g : G.adj(v)) {
	            	Arco e=(Arco)g;
	                relax(e, v);
	            }
	        }

	    }

	    // relax edge e and update pq if changed
	    private void relax(Arco e, int v) {
	        int w = e.other(v);
	        if (distTo[w] > distTo[v] + (Double) e.getCosto2()) {
	            distTo[w] = distTo[v] + (Double) e.getCosto2();
	            edgeTo[w] = e;
	            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
	            else                pq.insert(w, distTo[w]);
	        }
	    }

	    /**
	     * Returns the length of a shortest path between the source vertex {@code s} and
	     * vertex {@code v}.
	     *
	     * @param  v the destination vertex
	     * @return the length of a shortest path between the source vertex {@code s} and
	     *         the vertex {@code v}; {@code Double.POSITIVE_INFINITY} if no such path
	     * @throws IllegalArgumentException unless {@code 0 <= v < V}
	     */
	    public double distTo(int v) {
	        validateVertex(v);
	        return distTo[v];
	    }

	    /**
	     * Returns true if there is a path between the source vertex {@code s} and
	     * vertex {@code v}.
	     *
	     * @param  v the destination vertex
	     * @return {@code true} if there is a path between the source vertex
	     *         {@code s} to vertex {@code v}; {@code false} otherwise
	     * @throws IllegalArgumentException unless {@code 0 <= v < V}
	     */
	    public boolean hasPathTo(int v) {
	        validateVertex(v);
	        return distTo[v] < Double.POSITIVE_INFINITY;
	    }

	    /**
	     * Returns a shortest path between the source vertex {@code s} and vertex {@code v}.
	     *
	     * @param  v the destination vertex
	     * @return a shortest path between the source vertex {@code s} and vertex {@code v};
	     *         {@code null} if no such path
	     * @throws IllegalArgumentException unless {@code 0 <= v < V}
	     */
	    public ListaDoblementeEncadenada<Arco> pathTo(int v) {
	    	
	        validateVertex(v);
	        if (!hasPathTo(v)) return null;
	        ListaDoblementeEncadenada<Arco> path = new ListaDoblementeEncadenada<Arco>();
	        int x = v;
	        for (Arco e = edgeTo[v]; e != null; e = edgeTo[x]) {
	            path.insertarComienzo(e);
	            x = e.other(x);
	        }
	        return path;
	    }
	    
	   
	    private void validateVertex(int v) {
	        int V = distTo.length;
	        if (v < 0 || v >= V)
	            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	    }
}
