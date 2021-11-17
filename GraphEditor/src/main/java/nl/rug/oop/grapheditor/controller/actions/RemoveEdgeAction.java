package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * Represents an action made to allow the user to remove an edge
 */
public class RemoveEdgeAction extends AbstractAction implements Observer {

    private final GraphModel graphModel;

    /**
     * Creates a new action for removing edges
     * @param graphModel The actual graph
     */
    public RemoveEdgeAction(GraphModel graphModel) {
        super("Remove edge");
        this.graphModel = graphModel;
        graphModel.addObserver(this);
         fixEnabled();
    }

    /**
     * Makes sure the availability of the action reflects the availability of
     * the resource it acts on, namely, removing an edge.
     */
    private void fixEnabled() {
        setEnabled(graphModel.getGraphEdges().size() > 0);
    }

    /**
     * Allows the user to remove a selected edge from a drop-down menu
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graphModel.removeEdges();
    }

    /**
     * Since availability of this action depends on the state of the
     * resources it itself depends on, this action verifies
     * after every update of removing an edge if it can still be performed.
     */
    @Override
    public void update(Observable o, Object arg) {
        fixEnabled();
    }
}
