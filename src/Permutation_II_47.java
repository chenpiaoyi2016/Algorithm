import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cpy on 2016/11/10.
 */
public class Permutation_II_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length], 0);
        return res;
    }


    private void backtrack(List<List<Integer>> res, List<Integer> list,
                           int [] nums, boolean [] used, int t) { //t表示当前list中有几个数
        if(t== nums.length )
            res.add(new ArrayList<Integer>(list));
        else {
            for (int i=0; i<nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                if( used[i]==false){
                    list.add(nums[i]);
                    used[i]=true;
                    backtrack(res, list, nums, used, t+1 );
                    list.remove( t );
                    used[i]=false; //used传递过去？？
                }
            }
        }
    }


}
/*
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
    if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
 */