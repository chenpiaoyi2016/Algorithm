import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by cpy on 2016/11/13.
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res= new ArrayList<>() ;
        BFS(res, root , 0);
        return res;
    }

    private void BFS(List<Integer> res, TreeNode root, int depth){
        if( root==null) return ;

        if( depth== res.size())
            res.add( root.val); //每层第一个便利到的加入， 每次都是right开始

        BFS( res, root.right, depth+1);
        BFS(res, root.left, depth+1);


    }
//////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    /** 上面是递归解法    下面是队列解法 */


    public List<Integer> rightSideView2222222(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        //Queue< TreeNode> q = new Queue<TreeNode>();  queue为抽象的 不能这么写
        Queue< TreeNode> q= new LinkedList<>();
        q.add(root);

        while( ! q.isEmpty() ){ //队列不为空时继续
            int len=q.size();
            for(int i=0; i<len; i++){
                TreeNode node=q.poll();
                if(i==0) res.add(node.val);
                if(node.right!=null) q.add( node.right);
                if(node.left!=null ) q.add( node.left);
            }
        }
        return res;


        /*
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    // last element in current level
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        */
    }

}

class TreeNode{
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
}