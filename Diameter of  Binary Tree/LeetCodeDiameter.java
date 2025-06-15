package org.example.binarytree.pathtoleaves;

/*
This one is optimized way of doing diameter , beacuse ismain recursion ke andar se recursion nhi lag raha h
 */
class DiaHeight{
    TreeNode node;
    int dia;
    int height;

    DiaHeight(TreeNode node, int dia, int height)
    {
        this.node = node;
        this.dia = dia;
        this.height = height;
    }

}
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        DiaHeight res = solve(root);
        return res.dia;
    }
    public DiaHeight solve(TreeNode node)
    {
        if(node == null)
        {
            DiaHeight base = new DiaHeight(null, 0, -1);
            return base;
        }

        DiaHeight leftDiaHeight = solve(node.left);
        DiaHeight rightDiaHeight = solve(node.right);

        int DiaPassThroughCurrentNode = leftDiaHeight.height + rightDiaHeight.height + 2;
        int myDia = Math.max(DiaPassThroughCurrentNode,Math.max(leftDiaHeight.dia , rightDiaHeight.dia ));
        int myHeight = Math.max(leftDiaHeight.height, rightDiaHeight.height) + 1;

        DiaHeight myDiaHeight = new DiaHeight(node, myDia, myHeight);
        return myDiaHeight;

    }
}
public class LeetCodeDiameter {

}
