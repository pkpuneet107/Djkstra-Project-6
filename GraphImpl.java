    package a6;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Stack;
    import java.util.*;

    public class GraphImpl implements Graph {
        Map<String, Node> nodes;     //Do not delete.  Use this field to store your nodes.
        // key: name of node. value: a5.Node object associated with name

        private int nodeCount;
        private int edgeCount;

        public GraphImpl() {
            nodes = new HashMap<>();
        }

        @Override
        public boolean addNode(String name) {
            if (!nodes.containsKey(name) && name != null) {
                Node n = new NodeImpl(name);
                nodes.put(name, n);
                nodeCount++;
                return true;
            }
            return false;  //Dummy return value.  Remove when you implement!
        }

        @Override
        public boolean addEdge(String src, String destination, double weight) {
            Node srcNode = nodes.get(src);
            Node destinationNode = nodes.get(destination);
            if (weight < 0) {
                return false;
            }
            if (srcNode == null || destinationNode == null) {
                return false;
            }
            for (Edge edge : srcNode.getEdges()) {
                if (edge.getDestination().getName().equals(destination)) {
                    return false;
                }
            }
            Edge edge = new EdgeImpl(srcNode, destinationNode, weight);
            srcNode.addEdge(edge);
            edgeCount++;
            return true;

        }

        @Override
        public boolean deleteNode(String name) {
            if (!nodes.containsKey(name)) {
                return false;
            } else {
                Node x = nodes.get(name);
                for (Node n : nodes.values()) {
                    x.deleteEdge(n);
                    n.deleteEdge(x);
                }
            }
            nodes.remove(name);
            nodeCount--;
            return true;
        }

        @Override
        public boolean deleteEdge(String src, String dest) {
            Node a = nodes.get(src);
            Node b = nodes.get(dest);
            if (a == null || b == null) {
                return false;
            }
            if (!a.nodeExists(b)) {
                return false;
            }
            edgeCount--;
            return a.deleteEdge(b);
        }

        @Override
        public int numNodes() {
            return nodeCount;  //Dummy return value.  Remove when you implement!
        }

        @Override
        public int numEdges() {
            return edgeCount;  //Dummy return value.  Remove when you implement!
        }


        public class ShortestPathQueueObject {
            public double distance;
            public String label;

            public ShortestPathQueueObject(double distance, String label) {
                this.distance = distance;
                this.label = label;
            }
        }

        @Override
        public Map<String, Double> dijkstra(String start) {
            Map<String, Double> distances = new HashMap<>();
            Comparator<ShortestPathQueueObject> compare = (a, b) -> Double.compare(a.distance, b.distance);
            PriorityQueue<ShortestPathQueueObject> pq = new PriorityQueue<>(compare);

            Node startNode = nodes.get(start);
            if (startNode.getEdges().isEmpty()) {
                distances.put(start, 0.0);
                return distances;
            }

            for (Node node : nodes.values()) {
                if (node.getName().equals(start)) {
                    pq.add(new ShortestPathQueueObject(0.0, node.getName()));
                } else {
                    pq.add(new ShortestPathQueueObject(Double.POSITIVE_INFINITY, node.getName()));
                }
            }

            while (!pq.isEmpty()) {
                ShortestPathQueueObject curr = pq.poll();
                Node currNode = nodes.get(curr.label);
                double currDistance = curr.distance;
                if (distances.containsKey(curr.label)) {
                    continue;
                }
                distances.put(curr.label, currDistance);
                for (Edge edge : currNode.getEdges()) {
                    Node neighbor = edge.getDestination();
                    double distance = currDistance + edge.getWeight();
                    if (!distances.containsKey(neighbor.getName())) {
                        ShortestPathQueueObject neighborObj = new ShortestPathQueueObject(distance, neighbor.getName());
                        pq.add(neighborObj);
                    }
                }
            }

            return distances;
        }
    }


