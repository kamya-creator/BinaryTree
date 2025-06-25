package org.example.binarytree.KDistanceFarNodes;

import java.util.LinkedList;
import java.util.Queue;

import static org.example.binarytree.KDistanceFarNodes.IterativeConstructBinaryTree.construct;
import static org.example.binarytree.KDistanceFarNodes.IterativeConstructBinaryTree.preOrdertraversal;

class Pair
{
    TreeNode node;
    int index;

    Pair(TreeNode node, int index)
    {
        this.node = node;
        this.index = index;
    }
}
public class MaxWidthOfBT {
    public static void main(String[] args) {
        Integer[] arr = {1,3,5,null, null,3, null, null,2, null,   9, null, null};
        //Integer[] arr = {1,2,4,8,null, null, null, 5, null, 10, null, null, 3, null, 7, null, null};
        TreeNode tree = construct(arr);
        preOrdertraversal(tree);

        int[] max = {0};
        maxWidth(tree, max);
        System.out.println("max Width is " + max[0]);
    }
    public  static void maxWidth(TreeNode node, int[] max)
    {
        if(node == null) return ;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, 0));

        while(queue.size() > 0)
        {
            int size = queue.size();
            int firstIndex = 0;
            int lastIndex = 0;
            for(int i = 0;i<size;i++)
            {
                Pair curr = queue.poll();
                if(i == 0)
                {
                    firstIndex = curr.index;
                }
                if( i == size -1)
                {
                    lastIndex = curr.index;
                }

                if(curr.node.left != null)
                {
                    queue.add(new Pair(curr.node.left , 2 * curr.index +1));
                }


                if(curr.node.right != null)
                {
                    queue.add(new Pair(curr.node.right , 2 * curr.index +2));
                }

            }
            max[0] = Math.max(max[0] , lastIndex - firstIndex +1);
        }

    }
}

