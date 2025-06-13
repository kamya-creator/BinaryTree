package org.example.binarytree;

import static org.example.binarytree.IterativeConstructBinaryTree.construct;

public class NodeToRootPath {
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null,null,87, null, null};
        TreeNode tree = construct(arr);
        nodeToRootPath(tree, 70);
    }
    public static boolean nodeToRootPath(TreeNode node, int data)
    {
        if(node == null) return false;

        if(node.data == data)
        {
            System.out.print(node.data + " ");
            return true;
        }

        boolean left = nodeToRootPath(node.left, data);
        if(left)
        {
            System.out.print(" left " );

            System.out.print(node.data + " ");
            return true;
        }

        boolean right = nodeToRootPath(node.right, data);
        if(right)
        {
            System.out.print("right " );
            System.out.print(node.data + " ");
            return true;
        }

        return false;
    }
}
