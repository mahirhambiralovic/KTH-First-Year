package se.kth.graph;

import java.util.Random;

/**
 * Generates a randomly assigned graph with n vertices and n edges, where n = args[0]
 *
 * Prints out:
 *
 * For a graph with 1000 nodes and 1000 randomly assigned edges:
 * * Number of components: XX
 * * Largest component: YY
 */

public class RandomGraphGenerator {

    public static void main(String[] args){
            if(args.length != 2){
                System.out.println("Use: Java RandomGraphGenerator <n> <graph_type>");
            } else{
                int n = Integer.parseInt(args[0]);
                if(n<0) {
                    System.out.println("Use: Java RandomGraphGenerator <n> <graph_type>");
                    return;
                }
                if(!args[1].equals("HashGraph") && !args[1].equals("MatrixGraph")){
                    return;
                }
                // setup: build graph
                RandomGraphGenerator rgg = new RandomGraphGenerator(n, args[1]);
                long t0 = System.nanoTime();

                // experiment: analyse components of graph
                rgg.printComponents();
                long t1 = System.nanoTime();
                long timecost = t1 - t0;
                System.out.printf("* Running time: %d ns\n", timecost);

            }
    }

    private Graph g;

    public RandomGraphGenerator(int n, String type){
        if(type.equals("HashGraph")){
            g = new HashGraph(n);
        }else{
            g = new MatrixGraph(n);
        }
        Random random = new Random();
        // Populate

        // Go through graph n x n times
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 1/n chance of setting an edge
                if(random.nextInt(n) == 1){
                    g.add(i, j);
                }
            }
        }
    }


    /**
     * Prints number of components and largest component
     */
    private void printComponents() {
        int numberOfComponents = 0;
        int largestComponent = 0;
        int n = g.numVertices();
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                numberOfComponents++;
                int currLen = dfs(g, v, visited);
                if(currLen > largestComponent) largestComponent = currLen;
            }
        }
        System.out.printf("For a graph with %d nodes and %d randomly assigned edges:\n", n, n);
        System.out.println("* Number of components: " + numberOfComponents);
        System.out.println("* Largest component: " + largestComponent);
    }

    /**
     * Traverses the nodes of g that have not yet been visited. The nodes are
     * visited in depth-first order starting at v. Returns the number of nodes
     * passed to reach the point.
     *
     * @param g
     *            an undirected graph
     * @param v
     *            start vertex
     * @param visited
     *            visited[i] is true if node i has been visited
     */
    private static int dfs(Graph g, int v, boolean[] visited) {
        int currLen = 0;
        if (visited[v])
            return currLen;
        visited[v] = true;
        currLen++;
        for (VertexIterator it = g.neighbors(v); it.hasNext();) currLen += dfs(g, it.next(), visited);
        return currLen;
    }

}
