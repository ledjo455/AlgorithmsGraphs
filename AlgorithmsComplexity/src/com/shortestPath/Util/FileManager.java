package com.shortestPath.Util;

import com.shortestPath.model.AdjacencyLists;
import com.shortestPath.model.GraphSorterImplementation;
import com.shortestPath.model.Edge;
import com.shortestPath.model.Vertex;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileManager {

    /**
     * Extracts graph from file
     * */
    private static double[] separate(String line) {

        String[] s = line.split(" ");
        double[] numbers = new double[s.length];

        for (int i = 0; i < s.length; i++) {
            numbers[i] = Double.parseDouble(s[i]);
        }

        return numbers;
    }

    private static HashMap<Integer, Vertex> initVertices(int amount) {

        HashMap<Integer, Vertex> hashedVertex = new HashMap<>(amount);

        for (int i = 0; i < amount; i++) {
            Vertex newVertex = new Vertex(i);
            hashedVertex.put(i, newVertex);
        }

        return hashedVertex;
    }

    public static AdjacencyLists createGraphFromFile(String filePath) {

        HashMap<Integer, Vertex> hashedVertex = null;
        AdjacencyLists result = null;

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if(line.charAt(0) != '#') {

                    if(!firstLine) {

                        double[] numbers = separate(line);

                        Vertex vertexOrigin = hashedVertex.get((int) numbers[0]);
                        Vertex vertexDestiny = hashedVertex.get((int) numbers[1]);
                        double weight = numbers[2];

                        new Edge(vertexOrigin, vertexDestiny, weight);

                    } else { // first line
                        firstLine = false;
                        double[] numbers = separate(line);
                        hashedVertex = initVertices((int) numbers[0]);
                        result = new AdjacencyLists((int) numbers[0], (int) numbers[1], new GraphSorterImplementation());
                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        assert hashedVertex != null;

        result.setGraph(new ArrayList<>(hashedVertex.values()));

        return result;
    }




}
