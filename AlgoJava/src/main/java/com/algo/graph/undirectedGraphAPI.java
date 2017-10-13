package com.algo.graph;

public interface undirectedGraphAPI {

    /**
     * returns the number of vertices of the graph
     * @return Number of vertices of the graph*/
    int V();

    /**
     *Returns the number of Edges of the graph
     * @return number of edges */
    int E();

    /**
     * adds an edge to the graph.
     * @param u {@link Integer}: src vertex.
     * @param v {@link Integer}: dst vertex.
     * */
    void addEdge(int u,int v);

    /**
     * Fetches the adjacent vertices of a vertex.
     * @param v {@link Integer} vertex whose adjacent vertices to be
     * found.
     * @return Iterable of adjacent vertices </>*/
    Iterable<Integer> adj(int v);

}
