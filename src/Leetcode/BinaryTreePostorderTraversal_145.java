package Leetcode;

import java.util.*;

/**
 * Created by cpy on 2017/1/15.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversalByRecurse(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        if (root.left!=null)
            res.addAll( postorderTraversalByRecurse(root.left));
        if(root.right!=null)
            res.addAll( postorderTraversalByRecurse(root.right));
        res.add(root.val);
        return res;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res=new LinkedList<>();  //如果前面是list 就不能用下面的方法addFirst
        Stack<TreeNode> stack=new Stack<>();
        if(root==null) return res;

        stack.push(root);
        while(!stack.empty()){
            TreeNode cur=stack.pop();

            res.addFirst(cur.val);
            if(cur.left!=null)
                stack.push(cur.left);
            if(cur.right!=null)// 右子树在后面 所以先插入
                stack.push(cur.right);
        }
        return res;
    }

    public static void main(String [] args){
        List<String > list=new ArrayList<>( Collections.nCopies(6, "hello"));
        Collections.fill(list ,"cpy");
        System.out.println(list);
    }
}
