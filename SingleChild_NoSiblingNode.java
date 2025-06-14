package org.example.binarytree.pathtoleaves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.example.binarytree.pathtoleaves.IterativeConstructBinaryTree.construct;

public class SingleChild_NoSiblingNode {
    public static void main(String[] args) {
        Integer[] arr = {50, 30 , null, 80 ,null, null,70, 40 ,null ,null, null };
        TreeNode tree = construct(arr);
        ArrayList<Integer> res = new ArrayList<>();

        // Is Method m currNode ke children se puch rhe h about their siblings
        singleChild(tree, res);
        System.out.println(res);

        res = new ArrayList<>();
        noSibling(tree,null, res);
        System.out.println(res);
    }
    public static void noSibling(TreeNode node, TreeNode parent, ArrayList<Integer> res)
    {
        if(node == null)return;

        if(parent!= null && parent.left != null && parent.right == null)
        {
            res.add(parent.left.data);
        }
        if(parent != null && parent.right != null && parent.left == null)
        {
            res.add(parent.right.data);
        }
        noSibling(node.left , node, res);
        noSibling(node.right, node, res);
    }
    public static void singleChild(TreeNode node, ArrayList<Integer> res)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (queue.size() > 0)
        {
            TreeNode curr = queue.poll();

            if(curr.left != null && curr.right == null)
            {
                res.add(curr.left.data);
            }
            if(curr.right != null && curr.left == null)
            {
                res.add(curr.right.data);
            }

            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }

    }
}
