package org.example.binarytree.PairClassTreeDP;


import static org.example.binarytree.PairClassTreeDP.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.PairClassTreeDP.IterativeConstructBinaryTree.preOrdertraversal;


class BSTPair{

    int maxSoFar;
    int minSoFar;
    boolean isBST;
    TreeNode validBSTRootSoFar;
    int sizeOfValidBSTSoFar;
}
public class LargestValidBST {
    public static void main(String[] args) {
        Integer[] arr = {60,25,12,null, null,37,30, null, null, 40, null, null, 75,62,60,51,null,null,61,null,null,
                77,74,null,null, 78,null,87, null,null};

        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        System.out.println();

        BSTPair bst = largestValidBSTRoot(tree);
        System.out.println(bst.validBSTRootSoFar.data+"@"+bst.sizeOfValidBSTSoFar);
    }
    public static BSTPair largestValidBSTRoot(TreeNode node)
    {
        if(node == null)
        {
            BSTPair base = new BSTPair();
            base.maxSoFar = Integer.MIN_VALUE;
            base.minSoFar = Integer.MAX_VALUE;
            base.isBST = true;
            base.validBSTRootSoFar = null;
            base.sizeOfValidBSTSoFar = 0;
            return base;
        }

        BSTPair leftRes = largestValidBSTRoot(node.left);
        BSTPair rightRes = largestValidBSTRoot(node.right);

        BSTPair myRes = new BSTPair();
        myRes.maxSoFar = Math.max(node.data, Math.max(leftRes.maxSoFar, rightRes.maxSoFar));
        myRes.minSoFar = Math.min(node.data, Math.min(leftRes.minSoFar, rightRes.minSoFar));

        boolean amIBSTasNode = node.data > leftRes.maxSoFar && node.data < rightRes.minSoFar;
        boolean amIBSTasTree = amIBSTasNode && leftRes.isBST && rightRes.isBST;

        myRes.isBST = amIBSTasNode && amIBSTasTree;
        if(amIBSTasTree)
        {
            myRes.validBSTRootSoFar = node;
            myRes.sizeOfValidBSTSoFar = leftRes.sizeOfValidBSTSoFar + rightRes.sizeOfValidBSTSoFar +1;
        }
        else if(leftRes.sizeOfValidBSTSoFar > rightRes.sizeOfValidBSTSoFar){


            myRes.validBSTRootSoFar = leftRes.validBSTRootSoFar;
            myRes.sizeOfValidBSTSoFar = leftRes.sizeOfValidBSTSoFar;
        }
        else{

            myRes.validBSTRootSoFar = rightRes.validBSTRootSoFar;
            myRes.sizeOfValidBSTSoFar = rightRes.sizeOfValidBSTSoFar;
        }

        return myRes;
    }

}
