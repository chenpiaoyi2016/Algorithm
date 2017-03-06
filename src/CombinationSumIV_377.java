import java.util.*;

/**
 * Created by cpy on 2016/11/15.
 */
public class CombinationSumIV_377 {
    /**
     *  条件：  没有重复的正数   回溯可以做 但是超时
     *
     *  找硬币问题也能用回溯做 但是太慢了  所以用dp  实质是没有重复排列的本题
     */

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
            for (int num : nums) {
                if (num > i)
                    break;
                else if (num == i)
                    res[i] += 1;
                else
                    res[i] += res[i-num];
            }
        }
        return res[target];
    }





    /*
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort( nums );
        backtracking( res, new ArrayList<Integer>(), nums, target ,0, 0);
        return res.size();
    }

    private void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, int target ,int sum,int start ){
        if(sum== target)
            res.add( new ArrayList<> ( list));
        else if( sum< target){
            for( int i=0; i<nums.length ;i++) {
                list.add(nums[i]);
                backtracking( res, list,nums, target, sum+nums[i], i);
                list.remove(  list.size()-1 );
            }
        }
    }
    */
}
