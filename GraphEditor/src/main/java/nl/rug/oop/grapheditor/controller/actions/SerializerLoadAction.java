package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Represents an action made for loading a graph using Serializer, in a file specified
 */
public class SerializerLoadAction extends AbstractAction {

    private final GraphModel graphModel;

    /**
     * Creates a new action for loading the graph
     * @param graphModel The actual graph
     */
    public SerializerLoadAction(GraphModel graphModel) {
        super("Serializer Load");
        this.graphModel = graphModel;
    }

    /**
     * Action that loads the graph from a predefined file
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graphModel.serializerLoad();
    }
}
