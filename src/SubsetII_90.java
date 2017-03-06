
import java.util.*;


public class SubsetII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtracking( nums, 0, res, list);
        return res;

    }

    public void backtracking(int[] nums, int index, List<List<Integer>> res,List<Integer> list) {
        if(index<= nums.length)
            res.add(list);
        int i=index;
        while( i<nums.length){//大层while 选取的是某个有或者没有的元素 只有1  只有2  只有 3
            list.add( nums[i]);
            backtracking( nums, i+1, res, new ArrayList<>(list));
            list.remove(list.size()-1);
            i++;
            while(i<nums.length && nums[i]==nums[i-1])
                i++;

        }
        return;
    }


}