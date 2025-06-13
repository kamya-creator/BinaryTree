package org.example.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data, TreeNode left, TreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class PairTreeNode{

    TreeNode treeNode;
    int state;

    PairTreeNode(TreeNode treeNode, int state)
    {
        this.treeNode = treeNode;
        this.state = state;
    }
}

public class IterativeConstructBinaryTree {
    public static TreeNode construct(Integer[] arr)
    {
        TreeNode root = new TreeNode(arr[0], null, null);
        PairTreeNode rootPair = new PairTreeNode(root, 1);
        Stack<PairTreeNode> st = new Stack<>();
        int index = 0;
        st.add(rootPair);

        while(st.size() > 0 && index < arr.length - 1)
        {
            TreeNode node = st.peek().treeNode;
            int state = st.peek().state;

            if(state == 1)
            {
                st.peek().state++;
                index++;
                if(arr[index] != null)
                {
                    TreeNode left = new TreeNode(arr[index], null, null);
                    node.left = left;
                    PairTreeNode leftPair = new PairTreeNode(left, 1);
                    st.push(leftPair);
                }

            }
            else if(state == 2)
            {
                st.peek().state++;
                index++;
                if(arr[index] != null)
                {
                    TreeNode right = new TreeNode(arr[index], null, null);
                    node.right = right;
                    PairTreeNode rightPair = new PairTreeNode(right, 1);
                    st.push(rightPair);
                }

            }
            else if(state == 3)
            {
                st.pop();
            }
        }
        return root;
    }
    public static void displayTree(TreeNode tree)
    {
        if(tree == null)
        {
            return;
        }
        System.out.print(tree.data + " ");
        displayTree(tree.left);
        displayTree(tree.right);
    }
    public static void displayPreOderLevelWise(TreeNode node)
    {
        if(node == null)
        {
            return;
        }
        System.out.print((node.left == null) ? "." : node.left.data);
        System.out.print("->" + node.data + "<-");
        System.out.print(node.right == null ? "." : node.right.data);

        System.out.println();
        displayPreOderLevelWise(node.left);
        displayPreOderLevelWise(node.right);
    }
    public static int sum(TreeNode node)
    {
        if(node == null) return 0;

        int left = sum(node.left);
        int right = sum(node.right);

        return left + right + node.data;
    }
    public static int max(TreeNode node)
    {
        if(node == null) return 0;

        int left = max(node.left);
        int right = max(node.right);

        return Math.max( Math.max(left , right ),node.data);
    }
    public static void levelOrderTraversal(TreeNode node)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0)
        {
            int size = queue.size();
            while(size -- > 0)
            {
                TreeNode currNode = queue.poll() ;
                System.out.print(currNode.data + " ");

                if(currNode.left != null)
                {
                    queue.add(currNode.left);
                }
                if(currNode.right != null)
                {
                    queue.add(currNode.right);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null,null,87, null, null};
        TreeNode tree = construct(arr);
        displayTree(tree);
        System.out.println("Printing level wise preorder");
        displayPreOderLevelWise(tree);
        int sum = sum(tree);
        System.out.println(sum);
        System.out.println(max(tree));
        levelOrderTraversal(tree);
    }

}
