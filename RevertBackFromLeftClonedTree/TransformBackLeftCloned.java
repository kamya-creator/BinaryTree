package org.example.binarytree.pathtoleaves;

import static org.example.binarytree.pathtoleaves.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.pathtoleaves.PathSumI.preOrdertraversal;

public class TransformBackLeftCloned {
    // 1 1 2 2 4 4 5 5 3 3 6 6 7 7
    public static void main(String[] args) {
        Integer[] arr = {1, 1, 2, 2, 4, 4, null, null, null, null,5 ,5 , null, null, null, null, 3 ,3,  6, 6, null, null, null, null, 7,7,null, null,null };
        TreeNode tree = construct(arr);
        transformBack(tree);
        preOrdertraversal(tree);
    }
    public static void transformBack(TreeNode node)
    {
        if(node == null) return;


            node.left = node.left.left;
            System.out.println("Node " + node.data);

            transformBack(node.left);
            transformBack(node.right);

    }
}
