/**
 * Created by cpy on 2016/11/15.
 */
import java.util.*;
public class CombinationSumII_40 {
    // 用DP试试？？  什么时候能用dp》？？？
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res =new ArrayList<>();
        Arrays.sort(candidates);
        backtracking( res, new ArrayList<Integer>(), candidates, target ,0 , 0);
        return  res;
    }
    private void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, int target ,int sum,int start ){
        if(sum== target)
            res.add( new ArrayList<>( list));
        else if( sum<target){
            for( int i=start; i<nums.length ;i++) {
                if(i > start && nums[i]==nums[i-1]) continue;
                list.add(nums[i]);
                backtracking( res, list,nums, target, sum+nums[i], i+1);
                list.remove(  list.size()-1 );
            }
        }
    }
}
