package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.RemoveEdgeAction;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;

/**
 * Button that removes an edge from the ArrayList of edges and accordingly, updates the panel letting the user know that
 * an edge has been removed
 */
public class RemoveEdgeButton extends JButton {

    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Remove an edge from the graph");
    }

    /**
     * Creates a 'remove edge button'
     * @param graphModel - the actual graph, passed to the controllers
     */
    public RemoveEdgeButton(GraphModel graphModel) {
        super(new RemoveEdgeAction(graphModel));
        setButtonProperties();
    }
}