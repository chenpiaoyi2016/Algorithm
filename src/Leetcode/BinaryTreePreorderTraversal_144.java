package Leetcode;

import java.util.*;

/**
 * Created by cpy on 2016/11/22.
 */
public class BinaryTreePreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) { //先序
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();

        if(root==null) return res;
        else stack.push(root);
        while( ! stack.empty()){
            TreeNode s=stack.pop();
            res.add(s.val);
            if(s.right!=null) stack.push(s.right);
            if(s.left!=null) stack.push(s.left);

        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {  //先序遍历
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();

        TreeNode current=root;
        while ( !stack.empty() || current!=null){//?
            while(current!=null){
                stack.push(current);
                current=current.left;
            }
            //if(current==null) // must be
            current=stack.pop();  //right或left到底端时为null 要获取
            res.add(current.val);
            current=current.right;//right=null时 下一次循环会获取  不是null
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();

        TreeNode current=root;

        while ( !stack.empty()   || current!=null){
            while(current!=null){
                stack.push(current);
                current=current.left;
            }
            current=stack.pop();  //right或left到底端时为null 要获取
            current=current.right;//right=null时 下一次循环会获取  不是null
        }

        return res;
    }

    //////////////////////////////////////////////////////////////////////////////
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue=new PriorityQueue<>();
        for(int n:nums)
            queue.offer(n);
        while(queue.size()>k)
            queue.poll();
        return queue.poll();
    }

    public List<TreeNode> generateTrees(int n) {
        return recursiveTreeList(1,n);
    }

    private List<TreeNode> recursiveTreeList(int start, int end ){
        List<TreeNode> res=new ArrayList<>();

        if(start==end){
            TreeNode nt=new TreeNode(start);
            res.add(nt);
            return res;
        }
        if(start >end) {
            res.add(null); //??
            return res;
        }

        List<TreeNode> leftTreeList, rightTreeList;
        for(int i=start;i<=end;i++){   //root为i
            leftTreeList=recursiveTreeList(start,i-1);
            rightTreeList=recursiveTreeList(i+1, end);
            for(TreeNode leftTree:leftTreeList){
//                TreeNode nt=new  TreeNode(i);
//                nt.left=leftTree;
                for(TreeNode rightTree: rightTreeList){
                    TreeNode nt=new TreeNode(i);
                    nt.left=leftTree;
                    nt.right=rightTree;
                    res.add(nt);
                }
            }

        }
        return res;
    }

    public static int numSquares(int n) {
        if(n<=0) return 0;
        int[] dp=new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int sq= (int)Math.sqrt(i);
            if(sq*sq==i) dp[i]=1;
            else{
                // dp[i]=1+dp[i-sq*sq];//贪心算法不好用
                for(int j=1;i<=sq;i++){
                    dp[i]=Math.min(dp[i], 1+dp[i-j*j] );
                }
            }

        }

        return dp[n];
    }

    public static void main(String[] args){
    }


}
