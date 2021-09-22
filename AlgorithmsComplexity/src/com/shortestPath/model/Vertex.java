package com.shortestPath.model;

import java.util.ArrayList;
import java.util.Objects;

public class Vertex implements Comparable<Vertex>{

    private final int name;
    private ArrayList<Edge> edges;
    private ArrayList<Edge> IncomeEdges;
    private Vertex predecessor;
    private boolean visited;
    private double distance;

    public Vertex(int name) {
        this.name = name;
        edges = new ArrayList<>(5);
        IncomeEdges = new ArrayList<>(5);
        visited = false;
        distance = Double.MAX_VALUE;
    }

    public int getName() {
        return name;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Edge> getIncomeEdges() {
        return IncomeEdges;
    }

    public void insertEdge(Edge edge) {
        edges.add(edge);
    }

    public void insertIncomeEdge(Edge edge) {
        IncomeEdges.add(edge);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return name == vertex.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getDistance());
    }

    public void setPredecessor(Vertex current) {
        this.predecessor = current;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }
}
