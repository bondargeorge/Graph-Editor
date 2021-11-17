package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * Represents an action made to allow the user to change the name of a node
 */
public class RenameNodeAction extends AbstractAction implements Observer {

    private final GraphModel graphModel;

    /**
     * Creates a new action for renaming a node
     * @param graphModel The actual graph
     */
    public RenameNodeAction(GraphModel graphModel) {
        super("Rename node");
        this.graphModel = graphModel;
        graphModel.addObserver(this);
        fixEnabled();
    }

    /**
     * Makes sure the availability of the action reflects the availability of
     * the resource it acts on, namely, renaming a selected node.
     */
    private void fixEnabled() {
          setEnabled(graphModel.getSelectedNode() != null);
    }

    /**
     * Allows the user to rename a selected node
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graphModel.renameNode();
    }

    /**
     * Since availability of this action depends on the state of the
     * resources it itself depends on, this action verifies
     * after every update of renaming a node if it can still be performed.
     */
    @Override
    public void update(Observable o, Object arg) {
         fixEnabled();
    }
}
