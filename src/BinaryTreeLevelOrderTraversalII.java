import java.util.*;

/**
 * Created by cpy on 2016/11/13.
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if( root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add( root);
        while(queue.size()>0){
            List<Integer> list =new ArrayList<>();
            int size=queue.size();

            //用for循环来有规律地生成插入
            for( int i=0; i<size; i++){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            res.add(0, list);

        }

        return res;

    }

    private void BFS(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) return;
        if(level >= res.size())
            res.add(0, new LinkedList<Integer>());

        BFS(res, root.left, level+1);
        BFS(res, root.right, level+1);
        res.get( res.size()-level-1 ).add(root.val);
    }
}
