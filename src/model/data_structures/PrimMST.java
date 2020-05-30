package model.data_structures;

import java.util.Iterator;

import model.logic.KeyComparendo;

public class PrimMST {

    private Arco[] edgeTo;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private double[] distTo;      // distTo[v] = weight of shortest such edge
    private boolean[] marked;     // marked[v] = true if v on tree, false otherwise
    private IndexMinPQ<Double> pq;


        /**
         * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
         * @param G the edge-weighted graph
         */
        public PrimMST(Grafo G) {
            edgeTo = new Arco[G.V()];
            distTo = new double[G.V()];
            marked = new boolean[G.V()];
            pq = new IndexMinPQ<Double>(G.V());
            for (int v = 0; v < G.V(); v++)
                distTo[v] = Double.POSITIVE_INFINITY;

            for (int v = 0; v < G.V(); v++)      // run from each vertex to find
                if (!marked[v]) prim(G, v);      // minimum spanning forest

          
        }

        // run Prim's algorithm in graph G, starting from vertex s
        private void prim(Grafo G, int s) {
            distTo[s] = 0.0;
            pq.insert(s, distTo[s]);
            while (!pq.isEmpty()) {
                int v = pq.delMin();
                scan(G, v);
            }
        }

        // scan vertex v
        private void scan(Grafo G, int v) {
            marked[v] = true;
            for (Object e : G.adj3(v)) {
                int w = ((Arco)e).other(v);
                if (marked[w]) continue;         // v-w is obsolete edge
                if (   (Double) ((Arco)e).getCosto() < distTo[w]) {
                    distTo[w] =(Double) ((Arco)e).getCosto();
                    edgeTo[w] = (Arco)e;
                    if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                    else                pq.insert(w, distTo[w]);
                }
            }
        }

        /**
         * Returns the edges in a minimum spanning tree (or forest).
         * @return the edges in a minimum spanning tree (or forest) as
         *    an iterable of edges
         */
        public Iterable<Arco> edges() {
        	ListaDoblementeEncadenada<Arco> mst = new ListaDoblementeEncadenada<Arco>();
            for (int v = 0; v < edgeTo.length; v++) {
                Arco e = edgeTo[v];
                if (e != null) {
                    mst.insertarFinal(e);
                }
            }
            return mst;
        }

        /**
         * Returns the sum of the edge weights in a minimum spanning tree (or forest).
         * @return the sum of the edge weights in a minimum spanning tree (or forest)
         */
        public double weight() {
            double weight = 0.0;
            for (Arco e : edges())
                weight += (Double)e.getCosto();
            return weight;
        }


}
