package org.example.binarytree.importantTraversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.preOrdertraversal;

public class RightViewOfBT {
    public static void main(String[] args) {

        Integer[] arr = {1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        ArrayList<Integer> res = new ArrayList<>();
        rightviewOfBT(tree, res);
        System.out.println(res);
    }
    public static void rightviewOfBT(TreeNode node, ArrayList<Integer> res)
    {
        if(node == null) return;

        Queue<TreeNode> queue  = new LinkedList<>();
        queue.add(node);

        while(queue.size() > 0)
        {
            int size = queue.size();
            for(int i = 0;i<size;i++)
            {
                TreeNode currNode = queue.poll();
                if(i == size-1)
                {
                    res.add(currNode.data);
                }

                if(currNode.left != null)
                {
                    queue.add(currNode.left);
                }
                if(currNode.right != null)
                {
                    queue.add(currNode.right);
                }
            }
        }
    }
}
