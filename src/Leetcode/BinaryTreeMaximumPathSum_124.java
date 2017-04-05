package Leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * Created by cpy on 2017/3/16.
 */
public class BinaryTreeMaximumPathSum_124 {

    // what is wrong with my DFS-thought
    int max;

    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if(root==null) return 0;
        int left=Math.max( 0, dfs(root.left));      //
        int right=Math.max( 0, dfs(root.right));
        max=Math.max( max, root.val+ left+right);
        return Math.max( left, right)+root.val;
    }






//    int maxValue;
//
//    public int maxPathSum(TreeNode root) {
//        maxValue = Integer.MIN_VALUE;
//        maxPathDown(root);
//        return maxValue;
//    }
//
//    private int maxPathDown(TreeNode node) {
//        if (node == null) return 0;
//        int left = Math.max(0, maxPathDown(node.left));
//        int right = Math.max(0, maxPathDown(node.right));
//        maxValue = Math.max(maxValue, left + right + node.val);
//        return Math.max(left, right) + node.val;
//    }

}
