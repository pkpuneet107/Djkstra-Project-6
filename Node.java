package a6;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

public interface Node {

     /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

     /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
     in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
     previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
     interfaces and their implementations.
      */
     String getName();
     ArrayList<Edge> getEdges();
     /** 1
      * @param name - string name of node to check for existence
      * @return true if node exists, false otherwise
      */
     boolean nodeExists(Node n);

     /**
      * @param name - string name of node to add
      * @return false if node with given name already exists in edges, true otherwise
      */
     boolean deleteEdge (Node n);

     /**
      * @param toNode - Node object to add edge to
      * @param weight - weight for new edge
      * @return false if edge already exists, true otherwise
      */
     void addEdge(Edge edge);

     List<Edge> getOutgoingEdges();



}





