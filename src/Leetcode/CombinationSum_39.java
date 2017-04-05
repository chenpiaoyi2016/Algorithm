package Leetcode; /**
 * Created by cpy on 2016/11/11.
 */
import java.util.*;
public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List< List<Integer>> res= new ArrayList<>();
        Arrays.sort( candidates );
        backtracking( res, new ArrayList<Integer>(), candidates, target ,0, 0);
        return res;
    }

    private void backtracking( List<List<Integer>> res,
                               List<Integer> list, int[] nums, int target,int sum, int start ){
        if( sum==target)
            res.add( new ArrayList<>( list));
        else if( sum< target)
            for(int i=start; i<nums.length ;i++){
                list.add( nums[i]);
                backtracking(res, list, nums, target,sum+nums[i], i); //考虑到重复元素 不重复的话 i+1
                list.remove( list.size() -1); //移除最后添加的元素套路
            }
    }


}
