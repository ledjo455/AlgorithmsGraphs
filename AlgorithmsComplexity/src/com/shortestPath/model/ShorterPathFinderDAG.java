package com.shortestPath.model;

public class ShorterPathFinderDAG extends ShorterPathFinder{


    /**
     * Using Topological Sort
     * */

    @Override
    public void findShortestPath(AdjacencyLists adjacencyLists) {
        Vertex origin = adjacencyLists.getGraph().get(0);
        origin.setDistance(0);

        adjacencyLists.getGraph().forEach(current -> {

            current.getEdges().forEach(edge -> {

                double distance = current.getDistance() + edge.getWeight();

                if(edge.getVertexDestiny().getDistance() > distance) {
                    edge.getVertexDestiny().setDistance(distance);
                    edge.getVertexDestiny().setPredecessor(current);
                }

            });

        });

    }

}
