package simple.graph;

/**
 * An Edge class
 *
 */

@SuppressWarnings("unchecked") // Asssuming only Edge objects will be passed to equals method

public class Edge<E> {
    private E from;
    private E to;

    public Edge(E from, E to) {
        this.from = from;
        this.to = to;
    }

    public E getFrom() {
        return this.from;
    }

    public E getTo() {
        return this.to;
    }

    // @Override
    // public String toString() {
    // return from + "->" + to;
    // }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge<E> that = (Edge<E>) obj;
            return (this.from.equals(that.getFrom()) && this.to.equals(that.getTo()));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 71;
        hash = 89 * hash + (this.from != null ? this.from.hashCode() : 0);
        hash = 89 * hash + (this.to != null ? this.to.hashCode() : 0);
        return hash;
    }

}
