package nl.rug.oop.grapheditor.io;

import nl.rug.oop.grapheditor.model.GraphEdge;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.GraphNode;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that contains some methods for saving and loading a graph
 */
public class Serializer {

    /**
     * Saves a graph in a predefined save file
     *
     * @param graphModel The graph that needs to be saved
     * @param fileName The name of the save file the graph should be saved in
     */
    public static void saveGraph(GraphModel graphModel, String fileName) {
        /* Sets up the save directory */
        File saveDirectory = new File("savedgraphs");
        saveDirectory.mkdir();
        /* write object to a file */
        try ( FileOutputStream fileOutputStream = new FileOutputStream(saveDirectory + File.separator + fileName + ".ser");
              ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(graphModel);
            System.out.println("Save successful!");
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
        } catch (IOException e) {
            System.out.println("Could not write to file");
        }
    }

    /**
     * Loads a graph from a predefined save file
     *
     * @param fileName The name of the save file the game should be loaded from
     * @return The graph that was saved in the save file
     * @throws IOException If the file could not be found or read from
     * @throws ClassNotFoundException If the class could not be properly loaded
     */
    public static GraphModel loadGraph(String fileName) throws IOException, ClassNotFoundException {
        File saveDirectory = new File("savedgraphs");

        try(FileInputStream fileInputStream = new FileInputStream(saveDirectory + File.separator + fileName + ".ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            System.out.println("Load successful");
            return (GraphModel)objectInputStream.readObject();
        }
    }

    /**
     * This method saves a graph in a custom format, in a file that the user has selected through JFileChooser
     * @param model The graph that should be saved
     */
    public static void save(GraphModel model) {
        /* write object to a file */
        JFileChooser chooser = new JFileChooser();
        int retrieval = chooser.showSaveDialog(null);
        if (retrieval == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = chooser.getSelectedFile();
                selectedFile.mkdir();
                chooser.setCurrentDirectory(selectedFile);
                FileWriter writer = new FileWriter( selectedFile + File.separator + selectedFile.getName() + ".gph");
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(model.getGraphNodes().size() + " " + model.getGraphEdges().size());
                bufferedWriter.newLine();
                for (GraphNode node : model.getGraphNodes()) {
                    bufferedWriter.write(node.getX() + " " + node.getY() + " " +
                            node.getHeight() + " " + node.getWidth() + " " + node.getName());
                    bufferedWriter.newLine();
                }
                for (GraphEdge edge : model.getGraphEdges()) {
                    bufferedWriter.write(model.getGraphNodes().indexOf(edge.getNodeA()) + " " +
                            model.getGraphNodes().indexOf(edge.getNodeB()));
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } catch (Exception ex) {
                System.out.println("Could not write to file.");
            }
        }
    }

    /**
     * This method loads a graph in a custom format, from a file that the user has selected through JFileChooser
     * @return The saved graphed
     */
    public static GraphModel load() {
        GraphModel model =  new GraphModel();
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                FileReader fileReader = new FileReader(chooser.getSelectedFile().getPath());
                BufferedReader reader = new BufferedReader(fileReader);
                FileNameExtensionFilter filter = new FileNameExtensionFilter(".gph documents", ".gph");
                chooser.setFileFilter(filter);
                Scanner scan = new Scanner(reader);
                while (scan.hasNext()) {
                    int numberOfNodes = scan.nextInt();
                    int numberOfEdges = scan.nextInt();
                    for (int i = 0; i < numberOfNodes; i++) {
                        int posX = scan.nextInt();
                        int posY = scan.nextInt();
                        int height = scan.nextInt();
                        int width = scan.nextInt();
                        String name = scan.nextLine();
                        model.getGraphNodes().add(new GraphNode(posX, posY, height, width, name));
                    }
                    for (int i = 0; i < numberOfEdges; i++) {
                        int nodeA = scan.nextInt();
                        int nodeB = scan.nextInt();
                        model.getGraphEdges().add(new GraphEdge(model.getGraphNodes().get(nodeA), model.getGraphNodes().get(nodeB)));
                    }
                }
                reader.close();
            } catch (InputMismatchException e) {
                return null;
            } catch (IOException e) {
                System.out.println("Could not read from file");
            }
        }
       return model;
    }
}