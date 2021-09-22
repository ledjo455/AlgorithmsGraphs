package com.shortestPath.model;

public interface GraphTopologicalSorter {

    /**
     * Sorts the given graph, return true if the graph is a DAG
     * */
    boolean sort(AdjacencyLists graph);

}
