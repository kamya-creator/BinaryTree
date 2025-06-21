package org.example.binarytree.importantTraversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.preOrdertraversal;

public class BottomViewofBT {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] min = {Integer.MAX_VALUE};
        int[] max = {Integer.MIN_VALUE};
        verticalOrderBottomView(tree, map, min, max);

        ArrayList<Integer> res = new ArrayList<>();
        for(int i = min[0];i<=max[0];i++)
        {
            res.add(map.get(i));
        }
        System.out.println(res);
    }
    public static void verticalOrderBottomView(TreeNode node, HashMap<Integer, Integer> map, int[] min, int[] max)
    {
        if(node == null)return;

        Queue<Pair> queue =  new LinkedList<>();
        queue.add(new Pair(node, 0));

        while (queue.size() > 0)
        {
            int size = queue.size();
            for (int i = 0; i < size ; i++) {

                Pair currPair = queue.poll();
                TreeNode currNode = currPair.node;
                int horizonatlDistance_ = currPair.horizontalDistance;

                min[0] = Math.min(min[0], horizonatlDistance_);
                max[0] = Math.max(max[0], horizonatlDistance_);

                map.put(horizonatlDistance_ , currNode.data);

                if(currNode.left != null)
                    queue.add(new Pair(currNode.left , horizonatlDistance_ -1));
                if(currNode.right != null)
                    queue.add(new Pair(currNode.right , horizonatlDistance_ + 1));
            }
        }
    }
}
