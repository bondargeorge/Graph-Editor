package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * Represents an action made to allow the user to remove a node
 */
public class RemoveNodeAction extends AbstractAction implements Observer {

    private final GraphModel graphModel;

    /**
     * Creates a new action for removing nodes
     * @param graphModel The actual graph
     */
    public RemoveNodeAction(GraphModel graphModel) {
        super("Remove node");
        this.graphModel = graphModel;
        graphModel.addObserver(this);
        fixEnabled();
    }

    /**
     * Makes sure the availability of the action reflects the availability of
     * the resource it acts on, namely, removing a selected node.
     */
    private void fixEnabled() {
        setEnabled(graphModel.getSelectedNode() != null && graphModel.getGraphNodes().size() >= 1);
    }

    /**
     * Allows the user to remove a selected node and all edges that were connected to it
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graphModel.removeNodes();
    }

    /**
     * Since availability of this action depends on the state of the
     * resources it itself depends on, this action verifies
     * after every update of removing a node if it can still be performed.
     */
    @Override
    public void update(Observable o, Object arg) {
        fixEnabled();
    }
}