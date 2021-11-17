package nl.rug.oop.grapheditor.model;

import java.io.Serializable;

/**
 * Class used for representing an edge
 */
public class GraphEdge implements Serializable {

    private static final long serialVersionUID = 3L;
    private final String edgeName;
    private final GraphNode nodeA;
    private final GraphNode nodeB;

    /**
     * Constructor that initialises an edge with the following fields (an edge always connects two nodes):
     *
     * @param nodeA - first node that defines an edge
     * @param nodeB - second node that defines an edge
     *        edgeName - is the combination of the above nodes' names and the operator "--"
     */
    public GraphEdge(GraphNode nodeA, GraphNode nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        edgeName = nodeA.getName() + " -- " + nodeB.getName();
    }

    /**
     * Getter used for accessing the first node that the edge is connected to
     * @return the first node that defines the edge
     */
    public GraphNode getNodeA() {
        return nodeA;
    }

    /**
     * Getter used for accessing the second node that the edge is connected to
     * @return the second node that defines the edge
     */
    public GraphNode getNodeB() {
        return nodeB;
    }

    /**
     * Getter used for accessing the name of the edges
     * @return the name of the edge
     */
    public String getEdgeName() {
        return edgeName;
    }
}
