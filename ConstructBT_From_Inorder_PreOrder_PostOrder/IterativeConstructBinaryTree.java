package org.example.binarytree.constructionofBinaryTree;



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
    public static void preOrdertraversal(TreeNode node)
    {
        if(node == null) return;
        System.out.print(node.data + " ");
        preOrdertraversal(node.left);
        preOrdertraversal(node.right);
    }
}
