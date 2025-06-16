package org.example.binarytree.PairClassTreeDP;


import static org.example.binarytree.PairClassTreeDP.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.PairClassTreeDP.IterativeConstructBinaryTree.preOrdertraversal;


class DiaHeightPair{
    int maxDiameterSoFar;
    int height;
}
public class DiameterPairClass {
    public static void main(String[] args) {
        Integer[] arr = {1,2,4,null, null,5,null,null,3,null,null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);
        System.out.println();
        DiaHeightPair result = solve(tree);
        System.out.print("Diameter is : ");
        System.out.println(result.maxDiameterSoFar);
    }
    public static DiaHeightPair solve(TreeNode node)
    {
        if(node == null)
        {
            DiaHeightPair base = new DiaHeightPair();
            base.maxDiameterSoFar = 0;
            base.height = -1;
            return base;
        }

        DiaHeightPair leftRes = solve(node.left);
        DiaHeightPair rightRes = solve(node.right);

        DiaHeightPair myDiaPair = new DiaHeightPair();

        myDiaPair.height = Math.max(leftRes.height, rightRes.height) + 1;
        int myDiameter = leftRes.height + rightRes.height + 2 ;
        myDiaPair.maxDiameterSoFar = Math.max(myDiameter, Math.max(leftRes.maxDiameterSoFar, rightRes.maxDiameterSoFar));

        return myDiaPair;
    }
}
