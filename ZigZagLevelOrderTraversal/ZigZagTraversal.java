package org.example.binarytree.importantTraversals;


import java.util.*;

import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.preOrdertraversal;

public class ZigZagTraversal {
    public static void main(String[] args) {
        Integer[] arr = {3,9,null,null, 20,15, null,null,7,null,null};

        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        List<List<Integer>> res = new ArrayList<>();

        zigzaglevelOrderTraversal(tree, res);

        System.out.println(res);

    }

    private static void zigzaglevelOrderTraversal(TreeNode node, List<List<Integer>> res) {

        if(node == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        boolean flag = true;
        while(queue.size() > 0)
        {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(size-- > 0)
            {
                TreeNode currNode = queue.poll();
                temp.add(currNode.data);
                if(currNode.left != null)
                {
                    queue.add(currNode.left);
                }
                if(currNode.right != null)
                {
                    queue.add(currNode.right);
                }
            }
            if(flag)
            {
                res.add(temp);
            }
            else{
                Collections.reverse(temp);
                res.add(temp);
            }
            flag = !flag;
        }
    }

}
