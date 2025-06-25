package org.example.binarytree.KDistanceFarNodes;

import java.util.ArrayList;
import java.util.HashMap;

import static org.example.binarytree.KDistanceFarNodes.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.KDistanceFarNodes.IterativeConstructBinaryTree.preOrdertraversal;

public class BurnTree2 {
    public static void main(String[] args) {
        Integer[] arr = {1,5,null, 4, 9,null, null, 2, null, null, 3, 10, null, null, 6, null, null};
        //Integer[] arr = {1,2,4,8,null, null, null, 5, null, 10, null, null, 3, null, 7, null, null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);
        int target = 3;
        int[] max = {0};

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        burningTree(tree, target, max ,map );
        System.out.println();
        System.out.println("Time to burn tree : ---- "+max[0]);
        System.out.println(map);
    }
    public static int burningTree(TreeNode node, int key, int[] max, HashMap<Integer, ArrayList<Integer>> map )
    {
        if(node == null) return -1;

        if(node.data == key) {
            burnTree(node, null, 0, max, map);
            return 0;
        }

        int foundL = burningTree(node.left, key, max, map);
        if(foundL >= 0)
        {
            burnTree(node, node.left, foundL + 1, max, map);
            return foundL + 1;
        }

        int foundR = burningTree(node.right, key, max, map);
        if(foundR >= 0)
        {
            burnTree(node, node.right, foundR + 1, max, map);
            return foundR + 1;
        }

        return -1;
    }
    public static void burnTree(TreeNode node, TreeNode blocker, int time, int[] max , HashMap<Integer, ArrayList<Integer>> map )
    {
        if(node == null || node == blocker) return;

        if(map.containsKey(time))
        {
            ArrayList<Integer> list = map.get(time);
            list.add(node.data);
        }
        else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            map.put(time, list);
        }
        max[0] = Math.max(max[0], time);
        burnTree(node.left, blocker, time + 1, max, map);
        burnTree(node.right, blocker, time + 1, max, map);
    }
}
