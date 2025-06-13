package org.example.binarytree;

import java.util.ArrayList;

import static org.example.binarytree.ConstructBinaryTree.constructTree;
import static org.example.binarytree.ConstructBinaryTree.display;

public class FindNodeinBinaryTree {
    static ArrayList<String> res = new ArrayList<>();
    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30, null, null, null, 75, 62, null,70, null,null, 87, null, null};
        Node rootNode = constructTree(arr);
        //display(rootNode);

        boolean result = findNode(rootNode, 70);
        System.out.println(result);
        System.out.println(res);

        System.out.println("K level print---------");
        printKLevelDOwn(rootNode, 2);
    }

    public static void printKLevelDOwn(Node node, int k)
    {
        if(node == null || k < 0)
        {
            return;
        }
        System.out.println(node.data);
        printKLevelDOwn(node.left, k-1);
        printKLevelDOwn(node.right, k-1);

    }


    public static boolean findNode(Node node, int key)
    {
        if(node == null)
        {
            return false;
        }

        if(node.data == key)
        {
            System.out.println("Found One");
            res.add(node.data+"->");
            return true;
        }

        if(node.left != null)
        {
            if(findNode(node.left, key)==true)
            {
                res.add(node.data+"->");
                return true;
            }
        }
        if(node.right != null)
        {
            if(findNode(node.right, key)==true)
            {
                res.add(node.data+"->");
                return true;
            }
        }
        return false;
    }
}
