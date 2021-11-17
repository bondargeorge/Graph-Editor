package nl.rug.oop.grapheditor.view;

import nl.rug.oop.grapheditor.model.GraphEdge;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.GraphNode;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * View of the graph-editor
 */
public class GraphPanel extends JPanel implements Observer {

    private final GraphModel graphModel;
    private int mouseX;
    private int mouseY;

    /**
     * Setter for the position X of the mouse.
     * @param mouseX the position X
     */
    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    /**
     * Setter for the position Y of the mouse.
     * @param mouseY the position Y
     */
    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    /**
     * Create a new GraphPanel.
     * @param graphModel the core of the graph-editor
     */
    public GraphPanel(GraphModel graphModel) {
        this.graphModel = graphModel;
        setBackground(Color.GRAY);
        graphModel.addObserver(this);
        setVisible(true);
        setOpaque(true);
    }

    /**
     * Draws the node represented by a rectangle and the corresponding name of it.
     * @param g Graphics object needed for drawing
     */
    public void drawNode(Graphics g) {
        for (GraphNode graphNode : graphModel.getGraphNodes()) {
            FontMetrics metrics = g.getFontMetrics();
            int x = graphNode.getX() + (graphNode.getWidth() - metrics.stringWidth(graphNode.getName())) / 2;
            int y = graphNode.getY() + ((graphNode.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
            g.setColor(Color.ORANGE);
            if (graphNode.equals(graphModel.getSelectedNode())) g.setColor(Color.magenta);
            g.fillRect(graphNode.getX(), graphNode.getY(), graphNode.getWidth(), graphNode.getHeight());
            g.drawRect(graphNode.getX(), graphNode.getY(), graphNode.getWidth(), graphNode.getHeight());
            g.setColor(Color.BLUE);
            g.setFont(new Font("ComicSans", Font.BOLD, 14));
            g.drawString(graphNode.getName(), x, y);
        }
    }

    /**
     * Draws the edge represented by a line, first connected from a selected node to the mouse cursor and then to
     * another node the user wants to connect it to.
     * @param g Graphics object needed for drawing
     */
    public void drawEdge(Graphics g) {
        if (graphModel.getSelectedNode() != null && graphModel.isConnected()) {
            g.setColor(Color.BLACK);
            g.drawLine(graphModel.getSelectedNode().getX() + graphModel.getSelectedNode().getWidth() / 2,
                    graphModel.getSelectedNode().getY() + graphModel.getSelectedNode().getHeight() / 2,
                    mouseX, mouseY);
        }
        for (GraphEdge graphEdge : graphModel.getGraphEdges()) {
            g.drawLine(graphEdge.getNodeA().getX() + graphEdge.getNodeA().getWidth() / 2,
                    graphEdge.getNodeA().getY() + graphEdge.getNodeA().getHeight() / 2,
                    graphEdge.getNodeB().getX() + graphEdge.getNodeB().getWidth() / 2,
                    graphEdge.getNodeB().getY() + graphEdge.getNodeB().getHeight() / 2);
        }
    }

    /**
     * Method that displays a Java component that allows the user to enter a new name for a specific node.
     * @return the name entered or null otherwise
     */
    public static String rename() {
        String name = JOptionPane.showInputDialog("Enter Name");
        if (name != null) {
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You can not have a blank name");
                JOptionPane.getRootFrame().dispose();
            } else if (name.length() > 6) {
                JOptionPane.showMessageDialog(null, "The name you entered is too long");
                JOptionPane.getRootFrame().dispose();
            } else return name;
        }
        return null;
    }

    /**
     * This method using Java components, displays the existing edges and allows the user to select one to be removed.
     * @param graphEdges A list of type edge
     * @return the index of the selected edge from the Java component
     */
    public static int edgeToRemove(List<GraphEdge> graphEdges) {
        String[] edges = new String[graphEdges.size()];
        for (int i = 0; i < graphEdges.size(); i++) {
            GraphEdge edge = graphEdges.get(i);
            edges[i] = edge.getEdgeName();
        }
        JComboBox<String> combo = new JComboBox<>(edges);
        combo.setSelectedIndex(-1);
        JOptionPane.showMessageDialog(null, combo, "Edge to remove", JOptionPane.INFORMATION_MESSAGE);

        return combo.getSelectedIndex();
    }

    /**
     * Paint the items that this class alone is responsible for.
     * <p>
     * This method is part of a template method that calls
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawEdge(g);
        drawNode(g);
    }

    /**
     * Tell this GraphPanel that the object it displays has changed
     */
    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}