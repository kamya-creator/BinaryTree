package org.example.binarytree.pathtoleaves;

import static org.example.binarytree.pathtoleaves.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.pathtoleaves.PathSumI.preOrdertraversal;



public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,12,null, null,null, 6, null, null,7,8,9,10,null, null,null, 11, null, null,null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);
        int diameter = diameter(tree);
        System.out.println();
        System.out.println("Diameter is :");
        System.out.println(diameter);
    }
    public static int diameter(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }

        int leftSubtreeDia = diameter(node.left);
        int rightSubtreeDia = diameter(node.right);

        int diameterPassThroughCurrentNode = height(node.left) + height(node.right) + 2;

        int myDia = Math.max(diameterPassThroughCurrentNode,Math.max(leftSubtreeDia, rightSubtreeDia));
        return myDia;
    }

    public static int height(TreeNode node)
    {
        if(node == null) return  -1;

        int leftChildHeight = height(node.left);
        int rightChildHeight = height(node.right);

        int myHeight = Math.max(leftChildHeight, rightChildHeight) + 1;
        return myHeight;
    }
}
