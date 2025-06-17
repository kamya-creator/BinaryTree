package org.example.binarytree.RecursionInRecursionTypeProblems;

import static org.example.binarytree.RecursionInRecursionTypeProblems.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.RecursionInRecursionTypeProblems.IterativeConstructBinaryTree.preOrdertraversal;

public class IsValidBST {
    public static void main(String[] args) {
        /*
         Integer[] arr = {50,25,12,null, null,37,30, null, null, 40, null, null, 75,62,60,51,null,null,61,null,null,77,74,null,null, 78, null,null,87, null,null};

         */
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, 40, null, null,
                75, 62, 60, null, null, 65, null, null,
                87, 80, null, null, 90, null, null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        System.out.println();
        boolean validBST = largestValidBST(tree);
        System.out.println(validBST);

    }
    public static boolean largestValidBST(TreeNode node)
    {
        if(node == null)
        {
            return true;
        }

        boolean isleftBST = largestValidBST(node.left);
        if(isleftBST == false) return false;
        boolean isRightBST = largestValidBST(node.right);
        if(isRightBST == false) return false;

        boolean amIBSTasNode = node.data > maxOfTree(node.left) && node.data < minOfTree(node.right);
        if(amIBSTasNode == false) return false;


        boolean amIBSTasTree = isleftBST && isRightBST && amIBSTasNode;
        return amIBSTasTree;
    }

    public static int maxOfTree(TreeNode node)
    {
        if(node == null)
        {
            return Integer.MIN_VALUE;
        }

        int maxOfLeft = maxOfTree(node.left);
        int maxOfRight = maxOfTree(node.right);

        return Math.max(node.data, Math.max(maxOfLeft, maxOfRight));
    }
    public static int minOfTree(TreeNode node)
    {
        if(node == null)
        {
            return Integer.MAX_VALUE;
        }

        int minOfLeft = minOfTree(node.left);
        int minOfRight = minOfTree(node.right);

        return Math.min(node.data, Math.min(minOfLeft, minOfRight));
    }
}
