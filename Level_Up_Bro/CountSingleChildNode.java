package org.example.binarytree.SingleChildNode;


import java.util.ArrayList;

import static org.example.binarytree.SingleChildNode.ConstructBTFromLevelOrder.constructTreeFromLevelOrderTraversal;
import static org.example.binarytree.SingleChildNode.ConstructBTFromLevelOrder.levelOrderTraversal;

public class CountSingleChildNode {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Integer[] arr = {
                1,3,2,5,null,null,9,6,null,7
        };

//        Integer[] arr = {
//                1,3,2,5,3,null,9
//        };


        TreeNode tree = constructTreeFromLevelOrderTraversal( 0, arr);
        levelOrderTraversal(tree);

        int singleChildNode = countSingleChildNode(tree, null);
        System.out.println(singleChildNode);
        System.out.println(list);

    }
    public static int countSingleChildNode(TreeNode node, TreeNode parent)
    {
        if(node ==null || (node.left == null && node.right == null)) return 0;

        int left = countSingleChildNode(node.left , node);
        int right = countSingleChildNode(node.right, node);
        System.out.println("Node---" + node.data);
        if(parent != null )
        {
            if((node.left == null && parent.right == node )  || (node.right == null && parent.left == node))
            {
                list.add(node.data);
                return left + right +1;
            }
        }
        return left+right;
    }
}
