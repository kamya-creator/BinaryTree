package org.example.binarytree.constructionofBinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructBTFromPostOrder_and_InOrder {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int start = 0; int end = inorder.length -1;
        int[] postIndex = {postorder.length - 1};
        TreeNode root = constructTreeFromPostOrderandInOrder(postorder, map, start, end, postIndex);
        levelOrderTraversal(root);


    }
    public static void levelOrderTraversal(TreeNode node)
    {
        if(node == null)
        {
            return;
        }
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.add(node);

        while (queue.size() > 0)
        {
            int size = queue.size();
            while (size-- > 0)
            {
                TreeNode currNode = queue.poll();
                System.out.print(currNode.data+ " ");

                if(currNode.left != null){
                    queue.add(currNode.left);
                }

                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
        }
    }

    public static TreeNode constructTreeFromPostOrderandInOrder(int[] post, HashMap<Integer, Integer> map , int start, int end, int[] postIndex)
    {
        if(postIndex[0] < 0 || start > end)
        {
            return null;
        }
        TreeNode node = new TreeNode(post[postIndex[0]], null, null);
        int pos = map.get(node.data);

        postIndex[0]--;
        node.right = constructTreeFromPostOrderandInOrder(post, map, pos + 1, end, postIndex);
        node.left = constructTreeFromPostOrderandInOrder(post, map, start,pos - 1, postIndex);

        return node;
    }
}
