package org.example.binarytree.PairClassTreeDP;

import static org.example.binarytree.PairClassTreeDP.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.PairClassTreeDP.IterativeConstructBinaryTree.preOrdertraversal;


class ValidBSTPair{

    int maxSoFar;
    int minSOFar;
    boolean isBST;
}
public class IsValidBST {
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, 40, null, null,
                75, 62, 60, null, null, 65, null, null,
                87, 80, null, null, 90, null, null};

        /*Integer[] arr = {60,25,12,null, null,37,30, null, null, 40, null, null, 75,62,60,51,null,null,61,null,null,77,74,null,null, 78, null,null,87, null,null};
        */
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        System.out.println();

        ValidBSTPair validBST = isValidBST(tree);
        System.out.println(validBST.isBST);
    }
    public static ValidBSTPair isValidBST(TreeNode node)
    {
        if(node == null)
        {
            ValidBSTPair base = new ValidBSTPair();
            base.maxSoFar = Integer.MIN_VALUE;
            base.minSOFar = Integer.MAX_VALUE;
            base.isBST = true;
            return base;
        }

        ValidBSTPair leftRes  = isValidBST(node.left);
        ValidBSTPair rightRes = isValidBST(node.right);

        ValidBSTPair myRes = new ValidBSTPair();
        myRes.minSOFar = Math.min(node.data, Math.min(leftRes.minSOFar, rightRes.minSOFar));
        myRes.maxSoFar = Math.max(node.data, Math.max(leftRes.maxSoFar, rightRes.maxSoFar));

        boolean amIBSTasNode = node.data > leftRes.maxSoFar && node.data < rightRes.minSOFar;
        boolean amIBSTasTree = amIBSTasNode && leftRes.isBST && rightRes.isBST;

        myRes.isBST = amIBSTasTree;
        return myRes;
    }
}
