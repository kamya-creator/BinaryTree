package org.example.binarytree.importantTraversals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.importantTraversals.IterativeConstructBinaryTree.preOrdertraversal;

public class BoundaryTraversal {
    public static void main(String[] args) {
       // Integer[] arr = {1,2,4,null, null, 5, 8, null, null, 9, null, null, 3, 6, null, null, 7, null, null};
        Integer[] arr = {1,null, 2, null, 3, null, 4, null,null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        List<Integer> ans = boundaryTraversal(tree);
        System.out.println(ans);

    }
    public static List<Integer> boundaryTraversal(TreeNode node)
    {

        if(node == null)
        {
            return new ArrayList<>();
        }

        ArrayList<Integer> leftBoundary = new ArrayList<>();
        leftBoundary.add(node.data);
        leftBoundaryTraversal(node.left, leftBoundary);

        ArrayList<Integer> leaves = new ArrayList<>();
        leavesBoundaryTraversal(node, leaves);

        ArrayList<Integer> rightBoundary = new ArrayList<>();
        rightBoundaryTraversal(node.right, rightBoundary);


        ArrayList<Integer> res ;

        res = Stream.concat(leftBoundary.stream(),
                Stream.concat(leaves.stream(), rightBoundary.stream()))
                .collect(Collectors.toCollection(ArrayList::new));

        return res;
    }


    private static void leftBoundaryTraversal(TreeNode node, ArrayList<Integer> leftBoundary) {

        if(node == null) return;

        if(node.left == null && node.right == null)
        {
            return;
        }

        leftBoundary.add(node.data);
        if(node.left != null)
            leftBoundaryTraversal(node.left, leftBoundary);
        else{
            leftBoundaryTraversal(node.right, leftBoundary);
        }
    }

    private static void leavesBoundaryTraversal(TreeNode node, ArrayList<Integer> leaves)
    {
        if(node == null) return;

        if(node.left == null && node.right == null)
        {
            leaves.add(node.data);
            return;
        }

        leavesBoundaryTraversal(node.left, leaves);
        leavesBoundaryTraversal(node.right, leaves);
    }

    private static void rightBoundaryTraversal(TreeNode node, ArrayList<Integer> rightBoundary) {

        if(node == null) return;

        if(node.left == null && node.right == null)
        {
            return;
        }
        if(node.right != null)
        rightBoundaryTraversal(node.right, rightBoundary);
        else
        rightBoundaryTraversal(node.left, rightBoundary);

        rightBoundary.add(node.data);
    }

}
