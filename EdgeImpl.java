package a6;

public class EdgeImpl implements Edge {
    /* You will include the implementations for any edge methods you need in this file. */

    /*Hint: Make sure you update the Edge interface in Edge.java when you add a new method implementation
    in EdgeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any edge fields you want to add for the object should go in this file.  */

    private Node source;
    private Node destination;
    private double weight;

    public EdgeImpl(Node source, Node destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public Node getSource() {
        return source;
    }

    @Override
    public Node getDestination() {
        return destination;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // @Override
    //public String toString() {
    // return "(" + source.getLabel() + ", " + destination.getLabel() + ", " + weight + ")";
    //}
}



