package org.example.binarytree.KDistanceFarNodes;


import static org.example.binarytree.KDistanceFarNodes.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.KDistanceFarNodes.IterativeConstructBinaryTree.preOrdertraversal;

public class BurningTree {
    public static void main(String[] args) {
        //Integer[] arr = {1,5,null, 4, 9,null, null, 2, null, null, 3, 10, null, null, 6, null, null};
        Integer[] arr = {1,2,4,8,null, null, null, 5, null, 10, null, null, 3, null, 7, null, null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);
        int target = 10;
        int[] max = {0};
        burningTree(tree, target, max );
        System.out.println();
        System.out.println("Time to burn tree : ---- "+max[0]);
    }
    public static int burningTree(TreeNode node, int key, int[] max)
    {
        if(node == null) return -1;

        if(node.data == key) {
            burnTree(node, null, 0, max);
            return 0;
        }

        int foundL = burningTree(node.left, key, max);
        if(foundL >= 0)
        {
            burnTree(node, node.left, foundL + 1, max);
            return foundL + 1;
        }

        int foundR = burningTree(node.right, key, max);
        if(foundR >= 0)
        {
            burnTree(node, node.right, foundR + 1, max);
            return foundR + 1;
        }

        return -1;
    }
    public static void burnTree(TreeNode node, TreeNode blocker, int time, int[] max)
    {
        if(node == null || node == blocker) return;

        max[0] = Math.max(max[0], time);
        burnTree(node.left, blocker, time + 1, max);
        burnTree(node.right, blocker, time + 1, max);
    }
}
