package org.example.binarytree;

import java.util.ArrayList;
import java.util.Stack;

class  PairAlphaTree{
    AlphaNumberTree node;
    int state;

    PairAlphaTree(AlphaNumberTree node, int state)
    {
        this.node = node;
        this.state = state;
    }

}
class AlphaNumberTree{
    String data;
    AlphaNumberTree left;
    AlphaNumberTree right;

    AlphaNumberTree(String data, AlphaNumberTree left, AlphaNumberTree right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
public class PrintKLevelFar {
    public static void main(String[] args) {
        String[] arr = {"10","a","b","d","h",null, null, "i",null, null,null,"c", "e","j","p","v", null, null, "w", null, null, "q",
                null, null, "9", "r","t","y",null, null,null,"4","z","1", null, null, "2",null, null,null,"s", "3",null, null,
                "4", "5", null, "8", null, null, "6", null, null, null, "11", "12", null, null, "13", null, null};

//        String[] arr = {"3", "5", "6", null, null, "2","7", null, null, "4", null, null, "1", null, null,
//                "0", null, null, "8", null, null};

        AlphaNumberTree root = constructBinaryTree(arr);
        displayAlphaTree(root);
        System.out.println();
        ArrayList<AlphaNumberTree> pathFromNodetoRoot = new ArrayList<>();
        nodeToRootPath(root, "9",pathFromNodetoRoot );
        System.out.println();
        System.out.println(pathFromNodetoRoot);

        int k = 3;
        //printKDistanceDown(root, 3);
        for (int i = 0; i < pathFromNodetoRoot.size() ; i++) {
            AlphaNumberTree currNode = pathFromNodetoRoot.get(i);
            printKDistanceDown(currNode, k);
            k--;

        }
    }
    public static void printKDistanceDown(AlphaNumberTree node, int level)
    {
        if(node == null || level < 0) return;

        if(level == 0) System.out.print(node.data + " ");

        printKDistanceDown(node.left, level - 1);
        printKDistanceDown(node.right, level -1);
    }

    public static boolean nodeToRootPath(AlphaNumberTree node, String key, ArrayList<AlphaNumberTree> pathFromNodetoRoot)
    {
        if(node == null) return  false;
       // System.out.println("Krishna");

        if(node.data.equals(key))
        {
            System.out.print(node.data + " ");
            pathFromNodetoRoot.add(node);
            return true;
        }

        boolean left = nodeToRootPath(node.left, key, pathFromNodetoRoot);
        if(left)
        {
            System.out.print(node.data + " ");
            pathFromNodetoRoot.add(node);
            return true;
        }

        boolean right = nodeToRootPath(node.right , key, pathFromNodetoRoot);
        if(right)
        {
            System.out.print(node.data + " ");
            pathFromNodetoRoot.add(node);
            return true;
        }
        return  false;
    }

    public static void displayAlphaTree(AlphaNumberTree node)
    {
        if(node == null)return;

        System.out.print(node.data + " ");
        displayAlphaTree(node.left);
        displayAlphaTree(node.right);
    }
    public static AlphaNumberTree constructBinaryTree(String[] arr)
    {

        AlphaNumberTree root = new AlphaNumberTree(arr[0], null, null);
        PairAlphaTree rootPair = new PairAlphaTree(root, 1);
        Stack<PairAlphaTree> stack = new Stack<>();

        stack.push(rootPair);
        int index = 0;
        while(stack.size() > 0 && index < arr.length-1)
        {
            AlphaNumberTree node = stack.peek().node;
            int state = stack.peek().state;

            if(state == 1)
            {
                stack.peek().state++;
                index++;
                if(arr[index] != null)
                {
                    AlphaNumberTree left = new AlphaNumberTree(arr[index], null, null);
                    node.left = left;
                    PairAlphaTree leftPair = new PairAlphaTree(left, 1);
                    stack.push(leftPair);
                }
            } else if (state == 2) {

                stack.peek().state++;
                index++;
                if(arr[index] != null)
                {
                    AlphaNumberTree right = new AlphaNumberTree(arr[index], null, null);
                    node.right = right;
                    PairAlphaTree rightPair = new PairAlphaTree(right, 1);
                    stack.push(rightPair);
                }
            } else if (state == 3) {
                stack.pop();
            }
        }
        return root;
    }
}
