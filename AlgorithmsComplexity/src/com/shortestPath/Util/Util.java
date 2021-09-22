package com.shortestPath.Util;

import com.shortestPath.model.AdjacencyLists;
import com.shortestPath.model.ShorterPathFinder;
import com.shortestPath.model.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Util {

    /**
     * Printing methods
     * */

    public static void printTrace(ArrayList<Vertex> graph, ShorterPathFinder shorterPathFinder) {

        for (int i = 1; i < graph.size(); i++) {

            Vertex vertex = graph.get(i);
            List<Vertex> shortestPathTo = shorterPathFinder.getShortestPathTo(vertex);
            System.out.print("Node " + vertex.getName() + ": ");
            shortestPathTo.forEach(v -> System.out.print(" -> " + v.getName()));
            System.out.print(" total distance = " + vertex.getDistance());
            System.out.println();

        }

    }

    public static void printAdjacencyList(AdjacencyLists adjacencyLists) {
        adjacencyLists.getGraph().forEach(v -> {
            System.out.print(v.getName());

            v.getEdges().forEach(e -> {
                System.out.print("\t---" + e.getWeight() +"--->\t" + e.getVertexDestiny().getName());
            });
            System.out.println();
        });
    }

}
