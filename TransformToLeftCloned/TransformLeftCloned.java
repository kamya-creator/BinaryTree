package org.example.binarytree.pathtoleaves;

import static org.example.binarytree.pathtoleaves.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.pathtoleaves.PathSumI.preOrdertraversal;

public class TransformLeftCloned {
    public static void main(String[] args) {
        Integer[] arr = {1,2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null};
        TreeNode tree = construct(arr);
        transformToLeftCloned(tree);
        preOrdertraversal(tree);
    }

    public static void transformToLeftCloned(TreeNode node)
    {
        if(node == null) return;

        transformToLeftCloned(node.left);
        transformToLeftCloned(node.right);

        TreeNode copy = new TreeNode(node.data, node.left, null);
        node.left = copy;
    }
}
