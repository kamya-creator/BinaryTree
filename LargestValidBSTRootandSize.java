package org.example.binarytree.RecursionInRecursionTypeProblems;

import static org.example.binarytree.RecursionInRecursionTypeProblems.IsValidBST.largestValidBST;
import static org.example.binarytree.RecursionInRecursionTypeProblems.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.RecursionInRecursionTypeProblems.IterativeConstructBinaryTree.preOrdertraversal;

public class LargestValidBSTRootandSize {
    public static void main(String[] args) {
        Integer[] arr = {6,7, null, 2, null, null, 3, 2, null, null, 4, null,null};

        TreeNode tree = construct(arr);
        preOrdertraversal(tree);
        int[] sizeOfLargestBST = new int[1];
        largestValidBSTRoot(tree, sizeOfLargestBST);
        System.out.println(sizeOfLargestBST[0]);
    }
    public static void largestValidBSTRoot(TreeNode node, int[] sizeOfLargestBST)
    {
        if(node == null)
        {
            return;
        }

        largestValidBSTRoot(node.left, sizeOfLargestBST);
        largestValidBSTRoot(node.right, sizeOfLargestBST);

        if(largestValidBST(node))
        {
            int size = sizeOfBT(node);
            System.out.println(size + " Size for node " + node.data);
            sizeOfLargestBST[0] = Math.max(sizeOfLargestBST[0], size);
        }


    }
    public static int sizeOfBT(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }

        int left = sizeOfBT(node.left);
        int right = sizeOfBT(node.right);
        return left + right +1;

    }
}
