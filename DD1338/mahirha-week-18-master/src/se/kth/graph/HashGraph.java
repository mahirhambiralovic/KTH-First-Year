package se.kth.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A graph with a fixed number of vertices implemented using adjacency maps.
 * Space complexity is &Theta;(n + m) where n is the number of vertices and m
 * the number of edges.
 *
 * @author [Name]
 * @version [Date]
 */
public class HashGraph implements Graph {
    /**
     * The map edges[v] contains the key-value pair (w, c) if there is an edge
     * from v to w; c is the cost assigned to this edge. The maps may be null
     * and are allocated only when needed.
     */
    private final Map<Integer, Integer>[] edges;
    private final static int INITIAL_MAP_SIZE = 4;

    /** Number of edges in the graph. */
    private int numEdges;

    /**
     * Constructs a HashGraph with n vertices and no edges. Time complexity:
     * O(n)
     *
     * @throws IllegalArgumentException
     *             if n < 0
     */
    public HashGraph(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n = " + n);

        // The array will contain only Map<Integer, Integer> instances created
        // in addEdge(). This is sufficient to ensure type safety.
        @SuppressWarnings("unchecked") Map<Integer, Integer>[] a = new HashMap[n];
        edges = a;
    }

    /**
     * Add an edge without checking parameters(!!)
     */
    private void addEdge(int from, int to, int cost) {
        if (edges[from] == null)
            edges[from] = new HashMap<Integer, Integer>(INITIAL_MAP_SIZE);
        if (edges[from].put(to, cost) == null)
            numEdges++;
    }

    /**
     * {@inheritDoc Graph} Time complexity: O(1).
     */
    @Override
    public int numVertices() {
        return edges.length;
    }

    /**
     * {@inheritDoc Graph} Time complexity: O(1).
     */
    @Override
    public int numEdges() {
        return numEdges;
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public int degree(int v) throws IllegalArgumentException {
        int d = 0;
        for(int w = 0; w < edges.length; w++){
            if(hasEdge(v, w)){d++;}
        }
        return d;
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public VertexIterator neighbors(int v) {
        checkVertexParameters(v);

        return new NeighborIterator(v);

    }

    private class NeighborIterator implements VertexIterator {
        Map<Integer, Integer> element;
        final int n;
        int nextPos = -1;

        NeighborIterator(int v) {
            if (edges[v] == null) {
                // If null element, use empty hashmap
                element = new HashMap<>();
            }
            else{
                element = edges[v];
            }
            n = edges.length;
            findNext();
        }

        private void findNext() {
            nextPos++;
            while (nextPos < n && !element.containsKey(nextPos)) nextPos++;
        }

        @Override
        public boolean hasNext() {
            return nextPos < n;
        }

        @Override
        public int next() {
            int pos = nextPos;
            if (pos < n) {
                findNext();
                return pos;
            }
            throw new NoSuchElementException("This iterator has no more elements.");
        }
    }


    /**
     * {@inheritDoc Graph}
     */
    @Override
    public boolean hasEdge(int from, int to) {
        checkVertexParameters(from, to);
        if (edges[from] == null) { return false; }
        if(edges[from].containsKey(to)){ return true; }
        else{ return false; }
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public int cost(int from, int to) throws IllegalArgumentException {
        checkVertexParameters(from, to);
        if(hasEdge(from, to)){
            return edges[from].get(to);
        }
        return NO_COST;
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void add(int from, int to) {
        checkVertexParameters(from, to);
        addEdge(from, to, NO_COST);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void add(int from, int to, int c) {
        checkVertexParameters(from, to);
        if(c < 0){
            throw new IllegalArgumentException("Cost must me >= 0");
        }
        addEdge(from, to, c);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void addBi(int v, int w) {
        add(v, w);
        add(w, v);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void addBi(int v, int w, int c) {
        add(v, w, c);
        add(w, v, c);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void remove(int from, int to) {
        checkVertexParameters(from, to);
        if(edges[from] != null && edges[from].containsKey(to)){
            edges[from].remove(to);
            numEdges--;
        }
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void removeBi(int v, int w) {
        remove(v, w);
        remove(w,v);
    }

    /**
     * Returns a string representation of this graph.
     *
     * Should represent the graph in terms of edges (order does not matter).
     * For example, if a graph has edges (2,3) and (1,0) with NO_COST, the
     * representaiton should be:
     *
     * "{(1,0), (2,3)}" or "{(2,3), (1,0)}"
     *
     * If an edge has a cost (say, 5), it is added as a third value, like so:
     *
     * "{(1,0,5)}"
     *
     * An empty graph is just braces:
     *
     * "{}"
     *
     * @return a String representation of this graph
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for(int i = 0; i < numVertices(); i++){
            if(edges[i] == null){
                i++;
            }
            else{
                for(int j = 0; j < numVertices(); j++){
                    if(edges[i].containsKey(j)){
                        if(edges[i].get(j) != NO_COST){
                            sb.append("(" + i + "," + j + "," + edges[i].get(j) + "), ");
                        }
                        else{
                            sb.append("(" + i + "," + j + "), ");
                        }
                    }
                }
            }
        }
        if (numEdges > 0)
            sb.setLength(sb.length() - 2); // Remove trailing ", "
        sb.append("}");
        return sb.toString();
    }

    // Sanity check, looks if parameters are outside of range
    private void checkVertexParameters(int v) throws IllegalArgumentException{
        if((v < 0) || (v >= edges.length)){
            throw new IllegalArgumentException("From and to parameters are outside of size " + edges.length);
        }
    }

    // Sanity check, looks if parameters are outside of range
    private void checkVertexParameters(int v, int w) throws IllegalArgumentException{
        if((v < 0) || (v >= edges.length) || (w < 0) || (w >= edges.length)){
            throw new IllegalArgumentException("From and to parameters are outside of size " + edges.length);
        }
    }
}
