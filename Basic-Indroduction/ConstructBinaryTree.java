package org.example.binarytree;

import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class Pair{
    Node node;
    int state;

    Pair(Node node, int state)
    {
        this.node = node;
        this.state = state;
    }
}
public class ConstructBinaryTree {

    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30, null, null, null, 75, 62, null,70, null,null, 87, null, null};
        Node rootNode = constructTree(arr);
        display(rootNode);
        int sum = sum(rootNode);
        System.out.println(sum);

        int size = sizeOfBT(rootNode);
        System.out.println(size);

        int max = maxOfBT(rootNode);
        System.out.println(max);

        int min = minOfBT(rootNode);
        System.out.println(min);

        int height = heightInTermsOfEdges(rootNode);
        System.out.println("Height of Tree is "+height);

        traversal(rootNode);
    }
    public static Node constructTree(Integer[] arr)
    {
        int index = 0;

        Node rootNode = new Node(arr[0], null, null);
        Pair rootPair = new Pair(rootNode, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rootPair);
        while(st.size() > 0 && index < arr.length -1)
        {
            int state = st.peek().state;
            if(state == 1)
            {
                // left m lagega node if its not null
                index++;
                Integer val = arr[index];
                if(val != null)
                {
                    Node leftNode = new Node(val, null, null);
                    st.peek().node.left = leftNode;
                    st.peek().state++;
                    Pair newPair = new Pair(leftNode, 1);
                    st.push(newPair);
                }
                else{
                    st.peek().state++;
                }
            }
            else if(state == 2)
            {
                index++;
                Integer val = arr[index];
                if(val != null)
                {
                    Node rightNode = new Node(val, null, null);
                    st.peek().node.right = rightNode;
                    System.out.println("Adding in right");
                    st.peek().state++;

                    Pair newPair = new Pair(rightNode, 1);
                    st.push(newPair);

                }
                else{
                    st.peek().state++;
                }
            }
            else if(state == 3)
            {
                st.pop();
            }
        }
        return rootNode;
    }
    public static void traversal(Node node)
    {
        if(node == null) return;
        System.out.println(node.data + " pre order");
        traversal(node.left);
        System.out.println(node.data + " in order");
        traversal(node.right);
        System.out.println(node.data + " post order");
    }
    public static int heightInTermsOfEdges(Node node)
    {
        if(node == null)
        {
            return  -1;
        }
        int leftHeight = heightInTermsOfEdges(node.left);
        int rightHeight = heightInTermsOfEdges(node.right);
        return Math.max(leftHeight, rightHeight)  + 1;
    }
    public static int minOfBT(Node node)
    {
        if(node == null)
        {
            return Integer.MAX_VALUE;
        }

        int leftMin = minOfBT(node.left);
        int rightMin = minOfBT(node.right);
        int min = Math.min(node.data, Math.min(leftMin, rightMin));
        return min;
    }
    public static int maxOfBT(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        int leftMax = maxOfBT(node.left);
        int rightMax = maxOfBT(node.right);

        int nodeVal = node.data;
        int max = Math.max(nodeVal, Math.max(leftMax, rightMax));
        return max;
    }
    public static int sizeOfBT(Node node)
    {
        if(node == null)
        {
            return 0;
        }

        int left = sizeOfBT(node.left);
        int right = sizeOfBT(node.right);
        return left + right +1;

    }
    public static int sum(Node node)
    {

        if(node == null)
        {
            return 0;
        }

       int left = sum(node.left);
        int right = sum(node.right);
        int total =  node.data + left + right;
        System.out.println(total+"-----------" + "node data" + node.data);
        return total;


    }
    public static void display(Node node)
    {
        if(node == null)
        {
            return;
        }

        String str = "";
        if(node.left != null)
        {
            str = str + node.left.data;
        }
        else
        {
            str = str + ".";
        }
        str = str + "<-" + node.data + "->";

        if(node.right != null)
        {
            str = str + node.right.data;
        }
        else {
            str = str + ".";
        }
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
}
