import java.util.*;

/**
 * Created by cpy on 2016/11/23.
 */
public class BinaryTreeLevelOrderTraversal_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while( !queue.isEmpty()){
            int n=queue.size();
            List<Integer> list=new ArrayList<>();
            while(n-->0){
                TreeNode current=queue.poll();
                list.add(current.val);
                if(current.left!=null) queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
            }
            res.add(list);
        }
        return  res;
    }






}
