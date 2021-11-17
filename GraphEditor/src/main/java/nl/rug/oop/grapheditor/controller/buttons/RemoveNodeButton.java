package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.RemoveNodeAction;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;

/**
 * Button that removes a node from the ArrayList of nodes and accordingly, updates the panel letting the user know that
 * a node has been removed
 */
public class RemoveNodeButton extends JButton {

    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Remove a node from the graph");
    }

    /**
     * Creates a 'remove node button'
     * @param graphModel - the actual graph, passed to the controllers
     */
    public RemoveNodeButton(GraphModel graphModel) {
        super(new RemoveNodeAction(graphModel));
        setButtonProperties();
    }
}