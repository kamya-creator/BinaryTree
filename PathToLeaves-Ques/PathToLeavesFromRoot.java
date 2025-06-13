package org.example.binarytree.pathtoleaves;

import static org.example.binarytree.pathtoleaves.IterativeConstructBinaryTree.construct;

public class PathToLeavesFromRoot {
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, 40, null, null,  75, 62, 60, null, null, 70, null,null,87, null, null};
        TreeNode tree = construct(arr);
        int low = 150;
        int high = 250;
        solve(tree, 0 , "", low, high);

    }

    public static void solve(TreeNode treeNode, int ssf, String psf, int low, int high)
    {
        if(treeNode == null)
        {
            return ;
        }

        if(treeNode.left == null && treeNode.right == null)
        {
            if(ssf + treeNode.data >= low && ssf + treeNode.data<= high)
            {
                System.out.print(psf +"->" + treeNode.data);
                System.out.println();
            }
            return;
        }

        solve(treeNode.left, ssf + treeNode.data, psf + "->"+treeNode.data , low, high);
        solve(treeNode.right, ssf + treeNode.data, psf + "->"+ treeNode.data, low, high);

    }

}
