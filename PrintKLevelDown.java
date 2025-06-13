package org.example.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import static org.example.binarytree.IterativeConstructBinaryTree.construct;

public class PrintKLevelDown {
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null,null,87, null, null};
        TreeNode tree = construct(arr);
        printKLevelDown(tree, 2);
        printKLevelDownRecursive(tree, 2);
    }
    public static void printKLevelDown(TreeNode startNode, int level)
    {
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.add(startNode);

        while(queue.size() > 0 && level >= 0)
        {
            int size = queue.size();
            while (size-- > 0)
            {
                TreeNode popped = queue.poll();
                if(level == 0)
                {
                    System.out.print(popped.data + " ");
                }
                if(popped.left != null)
                    queue.add(popped.left);
                if(popped.right != null)
                    queue.add(popped.right);
            }
            System.out.println();
            level--;
        }
    }
    public static void printKLevelDownRecursive(TreeNode node, int k)
    {
        if(node == null || k < 0) return;

        if(k == 0)
        {
            System.out.print(node.data + " ");
        }
        printKLevelDownRecursive(node.left, k-1);
        printKLevelDownRecursive(node.right , k-1);
    }
}
