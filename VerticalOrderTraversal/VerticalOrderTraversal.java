package org.example.binarytree.importantTraversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.preOrdertraversal;

class Pair{
    TreeNode node;
    int horizontalDistance;

    Pair(TreeNode node, int horizontalDistance)
    {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}
public class VerticalOrderTraversal {
    public static void main(String[] args) {
        Integer[] arr = {1,2,4,null,null,5,null,null, 3, 6, null, null, 7,null,null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] min = { Integer.MAX_VALUE};
        int[] max = {Integer.MIN_VALUE};
        verticalOrderTraversal(tree, map, min, max);
        System.out.println("vertical Order Traversal------------");
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = min[0];i<=max[0];i++)
        {
            ArrayList<Integer> curr = map.get(i);
            res.add(curr);
        }
        System.out.println(res);

    }
    public static void verticalOrderTraversal(TreeNode node, HashMap<Integer, ArrayList<Integer>> map, int[] min, int[] max)
    {
        if(node == null) return;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, 0));

        while (queue.size()>0)
        {
            int size = queue.size();
            while (size-- > 0)
            {
                Pair currPair = queue.poll();
                TreeNode currNode = currPair.node;
                int currHorizontalDistance = currPair.horizontalDistance;


                min[0] = Math.min(min[0] , currHorizontalDistance);
                max[0] = Math.max(max[0] , currHorizontalDistance);


                if(map.containsKey(currHorizontalDistance))
                {
                    ArrayList<Integer> list = map.get(currHorizontalDistance);
                    list.add(currNode.data);
                }
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(currNode.data);
                    map.put(currHorizontalDistance, list);
                }

                if(currNode.left != null)
                {
                    queue.add(new Pair(currNode.left, currHorizontalDistance -1));
                }
                if(currNode.right != null)
                {
                    queue.add(new Pair(currNode.right, currHorizontalDistance + 1));
                }
            }
        }
    }
}
