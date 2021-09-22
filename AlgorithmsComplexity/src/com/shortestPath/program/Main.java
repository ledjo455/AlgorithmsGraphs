package com.shortestPath.program;

import com.shortestPath.Util.FileManager;
import com.shortestPath.model.*;

import java.util.ArrayList;

import static com.shortestPath.Util.Util.*;

public class Main {

    public static void main(String[] args) {


        AdjacencyLists graphFromFile = FileManager.createGraphFromFile("C:\\Users\\Ledjo\\IdeaProjects\\LedjoUendiAlgs2\\src\\com\\shortestPath\\resources\\Graph.txt");

        System.out.println("Graph extracted: ");
        printAdjacencyList(graphFromFile);
        System.out.println("------------------------------------");

        ShorterPathFinder shorterPathFinder = null;

        if(!graphFromFile.isDAG()) {
            System.out.println("Graph is not DAG");
            shorterPathFinder = new ShorterPathFinderNODAG();
        } else {
            System.out.println("Graph is a DAG, Graph sorted: ");
            printAdjacencyList(graphFromFile);
            System.out.println("------------------------------------");
            shorterPathFinder = new ShorterPathFinderDAG();
        }

        shorterPathFinder.findShortestPath(graphFromFile);

        ArrayList<Vertex> graph = graphFromFile.getGraph();
        printTrace(graph, shorterPathFinder);
    }

}