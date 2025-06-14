package org.example.binarytree.pathtoleaves;

import static org.example.binarytree.pathtoleaves.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.pathtoleaves.PathSumI.preOrdertraversal;

public class RemoveLeaves {
    static TreeNode tree;
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12 , null, null, 37, 30, null,null, null,75,62,null, 70,null, null, 87, null, null};
        tree = construct(arr);
        preOrdertraversal(tree);
        removeLeave3(tree, null, false);
        System.out.println("Removed");
        preOrdertraversal(tree);
    }
    public static void removeLeave3(TreeNode node, TreeNode parent, boolean isLeftChild)
    {
        if(node == null)
        {
            return;
        }
        if(node.left == null && node.right == null)
        {
            if(parent != null)
            {
                if(isLeftChild)
                {
                    parent.left = null;
                }
                else{
                    parent.right = null;
                }
            }
        }

        removeLeave3(node.left ,node, true);
        removeLeave3(node.right, node, false);
    }
    public static TreeNode removeLeaves2(TreeNode node)
    {
        if(node == null)
        {
            return null;
        }

        if(node.left == null && node.right == null)
        {
            return null;
        }

        node.left  = removeLeaves2(node.left);
        node.right = removeLeaves2(node.right);

        return node;
    }
    public static void removeLeaves(TreeNode node)
    {
        if(node == null) return;

        if(node.left != null && node.left.left == null && node.left.right == null)
        {
            node.left = null;
        }
        if(node.right != null && node.right.left == null && node.right.right == null)
        {
            node.right = null;
        }
        removeLeaves(node.left);
        removeLeaves(node.right);
    }
}
