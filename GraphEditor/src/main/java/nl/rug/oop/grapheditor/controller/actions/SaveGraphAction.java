package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Represents an action made for saving in a custom format a graph, in a file specified by the user
 */
public class SaveGraphAction extends AbstractAction {

    private final GraphModel graphModel;

    /**
     * Creates a new action for saving the graph
     * @param graphModel The actual graph
     */
    public SaveGraphAction(GraphModel graphModel) {
        super("Custom Save");
        this.graphModel = graphModel;
    }

    /**
     * Action that saves the graph to a specific file
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graphModel.customSave();
    }
}
