package org.example.binarytree.PairClassTreeDP;

import static org.example.binarytree.PairClassTreeDP.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.PairClassTreeDP.IterativeConstructBinaryTree.preOrdertraversal;

class Pair{
    int ssf;
}
public class TiltOfBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {4,2,3,null, null,5,null,null,9,null,7,null, null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);
        System.out.println();
        int[] tsf = new int[1];
        solve(tree, tsf);
        System.out.println(tsf[0]);

    }
    public static Pair solve(TreeNode node, int[] tsf)
    {
        if(node==null)
        {
            Pair base = new Pair();
            base.ssf = 0;
            return base;
        }

        Pair leftRes = solve(node.left, tsf);
        Pair rightRes = solve(node.right, tsf);

        Pair myRes = new Pair();
        myRes.ssf = leftRes.ssf + rightRes.ssf + node.data;

        tsf[0] = tsf[0] + Math.abs(leftRes.ssf - rightRes.ssf) ;
        return myRes;
    }
}
