package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Represents an action made to allow the user to add a node
 */
public class AddNodeAction extends AbstractAction  {

    private final GraphModel graphModel;

    /**
     * Creates a new action for adding nodes.
     * @param graphModel The actual graph
     */
    public AddNodeAction(GraphModel graphModel) {
        super("Add Node");
        this.graphModel = graphModel;
    }

    /**
     * Creates a node
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graphModel.createNode();
    }
}