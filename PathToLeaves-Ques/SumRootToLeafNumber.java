package org.example.binarytree.pathtoleaves;

import java.util.ArrayList;

import static org.example.binarytree.pathtoleaves.IterativeConstructBinaryTree.construct;

public class SumRootToLeafNumber {
    public static void main(String[] args) {
        Integer[] arr = {4, 9, 5, null, null, 1,null, null, 0, null, null};
        TreeNode tree = construct(arr);
        ArrayList<Integer> res = new ArrayList<>();
        solve(tree, 0, res);
        System.out.println(res);
    }
    public static void solve(TreeNode node, int nsf, ArrayList<Integer> res)
    {
        if(node == null) return;

        if(node.left == null && node.right == null)
        {
            nsf = nsf*10 + node.data;
            res.add(nsf);
           // nsf = (nsf - node.data)/10;
            return;
        }
        solve(node.left, nsf*10 + node.data, res);
        solve(node.right, nsf*10 + node.data, res);
    }
}
