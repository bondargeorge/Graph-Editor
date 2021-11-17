package nl.rug.oop.grapheditor.view;

import nl.rug.oop.grapheditor.controller.ButtonBar;
import nl.rug.oop.grapheditor.controller.SelectionController;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the frame of the graph-editor
 */
public class GraphFrame extends JFrame {

    public GraphFrame(GraphModel graphModel) {
        /* Create a frame for the GUI */
        super("Graph Editor");
        /* Make sure our program exits when we close the frame */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Add a menu to the frame */
        setJMenuBar(new ButtonBar(graphModel));
        /* Create a view for the game */
        GraphPanel graphPanel = new GraphPanel(graphModel);
        /* Create a controller for the mouse input */
        new SelectionController(graphModel, graphPanel);
        /* Add the view to the frame */
        add(graphPanel);
        /* Set the size of the frame */
        setPreferredSize(new Dimension(800, 600));
        /* Try to make all the components at or above their preferred size */
        pack();
        /* Center the frame on the screen */
        setLocationRelativeTo(null);
        /* Make sure we can actually see the frame */
        setVisible(true);
    }
}
