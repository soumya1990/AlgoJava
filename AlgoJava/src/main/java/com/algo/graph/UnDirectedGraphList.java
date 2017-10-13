package com.algo.graph;

import java.util.LinkedList;

public class UnDirectedGraphList implements undirectedGraphAPI {
    private int V;
    private int E;
    LinkedList<Integer> adj[];
    public UnDirectedGraphList(int V,int E){
        this.V = V;
        this.E = E;
        adj = (LinkedList<Integer>[]) new LinkedList[V+1];
        for (int v = 1;v <= V;v++) {
          adj[v] = new LinkedList<>();
        }
    }
    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int u, int v) {
       adj[u].addFirst(v);
       adj[v].addFirst(u);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return  adj[v];
    }
}
