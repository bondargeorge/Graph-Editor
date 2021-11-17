package nl.rug.oop.grapheditor.controller;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.controller.buttons.*;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;

/**
 * Panel with the buttons for the graph-class controllers
 */
public class ButtonBar extends JMenuBar {

    /**
     * Create a new ButtonBar with all the necessary buttons and drop menus for saving & loading
     * @param graphModel The actual model of the graph, passed to the controllers
     */
    public ButtonBar(GraphModel graphModel) {
        add(new AddNodeButton(graphModel));
        add(new AddEdgeButton(graphModel));
        add(new RemoveNodeButton(graphModel));
        add(new RemoveEdgeButton(graphModel));
        add(new RenameNodeButton(graphModel));
        add(new NewGraphButton(graphModel));
        JMenu saveMenu = new JMenu("Save");
        add(saveMenu);
        JMenu loadMenu = new JMenu("Load");
        add(loadMenu);
        saveMenu.add(new SaveGraphAction(graphModel));
        saveMenu.add(new SerializerSaveAction(graphModel));
        loadMenu.add(new LoadGraphAction(graphModel));
        loadMenu.add(new SerializerLoadAction(graphModel));
    }
}