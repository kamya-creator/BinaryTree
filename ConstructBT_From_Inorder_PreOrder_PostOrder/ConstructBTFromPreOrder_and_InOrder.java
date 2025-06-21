package org.example.binarytree.constructionofBinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructBTFromPreOrder_and_InOrder {
    public static void main(String[] args) {
        Integer[]  preorder = {3,9,20,15,7};
        Integer[] inorder = {9,3,15,20,7};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int startIndex = 0; int endIndex = inorder.length - 1;
        int[] preIndex = {0};
        TreeNode treeNode = constructBTfromPreOrderInorder(preorder, map, startIndex, endIndex, preIndex);
        levelOrderTraversal(treeNode);
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


    public static TreeNode constructBTfromPreOrderInorder(Integer[] pre, HashMap<Integer,Integer> map, int start, int end, int[] preIndex)
    {
        if(preIndex[0] >= pre.length || start > end)
        {
            return null;
        }
        TreeNode node = new TreeNode(pre[preIndex[0]], null, null);
        int pos = map.get(node.data);

        preIndex[0]++;
        node.left = constructBTfromPreOrderInorder(pre, map, start, pos - 1, preIndex);
        node.right = constructBTfromPreOrderInorder(pre, map, pos + 1, end, preIndex);

        return node;
    }
}
