package com.algo.binarysearchtree;

import lombok.Getter;
import lombok.Setter;

public class NodeBST {
    @Getter @Setter private int key;
    @Getter @Setter private String val;
    @Getter @Setter private NodeBST left;
    @Getter @Setter private NodeBST right;
}
