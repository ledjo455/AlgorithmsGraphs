package com.shortestPath.model;

import java.util.ArrayList;

public class AdjacencyLists {
    /**
     * Adjacency List implementation
     * */

    private ArrayList<Vertex> graph;
    private final int amountOfVertices, amountOfEdges;
    private boolean isDAG, isDAGValidated;
    private GraphTopologicalSorter sorter;

    public AdjacencyLists(int amountOfVertices, int amountOfEdges, GraphTopologicalSorter sorter) {

        this.amountOfVertices = amountOfVertices;
        this.amountOfEdges = amountOfEdges;
        this.sorter = sorter;
        isDAGValidated = false;
    }

    public void setGraph(ArrayList<Vertex> graph) {
        this.graph = graph;
    }

    public ArrayList<Vertex> getGraph() {
        return graph;
    }

    public void insertVertex(Vertex vertex) {
        graph.add(vertex);
    }

    public int getAmountOfVertices() {
        return amountOfVertices;
    }

    public int getAmountOfEdges() {
        return amountOfEdges;
    }

    public boolean isDAG() {

        if(!isDAGValidated) {
            isDAG = sorter.sort(this);
            isDAGValidated = true;
        }

        return isDAG;
    }

    public GraphTopologicalSorter getSorter() {
        return sorter;
    }

}
