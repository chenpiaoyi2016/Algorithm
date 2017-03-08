import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
 where h is the height of the tree.


 */

public class BSTIterator_173 {
    private Stack<TreeNode> stack=new Stack<>();

    private void pushAll( TreeNode root){
        for(;root!=null;root=root.left )
            stack.push(root);
    }
    public BSTIterator_173(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
//    Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
    /** @return the next smallest number */
    public int next() {
        TreeNode tem=stack.pop();
        pushAll(tem.right);
        return tem.val;
    }
}

/**
 * Your BSTIterator_173 will be called like this:
 * BSTIterator_173 i = new BSTIterator_173(root);
 * while (i.hasNext()) v[f()] = i.next();
 */