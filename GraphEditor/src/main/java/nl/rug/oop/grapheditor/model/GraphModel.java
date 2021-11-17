package nl.rug.oop.grapheditor.model;

import nl.rug.oop.grapheditor.io.Serializer;
import nl.rug.oop.grapheditor.view.GraphPanel;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Class that represents the actual graph-editor
 */
public class GraphModel extends Observable implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<GraphNode> graphNodes;
    private ArrayList<GraphEdge> graphEdges;
    private GraphNode selectedNode;
    private boolean connected;
    private int nodeCounter;

    /* Constructor that keeps track of all the nodes and edges from the graph */
    public GraphModel() {
        graphNodes = new ArrayList<>();
        graphEdges = new ArrayList<>();
        selectedNode = null;
        connected = false;
        nodeCounter = 0;
    }

    /* Method that adds a node to the graph */
    public void createNode() {
        nodeCounter++;
        GraphNode node = new GraphNode(0, 0, 60, 100, "node " + nodeCounter);
        graphNodes.add(node);
        update();
    }

    /* Method that adds an edge to the graph */
    public void createEdge(GraphNode nodeA, GraphNode nodeB) {
        GraphEdge edge = new GraphEdge(nodeA, nodeB);
        graphEdges.add(edge);
        update();
    }

    /* Method that removes a selected node and all its connected edges from the graph */
    public void removeNodes() {
        if (selectedNode != null) {
            graphEdges.removeIf(edge -> selectedNode == edge.getNodeA() || selectedNode == edge.getNodeB());
            graphNodes.remove(selectedNode);
            setSelectedNode(null);
        }
        update();
    }

    /* Method that removes an edge by the index of the selected one from the drop-down menu */
    public void removeEdges() {
        int index = GraphPanel.edgeToRemove(graphEdges);
        if (index != -1) {
            graphEdges.remove(index);
        }
        update();
    }

    /* Method that allows the user to rename a selected node */
    public void renameNode() {
        String newName = GraphPanel.rename();
        if (newName != null) {
            selectedNode.setName(newName);
        }
        update();
    }

    /* Method that saves a graph in a custom format */
    public void customSave() {
        Serializer.save(this);
    }

    /* Method that loads a graph in a custom format */
    public void customLoad() {
        try {
            GraphModel loadedGraph = Serializer.load();
            if (loadedGraph != null) {
                graphNodes.clear();
                graphEdges.clear();
                graphNodes = loadedGraph.graphNodes;
                graphEdges = loadedGraph.graphEdges;
                nodeCounter = loadedGraph.nodeCounter;
                setSelectedNode(null);
            }
        } catch (Exception e) {
            System.out.println("file was not chose");
        }
        update();
    }

    /* Method that saves a graph using Serializer into a specified file */
    public void serializerSave() {
        Serializer.saveGraph(this,"graph");
    }

    /* Method that loads a graph using Serializer from a specified file */
    public void serializerLoad() {
        graphNodes.clear();
        graphEdges.clear();
        try {
            GraphModel loadedGraph = Serializer.loadGraph("graph");
            graphNodes = loadedGraph.graphNodes;
            graphEdges = loadedGraph.graphEdges;
            nodeCounter = loadedGraph.nodeCounter;
            setSelectedNode(null);
        } catch (IOException e) {
            System.out.println("Could not load from the file");
        } catch (ClassNotFoundException e) {
            System.out.println("The save file could not be used to load a graph");
        }
    }

    /* Method that allows the user to create a new empty graph */
    public void newGraph() {
        graphNodes.clear();
        graphEdges.clear();
        nodeCounter = 0;
        update();
    }

    /**
     * Method that allows the user to move a node
     * @param x the coordinate x where the node is moved at
     * @param y the coordinate y where the node is moved at
     */
    public void move(int x, int y) {
        if (selectedNode != null) {
            selectedNode.setX(x);
            selectedNode.setY(y);
        }
        update();
    }

    /**
     * Getter for accessing the list of existing nodes
     * @return the existing nodes
     */
    public ArrayList<GraphNode> getGraphNodes() {
        return graphNodes;
    }

    /**
     * Getter for accessing the list of existing edges
     * @return the existing edges
     */
    public ArrayList<GraphEdge> getGraphEdges() {
        return graphEdges;
    }

    /**
     * Getter for accessing a selected node
     * @return the selected node
     */
    public GraphNode getSelectedNode() {
        return selectedNode;
    }

    /**
     * Method that sets a node to be selected
     * @param node that can be selected
     */
    public void setSelectedNode(GraphNode node) {
        selectedNode = node;
        update();
    }

    /**
     * Boolean method that determines the connection of an edge between two nodes
     * @return the actual connection
     */
    public boolean isConnected() {
        return connected;
    }

    /**
     * Method that first indicates the connection of an edge between a selected node and the mouse cursor,
     * and then from the mouse cursor to the next node, that the user wants to connect the edge to.
     * @param connected determines the connection
     */
    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    /* Method that updates the view whenever a change in the graph is made */
    public void update() {
        setChanged();
        notifyObservers();
    }
}