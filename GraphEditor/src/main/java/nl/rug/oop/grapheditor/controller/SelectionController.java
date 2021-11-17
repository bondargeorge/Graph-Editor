 package nl.rug.oop.grapheditor.controller;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.GraphNode;
import nl.rug.oop.grapheditor.view.GraphPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

 /**
  * Represents a class that allows the user to select a node
  */
 public class SelectionController extends MouseAdapter {

    private final GraphModel graphModel;
    private final GraphPanel graphPanel;

     /**
      * Constructor that initialises our graph with properties that handle the events of a mouse when it is or it is
      * not in motion.
      * @param graphModel the actual graph
      * @param graphPanel the actual panel
      */
    public SelectionController(GraphModel graphModel, GraphPanel graphPanel) {
        this.graphModel = graphModel;
        this.graphPanel = graphPanel;
        graphPanel.addMouseListener(this);
        graphPanel.addMouseMotionListener(this);
    }

     /**
      * Method that makes the selection of a node and the drawing of an edge possible through the event of pressing the
      * mouse key
      * @param e The MouseEvent needed to locate the position of the cursor
      */
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for (GraphNode node : graphModel.getGraphNodes()) {
            Rectangle nodeBounds = new Rectangle(node.getX(), node.getY(), node.getWidth(), node.getHeight());
            if (nodeBounds.contains(x, y)) {
                if (graphModel.isConnected()) {
                    if (!node.equals(graphModel.getSelectedNode())) {
                        graphModel.setConnected(false);
                        graphModel.createEdge(graphModel.getSelectedNode(), node);
                    }
                } else {
                    if (node.equals(graphModel.getSelectedNode())) {
                        graphModel.setSelectedNode(null);
                    } else {
                        graphModel.setSelectedNode(node);
                    }
                }
            }
        }
    }

     /**
      * Method that allows the user to drag a node when it is selected, following the mouse cursor and prevents it from
      * going outside the panel
      * @param e The MouseEvent needed to locate the position of the cursor
      */
     public void mouseDragged(MouseEvent e) {
         int x = e.getX();
         int y = e.getY();
         GraphNode node = graphModel.getSelectedNode();
         if (!graphModel.isConnected() && node != null) {
             Rectangle nodeBounds = new Rectangle(node.getX(), node.getY(), node.getWidth(), node.getHeight());
             if(nodeBounds.contains(x,y)) {
                 int halfWidth = node.getWidth() / 2;
                 int halfHeight = node.getHeight() / 2;
                 graphModel.move(x - halfWidth, y - halfHeight);
                 /* Conditions that prevent the user from moving a node outside the panel */
                 if (node.getY() <= 0) {
                     graphModel.move(x - halfWidth, 0);
                 }
                 if (node.getX() <= 0) {
                     graphModel.move(0,y-halfHeight);
                 }
                 if (node.getX() <= 0 && node.getY() <= 0) {
                     graphModel.move(0,0);
                 }
                 if (node.getX() + node.getWidth() >= graphPanel.getWidth()) {
                     graphModel.move(graphPanel.getWidth() - node.getWidth(), y - halfHeight);
                 }
                 if (node.getY() + node.getHeight() >= graphPanel.getHeight()) {
                     graphModel.move(x - halfWidth, graphPanel.getHeight() - node.getHeight());
                 }
                 if (y - halfHeight <= 0 && node.getX() + node.getWidth() >= graphPanel.getWidth()) {
                     graphModel.move(graphPanel.getWidth() - node.getWidth(),0);
                 }
                 if (node.getY() + node.getHeight() >= graphPanel.getHeight() &&
                         node.getX() + node.getWidth() >= graphPanel.getWidth()) {
                     graphModel.move(graphPanel.getWidth() - node.getWidth(), graphPanel.getHeight() - node.getHeight());
                 }
                 if (node.getX() <= 0 && node.getY() + node.getHeight() >= graphPanel.getHeight()) {
                     graphModel.move(0, graphPanel.getHeight() - node.getHeight());
                 }
             }
         }
     }

     /**
      * Method that tracks the mouse movement and allows the user to move an edge around, following the mouse cursor.
      * @param e The MouseEvent needed to locate the position of the cursor
      */
    @Override
    public void mouseMoved(MouseEvent e) {
        if (graphModel.isConnected()) {
            graphPanel.setMouseX(e.getX());
            graphPanel.setMouseY(e.getY());
            graphModel.update();
        }
    }
}