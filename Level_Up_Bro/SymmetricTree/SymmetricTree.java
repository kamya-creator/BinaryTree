package org.example.binarytree.SingleChildNode;


import static org.example.binarytree.SingleChildNode.ConstructBTFromLevelOrder.constructTreeFromLevelOrderTraversal;
import static org.example.binarytree.SingleChildNode.ConstructBTFromLevelOrder.levelOrderTraversal;

public class SymmetricTree {
    public static void main(String[] args) {
        //1,2,2,null,3,null,3]
        Integer[] arr = {1,2,2,null,3,null,3};
        TreeNode tree = constructTreeFromLevelOrderTraversal(0, arr);
        levelOrderTraversal(tree);
        boolean same = isSymmetric(tree.left, tree.right);
        System.out.println(same);
    }
    static boolean  isSymmetric(TreeNode p, TreeNode q)
    {
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        if(p.data != q.data) return false;

        boolean r1 = isSymmetric(p.left, q.right);
        boolean r2 = isSymmetric(p.right, q.left);

        return r1 && r2;
    }
}
