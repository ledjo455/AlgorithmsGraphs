package com.shortestPath.model;

import java.util.Objects;

public class Edge {

    final Vertex vertexOrigin;
    final Vertex vertexDestiny;
    final double weight;

    public Edge(Vertex vertexOrigin, Vertex vertexDestiny, double weight) {
        this.vertexOrigin = vertexOrigin;
        this.vertexDestiny = vertexDestiny;
        this.weight = weight;

        vertexOrigin.insertEdge(this);
        vertexDestiny.insertIncomeEdge(this);
    }

    public Vertex getVertexOrigin() {
        return vertexOrigin;
    }

    public double getWeight() {
        return weight;
    }

    public Vertex getVertexDestiny() {
        return vertexDestiny;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Double.compare(edge.weight, weight) == 0 && vertexOrigin.equals(edge.vertexOrigin) && vertexDestiny.equals(edge.vertexDestiny);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexOrigin, vertexDestiny, weight);
    }

}
