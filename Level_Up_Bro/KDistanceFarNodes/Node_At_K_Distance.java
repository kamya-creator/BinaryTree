package org.example.binarytree.KDistanceFarNodes;


import java.util.ArrayList;

import static org.example.binarytree.KDistanceFarNodes.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.KDistanceFarNodes.IterativeConstructBinaryTree.preOrdertraversal;

public class Node_At_K_Distance {
    public static void main(String[] args) {

        //Integer[] arr = {1,2,4,null,null,5,null,null,3, null,null};
        Integer[] arr = {1,2,4,null,null,5, null, null,3, 6 , null,null,7, null,null};
        TreeNode tree = construct(arr);

        preOrdertraversal(tree);
        int target = 3, k =1;
        ArrayList<Integer> res = new ArrayList<>();
        nodeAtDistanceK(tree, target, k,res);
        System.out.println(res);
    }

    public static int nodeAtDistanceK(TreeNode node, int target, int k, ArrayList<Integer> res)
    {
        if(node == null) return -1;
        if(node.data == target)
        {
            klevelDown(node,  k, null,res);
            return 0;
        }

        int foundL = nodeAtDistanceK(node.left, target, k, res);
        if(foundL >= 0)
        {
            klevelDown(node, k - foundL - 1, node.left, res);
            return foundL + 1;
        }

        int foundR = nodeAtDistanceK(node.right, target, k, res);
        if(foundR >= 0)
        {
            klevelDown(node, k - foundR - 1, node.right, res);
            return foundR +1;
        }
        return -1;
    }

    public static void klevelDown(TreeNode node, int level, TreeNode blocker, ArrayList<Integer> res)
    {
        if(node == null || node == blocker)
        {
            return;
        }

        if(level == 0) res.add(node.data);
        klevelDown(node.left, level -1, blocker, res);
        klevelDown(node.right, level -1, blocker, res);

    }
}
