package org.example.binarytree.pathtoleaves;

import java.util.ArrayList;
import java.util.List;

import static org.example.binarytree.pathtoleaves.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.pathtoleaves.PathSumI.preOrdertraversal;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 11, 7, null, null, 2,  null, null,null, 8, 13, null, null, 4, 5, null, null, 1, null,null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        List<String> paths = new ArrayList<>();
        StringBuilder psf = new StringBuilder();
        binaryTreeAllPathsToLeaf(tree, "", paths);
        System.out.println(paths);
    }
    public static void binaryTreeAllPathsToLeaf(TreeNode node, String psf, List<String> paths)
    {
        if(node == null) return;

        if(node.left == null && node.right == null)
        {
            psf = psf + node.data;
            paths.add(psf);
            return;
        }
        binaryTreeAllPathsToLeaf(node.left, psf+ node.data +"->", paths);
        binaryTreeAllPathsToLeaf(node.right, psf+ node.data + "->", paths);
    }
}
