package org.example.binarytree.pathtoleaves;

import java.util.ArrayList;
import java.util.List;

import static org.example.binarytree.pathtoleaves.IterativeConstructBinaryTree.construct;

public class PathSumII {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 11, 7, null, null, 2,  null, null,null, 8, 13, null, null, 4, 5, null, null, 1, null,null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);
        System.out.println();
        int targetSum = 22;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> psf = new ArrayList<>();
        solve(tree, 0, targetSum, psf, res);
        System.out.println(res);
    }
    public static void preOrdertraversal(TreeNode node)
    {
        if(node == null) return;
        System.out.print(node.data + " ");
        preOrdertraversal(node.left);
        preOrdertraversal(node.right);
    }
    public static void solve(TreeNode node, int ssf, int target, List<Integer> psf, List<List<Integer>> res)
    {
        if(node == null) return;

        if(node.left == null && node.right == null)
        {
            if(ssf + node.data == target)
            {
                psf.add(node.data);
                res.add(new ArrayList<>(psf));
                psf.remove(psf.size() - 1);
            }
            return;
        }

        psf.add(node.data);
        solve(node.left, ssf + node.data , target, psf, res);
        psf.remove(psf.size() - 1);

        psf.add(node.data);
        solve(node.right, ssf + node.data, target, psf, res);
        psf.remove(psf.size() - 1);
    }
}
