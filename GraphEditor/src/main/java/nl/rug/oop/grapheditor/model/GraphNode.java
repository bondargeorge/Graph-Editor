package nl.rug.oop.grapheditor.model;

import java.io.Serializable;

/**
 * Class used for representing a node
 */
public class GraphNode implements Serializable {

    private static final long serialVersionUID = 2L;
    private int x, y;
    private final int height, width;
    private String name;

    /**
     * Constructor that initialises a node with a size, location and a name.
     *
     * @param x coordinate of the node
     * @param y coordinate of the node
     * @param height of the node
     * @param width of the node
     * @param name of the node
     */
    public GraphNode(int x, int y, int height, int width, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width= width;
    }

    /**
     * Method used for setting the name of a node
     * @param name the name of the node
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter used for accessing the name of the node
     * @return the name of the node
     */
    public String getName() {
        return name;
    }

    /**
     * Getter used for accessing the x coordinate of the node
     * @return the x coordinate of the node
     */
    public int getX() {
        return x;
    }

    /**
     * Getter used for accessing the y coordinate of the node
     * @return the y coordinate of the node
     */
    public int getY() {
        return y;
    }

    /**
     * Getter used for accessing the height of the node
     * @return the height of the node
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter used for accessing the width of the node
     * @return the width of the node
     */
    public int getWidth() {
        return width;
    }

    /**
     * Method used for setting the x coordinate of the node
     * @param x the x coordinate of the node
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Method used for setting the y coordinate of the node
     * @param y the y coordinate of the node
     */
    public void setY(int y) {
        this.y = y;
    }
}
