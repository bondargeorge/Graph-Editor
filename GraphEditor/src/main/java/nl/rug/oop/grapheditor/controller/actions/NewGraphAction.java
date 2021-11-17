package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Represents an action made for allowing the user to create a new empty graph
 */
public class NewGraphAction extends AbstractAction {

    private final GraphModel graphModel;

    /**
     * Creates a new action for creating a new empty graph
     * @param graphModel The actual graph
     */
    public NewGraphAction(GraphModel graphModel) {
        super("Create new graph");
        this.graphModel = graphModel;
    }

    /**
     * Action that creates the new empty graph
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graphModel.newGraph();
    }
}
