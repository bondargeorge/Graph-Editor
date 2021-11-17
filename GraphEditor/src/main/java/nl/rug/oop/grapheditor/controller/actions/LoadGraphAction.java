package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Represents an action made for loading in a custom format, a saved graph from a file
 */
public class LoadGraphAction extends AbstractAction {

    private final GraphModel graphModel;

    /**
     * Creates a new action for loading the graph
     * @param graphModel The actual graph
     */
    public LoadGraphAction(GraphModel graphModel) {
        super("Custom Load");
        this.graphModel = graphModel;
    }

    /**
     * Action that loads the graph from a selected file
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graphModel.customLoad();
    }
}
