package com.shortestPath.model;

import java.util.PriorityQueue;

public class ShorterPathFinderNODAG extends ShorterPathFinder{

    /**
     * Dijkstra Algorithm
     * */

    @Override
    public void findShortestPath(AdjacencyLists adjacencyLists) {


        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        Vertex vertex = adjacencyLists.getGraph().get(0);
        vertex.setVisited(true);
        vertex.setDistance(0);
        priorityQueue.add(vertex);

        while(!priorityQueue.isEmpty()) {

            Vertex current = priorityQueue.poll();

            for(Edge edge: current.getEdges()) {

                Vertex vertexDestiny = edge.getVertexDestiny();

                if(!vertexDestiny.isVisited()) {

                    double newDistance = current.getDistance() + edge.getWeight();


                    if(newDistance < vertexDestiny.getDistance()) {

                        priorityQueue.remove(vertexDestiny);
                        vertexDestiny.setDistance(newDistance);
                        vertexDestiny.setPredecessor(current);
                        priorityQueue.add(vertexDestiny);

                    }

                }

            }

            current.setVisited(true);
        }

    }

}
