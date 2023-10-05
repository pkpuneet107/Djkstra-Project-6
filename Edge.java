package a6;

public interface Edge {
    /* You will include the method signatures (return type, name, and arg types) for any edge methods you
    need in this file. */

    /*Hint: Make sure you update the Edge interface in Edge.java when you add a new method implementation
    in EdgeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */


    /**
     * Get the weight of the edge.
     * @return the weight of the edge
     */
    double getWeight();

    /**
     * Set the weight of the edge.
     * @param weight the new weight of the edge
     */
    void setWeight(double weight);

    /**
     * Get the source node of the edge.
     * @return the source node of the edge
     */
    Node getSource();

    /**
     * Get the destination node of the edge.
     * @return the destination node of the edge
     */
    Node getDestination();
}




