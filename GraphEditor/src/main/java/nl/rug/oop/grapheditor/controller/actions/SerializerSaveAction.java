package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Represents an action made for saving a graph using Serializer, in a file specified
 */
public class SerializerSaveAction extends AbstractAction {

    private final GraphModel graphModel;

    /**
     * Creates a new action for saving the graph
     * @param graphModel The actual graph
     */
    public SerializerSaveAction(GraphModel graphModel) {
        super("Serializer Save");
        this.graphModel = graphModel;
    }

    /**
     * Action that saves the graph to a predefined file
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graphModel.serializerSave();
    }
}

