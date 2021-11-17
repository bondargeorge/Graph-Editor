package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.AddNodeAction;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;

/**
 * Button that adds a node to the graph when pressed
 */
public class AddNodeButton extends JButton {

    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Add a node to the graph");
    }

    /**
     * Creates an 'add node button'
     * @param graphModel - the actual graph, passed to the controllers
     */
    public AddNodeButton(GraphModel graphModel) {
        super(new AddNodeAction(graphModel));
        setButtonProperties();
    }
}