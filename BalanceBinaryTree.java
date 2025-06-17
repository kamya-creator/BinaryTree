package org.example.binarytree.RecursionInRecursionTypeProblems;


import static org.example.binarytree.RecursionInRecursionTypeProblems.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.RecursionInRecursionTypeProblems.IterativeConstructBinaryTree.preOrdertraversal;

public class BalanceBinaryTree {
    public static void main(String[] args) {
        //Integer[] arr = {1,2,3,4,null,null,4,null,null,3,null,null,2,null,null};
        Integer[] arr = {3,9,null,null, 20,15, null,null,7,null,null};

        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        System.out.println();

        boolean[] isBalanced = new boolean[1];
        isBalanced[0] = true;
        isBalancedBinaryTree(tree, isBalanced);

        System.out.println(isBalanced[0]);
    }

    public static void  isBalancedBinaryTree(TreeNode node, boolean[] isBalanced)
    {
        if(node == null)
        {
            return;
        }

        isBalancedBinaryTree(node.left, isBalanced);
        isBalancedBinaryTree(node.right, isBalanced);

        int leftHeight = heightOfTreeInTermOfEdges(node.left) + 1;
        int rightHeight = heightOfTreeInTermOfEdges(node.right) + 1;

        int diff = Math.abs(leftHeight - rightHeight);

        if(isBalanced[0] == true)
        {
            isBalanced[0] = diff <=1;
        }
    }
    public static int heightOfTreeInTermOfEdges(TreeNode node)
    {
        if(node == null) return -1;

        int leftht = heightOfTreeInTermOfEdges(node.left);
        int rightht = heightOfTreeInTermOfEdges(node.right);

        return Math.max(leftht, rightht) + 1;
    }
}
