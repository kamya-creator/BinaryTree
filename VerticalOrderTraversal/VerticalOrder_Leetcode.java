package org.example.binarytree.importantTraversals;

import java.util.*;

import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.preOrdertraversal;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PairV
{
    TreeNode node;
    int level;

    PairV(TreeNode node, int level)
    {
        this.node = node;
        this.level = level;
    }
}
class Row
{
    int data;
    int row;

    Row(int data, int row)
    {
        this.data = data;
        this.row = row;
    }
    @Override
    public String toString()
    {
        return "Pair " + this.data + " :"  + " row- " + this.row;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int[] min = {Integer.MAX_VALUE};
        int[] max = {Integer.MIN_VALUE};
        HashMap<Integer, List<Row>> map = new HashMap<>();
        levelOrderTraversal(root, map, min, max);

        //  System.out.println(map);

        for(int i = min[0] ;i <= max[0];i++)
        {
            List<Row> temp = map.get(i);
            temp.sort((a,b) -> {
                if(a.row == b.row) return Integer.compare(a.data, b.data);
                return Integer.compare(a.row, b.row);
            });
            List<Integer> ans = new ArrayList<>();
            for(int j = 0;j<temp.size();j++)
            {
                Row currRow = temp.get(j);
                ans.add(currRow.data);
            }
            res.add(new ArrayList<>(ans));
        }
        return res;

    }
    public void levelOrderTraversal(TreeNode node, HashMap<Integer, List<Row>> map, int[] min, int[] max)
    {
        if(node == null)
        {
            return;
        }
        Queue<PairV> queue = new LinkedList<>();
        PairV rootPair = new PairV(node, 0);
        queue.add(rootPair);
        int row = 0;
        while(queue.size() > 0)
        {
            int size = queue.size();

            for(int i = 0;i<size;i++)
            {
                PairV curr = queue.poll();
                int level = curr.level;
                TreeNode currNode = curr.node;
                if(map.containsKey(level))
                {
                    List<Row> currList = map.get(level);
                    currList.add(new Row(currNode.data,row));
                }
                else{
                    List<Row> temp = new ArrayList<>();
                    temp.add(new Row(currNode.data, row));
                    map.put(level ,temp);
                }
                min[0] = Math.min(min[0] , level);
                max[0] = Math.max(max[0], level);
                if(currNode.left != null)
                {
                    queue.add(new PairV(currNode.left, level -1));
                }
                if(currNode.right != null)
                {
                    queue.add(new PairV(currNode.right, level  + 1));
                }
            }
            row++;
        }
    }
}
public class VerticalOrder_Leetcode {
    public static void main(String[] args) {

        //Integer[] arr = {3,9, null, null, 20,15, null, null, 7, null, null};
        Integer[] arr = {1,2,4, null, null, 5,null, null,3,6, null, null, 7, null, null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        Solution obj = new Solution();
        List<List<Integer>> ans = obj.verticalTraversal(tree);
        System.out.println(ans);

    }
}
