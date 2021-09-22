package com.shortestPath.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class GraphSorterImplementation implements GraphTopologicalSorter {

    /**
     * Tells whether or not the graph is a DAG
     * */
    @Override
    public boolean sort(AdjacencyLists adjacencyLists) {
        HashSet<Edge> edges = new HashSet<>();
        AdjacencyLists sorted = new AdjacencyLists(adjacencyLists.getAmountOfVertices(), adjacencyLists.getAmountOfEdges(), adjacencyLists.getSorter());
        sorted.setGraph(new ArrayList<>(adjacencyLists.getGraph().size()));

        List<Vertex> noIncomingEdges = adjacencyLists.getGraph()
                .parallelStream()
                .filter(vertex -> {
                    edges.addAll(vertex.getEdges());
                    return vertex.getIncomeEdges().isEmpty();
                }).collect(Collectors.toList());


        while(!noIncomingEdges.isEmpty()) {

            Vertex vertex = noIncomingEdges.remove(0);
            sorted.insertVertex(vertex);

            vertex.getEdges().forEach(edge -> {

                edges.remove(edge);

                boolean destinyContainsMoreIncomeEdges = edge.getVertexDestiny()
                        .getIncomeEdges()
                        .parallelStream()
                        .noneMatch(edges::contains);

                if(destinyContainsMoreIncomeEdges)
                    noIncomingEdges.add(edge.getVertexDestiny());

            });

        }

        if(edges.isEmpty()) {
            adjacencyLists.setGraph(sorted.getGraph());
            return true;
        }

        return false;
    }

}
