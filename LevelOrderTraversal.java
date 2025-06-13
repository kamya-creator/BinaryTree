package org.example.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import static org.example.binarytree.IterativeConstructBinaryTree.*;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null,null,87, null, null};
        TreeNode tree = construct(arr);
        System.out.println("Printing level wise preorder");
        levelOrderTraversal(tree);
    }
    public static void levelOrderTraversal(TreeNode node)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0)
        {
            int size = queue.size();
            while(size -- > 0)
            {
                TreeNode currNode = queue.poll() ;
                System.out.print(currNode.data + " ");

                if(currNode.left != null)
                {
                    queue.add(currNode.left);
                }
                if(currNode.right != null)
                {
                    queue.add(currNode.right);
                }
            }
            System.out.println();
        }
    }
}
