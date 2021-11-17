package nl.rug.oop.grapheditor;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.GraphFrame;

/**
 * Runs the graph-editor. Although technically a controller this class can be found
 * more easily if it's not in that package
 */
public class GraphEditor {

    public static void main(String[] args) {
        /* Create the graph-editor */
        GraphModel graphModel = new GraphModel();
        /* Create */
        new GraphFrame(graphModel);
    }
}