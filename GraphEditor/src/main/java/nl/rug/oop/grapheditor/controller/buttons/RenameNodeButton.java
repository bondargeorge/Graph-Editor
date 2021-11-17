package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.RenameNodeAction;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;

/**
 * Button that renames a node when pressed
 */
public class RenameNodeButton extends JButton {

    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Rename a node from the graph");
    }

    /**
     * Creates a 'rename button'
     * @param graphModel - the actual graph, passed to the controllers
     */
    public RenameNodeButton(GraphModel graphModel) {
        super(new RenameNodeAction(graphModel));
        setButtonProperties();
    }
}