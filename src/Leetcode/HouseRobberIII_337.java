package Leetcode;

import java.util.*;

/**
 * Created by cpy on 2016/11/23.
 */
public class HouseRobberIII_337 {

    public class Solution {  //greedy
        public int rob(TreeNode root) {
            int[] res=robSub(root);
            return Math.max(res[0], res[1]);

        }
        private int[] robSub(TreeNode root){
            if(root==null) return new int[2];
            int[] left=robSub(root.left);
            int[] right=robSub(root.right);
            int[] res=new int[2];
            res[0]=root.val+left[1]+right[1];
            res[1]=Math.max(left[0],left[1])+Math.max(right[0], right[1]);
                    //left[0]+right[0]  left[0]+right[1]  left[1]+right[0] left[0]+right[0]不可能 和必然比+val小
            return res;
        }
    }


    public class SolutionByDp {
        public int rob(TreeNode root){
            Map<TreeNode, Integer> map = new HashMap<>();
            return robSub(root, map);
        }

        private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
            if (root == null) return 0;
            if (map.containsKey(root)) return map.get(root);

            int val = 0;
            if (root.left != null)  val += robSub(root.left.left, map) + robSub(root.left.right, map);
            if (root.right != null) val += robSub(root.right.left, map) + robSub(root.right.right, map);

            val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
            map.put(root, val);
            return val;
        }

    }

}
