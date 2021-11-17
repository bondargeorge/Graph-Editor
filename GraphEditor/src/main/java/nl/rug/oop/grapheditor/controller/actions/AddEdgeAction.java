package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * Represents an action made to allow the user to add an edge
 */
public class AddEdgeAction extends AbstractAction implements Observer {

    private final GraphModel graphModel;

    /**
     * Creates a new action for adding edges
     * @param graphModel The actual graph
     */
    public AddEdgeAction(GraphModel graphModel) {
        super("Add Edge");
        this.graphModel = graphModel;
        graphModel.addObserver(this);
        fixEnabled();
    }

    /**
     * Makes sure the availability of the action reflects the availability of
     * the resource it acts on, namely, adding an edge.
     */
    private void fixEnabled() {
        setEnabled(graphModel.getGraphNodes().size() > 1 && graphModel.getSelectedNode() != null);
    }

    /**
     * Creates an edge from a selected node to the mouse cursor
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graphModel.setConnected(true);
    }

    /**
     * Since availability of this action depends on the state of the
     * resources it itself depends on, this action verifies
     * after every update of adding an edge if it can still be performed.
     */
    @Override
    public void update(Observable o, Object arg) {
        fixEnabled();
    }
}
