package a6;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class NodeImpl implements Node {

    /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you u pdate the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any node fields you want to add for the object should go in this file.  */
    private String name;
    ArrayList<Edge> edges = new ArrayList<Edge>();
    private List<Edge> outgoingEdges;

    public NodeImpl(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }
    public boolean deleteEdge(Edge e) {
        return edges.remove(e);
    }

    public boolean nodeExists(Node n){
        for (Edge e: edges){
            if(e.getDestination().equals(n)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteEdge(Node n){
        if(this.nodeExists(n)){
            Edge x = new EdgeImpl(null,null, 0.0);
            for(Edge e: edges){
                if(e.getDestination().equals(n)){
                    x = e;
                }
            }
            this.edges.remove(x);
            return true;
        }
        return false;
    }
    public void addEdge(Edge edge){
        edges.add(edge);
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
    public List<Edge> getOutgoingEdges() {
        return outgoingEdges;
    }


}




