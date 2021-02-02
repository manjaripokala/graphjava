package simple.graph;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.*;

/**
 * Unit test for Graph Data structure
 */
public class GraphTest {
    /**
     * Test for Directed with Integer type
     */
    @Test
    public void testDirectedInteger() {
        Graph<Integer> directedGraph = new Graph<Integer>(true);

        for (int i = 0; i < 6; i++) {
            directedGraph.addVertex(i);
        }
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(1, 3);
        directedGraph.addEdge(1, 5);
        directedGraph.addEdge(3, 4);
        List<Edge<Integer>> expected = new ArrayList<Edge<Integer>>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            {
                add(new Edge<Integer>(0, 1));
                add(new Edge<Integer>(1, 2));
                add(new Edge<Integer>(2, 3));
                add(new Edge<Integer>(3, 4));
            }
        };
        List<Edge<Integer>> actual = directedGraph.getPath(0, 4);
        assertEquals(expected, actual);
    }

    /**
     * Test for Directed with Integer type - 100 inputs
     */
    @Test
    public void testDirectedInteger2() {
        Graph<Integer> directedGraph = new Graph<Integer>(true);

        for (int i = 0; i < 100; i++) {
            directedGraph.addEdge(i, i + 1);
        }

        List<Edge<Integer>> expected = new ArrayList<Edge<Integer>>();
        for (int i = 0; i < 100; i++) {
            expected.add(new Edge<Integer>(i, i + 1));
        }

        List<Edge<Integer>> actual = directedGraph.getPath(0, 100);
        assertEquals(expected, actual);
    }

    /**
     * Test for UnDirected with Integer type
     */
    @Test
    public void testUnDirectedInteger() {
        Graph<Integer> unDirectedGraph = new Graph<Integer>(false);

        for (int i = 0; i < 6; i++) {
            unDirectedGraph.addVertex(i);
        }
        unDirectedGraph.addEdge(0, 1);
        unDirectedGraph.addEdge(1, 2);
        unDirectedGraph.addEdge(2, 3);
        unDirectedGraph.addEdge(1, 3);
        unDirectedGraph.addEdge(1, 5);
        unDirectedGraph.addEdge(3, 4);
        List<Edge<Integer>> expected = new ArrayList<Edge<Integer>>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            {
                add(new Edge<Integer>(0, 1));
                add(new Edge<Integer>(1, 2));
                add(new Edge<Integer>(2, 3));
                add(new Edge<Integer>(3, 4));
            }
        };
        List<Edge<Integer>> actual = unDirectedGraph.getPath(0, 4);
        assertEquals(expected, actual);
    }

    /**
     * Test for Undirected with Integer type - 100 inputs
     */
    @Test
    public void testUnDirectedInteger2() {
        Graph<Integer> unDirectedGraph = new Graph<Integer>(false);

        for (int i = 0; i < 100; i++) {
            unDirectedGraph.addEdge(i, i + 1);
        }

        List<Edge<Integer>> expected = new ArrayList<Edge<Integer>>();
        for (int i = 0; i < 100; i++) {
            expected.add(new Edge<Integer>(i, i + 1));
        }

        List<Edge<Integer>> actual = unDirectedGraph.getPath(0, 100);
        assertEquals(expected, actual);
    }

    /**
     * Test for Directed with String type
     */
    @Test
    public void testDirectedString() {
        Graph<Character> directedGraph = new Graph<Character>(true);

        for (int i = 0; i < 25; i++) {
            directedGraph.addEdge((char) (97 + i), (char) (97 + i + 1));
        }

        List<Edge<Character>> expected = new ArrayList<Edge<Character>>();
        for (int i = 0; i < 25; i++) {
            expected.add(new Edge<Character>((char) (97 + i), (char) (97 + i + 1)));
        }
        List<Edge<Character>> actual = directedGraph.getPath('a', 'z');
        assertEquals(expected, actual);
    }

    /**
     * Test for Directed with Object
     */
    @Test
    public void testDirectedObject() {
        Graph<City> directedGraph = new Graph<City>(true);

        // City objects
        List<City> cities = new ArrayList<City>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            {
                add(new City("Houston", 2320268));
                add(new City("SanAntonio", 1532233));
                add(new City("Dallas", 1345047));
                add(new City("Austin", 964254));
                add(new City("FortWorth", 895008));
                add(new City("ElPaso", 682669));
                add(new City("Arlington", 398123));
                add(new City("CorpusChristi", 326554));
                add(new City("Plano", 288061));
                add(new City("Laredo", 261639));
            }
        };

        for (int i = 0; i < 9; i++) {
            directedGraph.addEdge(cities.get(i), cities.get(i + 1));
        }

        List<Edge<City>> expected = new ArrayList<Edge<City>>();
        for (int i = 0; i < 9; i++) {
            expected.add(new Edge<City>(cities.get(i), cities.get(i + 1)));
        }

        List<Edge<City>> actual = directedGraph.getPath(cities.get(0), cities.get(9));
        assertEquals(expected, actual);
    }
}
