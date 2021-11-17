package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.AddEdgeAction;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;

/**
 * Button that adds an edge to the graph when pressed
 */
public class AddEdgeButton extends JButton {

    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Add an edge to the graph");
    }

    /**
     * Creates an 'add edge button'
     * @param graphModel - the actual graph, passed to the controllers
     */
    public AddEdgeButton(GraphModel graphModel) {
        super(new AddEdgeAction(graphModel));
        setButtonProperties();
    }
}