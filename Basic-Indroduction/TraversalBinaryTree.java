package org.example.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.example.binarytree.ConstructBinaryTree.constructTree;



public class TraversalBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30, null, null, null, 75, 62, null,70, null,null, 87, null, null};
        Node rootNode = constructTree(arr);

        System.out.println("preOrder");
        preOrdertraversal(rootNode);
        System.out.println("postOrder");
        postOrdertraversal(rootNode);
        System.out.println("InOrder");
        inOrdertraversal(rootNode);

        System.out.println("levelOrderTraversal");
        levelOrderTraversal(rootNode);

        iterativePreInPostOrderTraversal(rootNode);
    }
    public static void iterativePreInPostOrderTraversal(Node node)
    {
        Stack<Pair> st = new Stack<>();
        Pair rootPair = new Pair(node,1);
        st.push(rootPair);
        StringBuilder inorder = new StringBuilder();
        StringBuilder postOder = new StringBuilder();
        StringBuilder preOrder = new StringBuilder();
        while (st.size() > 0)
        {
            int stateOfTop = st.peek().state;
            if(stateOfTop == 1) // state 1 mtlb pelhi baar dekh rhi ho add in preorder and left ki tarf wala node add krdo stack m
            {
                st.peek().state++;
                preOrder.append(st.peek().node.data +" ");
                if(st.peek().node.left != null)
                {
                    st.push(new Pair(st.peek().node.left, 1));
                }


            } else if (stateOfTop ==2) { // state 2 mtlb dusri baar dekha to InOrder m add krdo and right child ko add krdo stack m

                st.peek().state++;
                inorder.append(st.peek().node.data +" ");


                if(st.peek().node.right != null)
                {
                    st.push(new Pair(st.peek().node.right, 1));
                }

            } else if (stateOfTop == 3) {
                postOder.append(st.peek().node.data+" "); // state 3 mtlb third time dekh rhe ho isse isliye usse post order m add krdo n pop it out of stack qki iss element ka sab kuch ho gya
                st.pop();
            }
        }

        System.out.println("InOrder " + inorder);
        System.out.println("Post Order " + postOder);
        System.out.println("Pre Order " + preOrder);
    }


    public static void levelOrderTraversal(Node node)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (queue.size() > 0)
        {
            int size = queue.size();
            while(size-->0) {

                Node curr = queue.poll();
                System.out.print(curr.data + " ");

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            System.out.println();

        }
    }

    public static void preOrdertraversal(Node node)
    {
        if(node == null) return;
        System.out.println(node.data);
        preOrdertraversal(node.left);
        preOrdertraversal(node.right);
    }

    public static void postOrdertraversal(Node node)
    {
        if(node == null) return;
        postOrdertraversal(node.left);
        postOrdertraversal(node.right);
        System.out.println(node.data);
    }
    public static void inOrdertraversal(Node node)
    {
        if(node == null) return;
        inOrdertraversal(node.left);
        System.out.println(node.data);
        inOrdertraversal(node.right);
    }
}
