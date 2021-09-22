package com.shortestPath.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShorterPathFinder {


    public abstract void findShortestPath(AdjacencyLists adjacencyLists);


    public List<Vertex> getShortestPathTo(Vertex targetVertex){
        List<Vertex> path = new ArrayList<>();

        for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){
            path.add(vertex);
        }

        Collections.reverse(path);

        return path;
    }

}
