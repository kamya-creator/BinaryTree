package org.example.binarytree.pathtoleaves;


import static org.example.binarytree.pathtoleaves.IterativeConstructBinaryTree.construct;

public class PathSumI {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 11, 7, null, null, 2,  null, null, 8, 13, null, null, 4, 5, null, null, 1, null,null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);
        System.out.println();
        int targetSum = 22;
        boolean sumFound = solve(tree, 0, targetSum);
        System.out.println(sumFound);
    }
    public static void preOrdertraversal(TreeNode node)
    {
        if(node == null) return;
        System.out.print(node.data + " ");
        preOrdertraversal(node.left);
        preOrdertraversal(node.right);
    }
    public static boolean solve(TreeNode node , int ssf, int targetSum)
    {
        if(node == null) return false;

        if(node.left == null && node.right == null)
        {
            if(ssf + node.data == targetSum)
            {
                return true;
            }
            return false;
        }

        if(solve(node.left, ssf + node.data, targetSum))return true;
        if(solve(node.right, ssf + node.data, targetSum))return true;

        return false;
    }
}
