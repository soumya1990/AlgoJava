package com.algo.graph;

import com.algo.graph.UnDirectedGraphList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class UndirectedGraphListTest {
    @Test
    public void testGraphIntegrity(){
        UnDirectedGraphList G = new UnDirectedGraphList(3,3);
        G.addEdge(1,2);
        G.addEdge(3,1);
        G.addEdge(2,3);
        Assert.assertEquals(G.E(),3);
        Assert.assertEquals(G.V(),3);

        Iterable<Integer> adjVertices1 = G.adj(1);
        Iterable<Integer> adjVertices2 = G.adj(2);
        Iterable<Integer> adjVertices3 = G.adj(3);


        ArrayList<Integer>adjVertices1act = new ArrayList<>();
        ArrayList<Integer>adjVertices2act = new ArrayList<>();
        ArrayList<Integer>adjVertices3act = new ArrayList<>();
        for (int vertex:adjVertices1 ){
            adjVertices1act.add(vertex);
        }
        for (int vertex:adjVertices2 ){
            adjVertices2act.add(vertex);
        }
        for (int vertex:adjVertices3 ){
            adjVertices3act.add(vertex);
        }
        ArrayList<Integer>adjVertices1exp = new ArrayList<>();
        ArrayList<Integer>adjVertices2exp = new ArrayList<>();
        ArrayList<Integer>adjVertices3exp = new ArrayList<>();

        adjVertices1exp.add(2);
        adjVertices1exp.add(3);

        adjVertices2exp.add(1);
        adjVertices2exp.add(3);

        adjVertices3exp.add(1);
        adjVertices3exp.add(2);

        Collections.sort(adjVertices1act);
        Collections.sort(adjVertices2act);
        Collections.sort(adjVertices3act);
        Assert.assertEquals(adjVertices1act,adjVertices1exp);
    }
}
