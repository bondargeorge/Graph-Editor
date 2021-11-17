package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.NewGraphAction;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;

/**
 * Button that adds the possibility of creating a new empty graph to the program
 */
public class NewGraphButton extends JButton {

    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Create a new empty graph");
    }

    /**
     * Creates a 'new empty graph' button
     * @param graphModel - the actual graph, passed to the controllers
     */
    public NewGraphButton(GraphModel graphModel) {
        super(new NewGraphAction(graphModel));
        setButtonProperties();
    }
}
