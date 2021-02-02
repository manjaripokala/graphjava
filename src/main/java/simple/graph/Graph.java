package simple.graph;

import java.util.*;

/**
 * Graph Data Structure implemented using Adjacency List
 *
 */
public class Graph<E> {
    private Map<E, List<E>> graph;
    private boolean directed;
    private Map<E, Boolean> visited;

    public Graph(boolean directed) {
        this.graph = new HashMap<>();
        this.directed = directed;
    }

    /**
     * Adds vertex to the graph
     *
     */
    public void addVertex(E vertex) {
        // adds a vertex with an empty list
        graph.put(vertex, new LinkedList<E>());
    }

    /**
     * Adds an edge to the graph
     *
     */
    public void addEdge(E from, E to) {
        // if vertices does not exist already in the graph
        if (!graph.containsKey(from)) {
            addVertex(from);
        }

        if (!graph.containsKey(to)) {
            addVertex(to);
        }

        graph.get(from).add(to);
        if (!directed) {
            graph.get(to).add(from);
        }
    }

    /**
     * Populate depth first paths from source to destination
     *
     */
    public boolean dfs(E source, E destination, List<Edge<E>> alledges) {
        if (source.equals(destination)) {
            return true;
        }
        // Mark the source node as visited and add it to Queue for processing
        visited.put(source, true);
        for (E adjacent : graph.get(source)) {
            if (adjacent.equals(destination)) {
                alledges.add(new Edge<E>(source, adjacent));
                return true;
            }
            if (!visited.get(adjacent)) {
                alledges.add(new Edge<E>(source, adjacent));
                if (dfs(adjacent, destination, alledges))
                    return true;
            }
        }

        return false;
    }

    /**
     * Returns a path from source to destination
     *
     */
    public List<Edge<E>> getPath(E source, E destination) {
        // list of edges
        List<Edge<E>> alledges = new ArrayList<Edge<E>>();

        // initialize all vertices to unVisited
        visited = new HashMap<E, Boolean>();
        for (E vertex : graph.keySet()) {
            visited.put(vertex, false);
        }

        dfs(source, destination, alledges);
        return alledges;
    }
}
