package org.example.binarytree.SingleChildNode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.example.binarytree.SingleChildNode.ConstructBTFromLevelOrder.constructTreeFromLevelOrderTraversal;
import static org.example.binarytree.SingleChildNode.ConstructBTFromLevelOrder.levelOrderTraversal;

public class SameTreeOrNot {
        public static void main(String[] args) {
            //p = [1,2,1], q = [1,1,2]
            Integer[] arr1 = {1,2,1};
            Integer[] arr2 = {1,2,3};

            TreeNode p = constructTreeFromLevelOrderTraversal( 0, arr1);
            TreeNode q = constructTreeFromLevelOrderTraversal( 0, arr2);
            levelOrderTraversal(p);
            System.out.println("-------------");
            levelOrderTraversal(q);

            boolean res = isSameTreeBFSMeThod(p,q);
            System.out.println(res);


            boolean res1 = isSameTreeDFSMeThod(p,q);
            System.out.println(res1);
    }
    public static boolean isSameTreeDFSMeThod(TreeNode p, TreeNode q)
    {

        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;


        if(p.data != q.data) return false;

        boolean left = isSameTreeBFSMeThod(p.left, q.left);
        boolean right = isSameTreeDFSMeThod(p.right , q.right);
        return left && right;

    }
    public static boolean isSameTreeBFSMeThod(TreeNode p, TreeNode q)
    {
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p); q2.add(q);

        while(q1.size()>0 && q2.size() > 0)
        {
            TreeNode curr1 = q1.poll();
            TreeNode curr2 = q2.poll();

            if(curr1.data != curr2.data) return false;

            if(curr1.left != null && curr2.left != null)
            {
                q1.add(curr1.left);
                q2.add(curr2.left);
            }
            else if((curr1.left != null && curr2.left == null ) || (curr2.left != null && curr1.left == null))
            {
                return false;
            }


            if(curr1.right != null && curr2.right != null)
            {
                q1.add(curr1.right);
                q2.add(curr2.right);
            }
            else if((curr1.right != null && curr2.right == null ) || (curr2.right != null && curr1.right == null))
            {
                return false;
            }
        }
        return true;
    }
}
