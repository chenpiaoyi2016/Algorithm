import java.util.*;

/**
 * Created by cpy on 2017/1/12.
 */
public class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        //init= new ArrayList<Integer>(Arrays.asList(nums)); why cannot
        this.nums=nums;
        random=new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();///////////////////////
        for(int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }
    private void swap(int[] nums,int i,int j){
        nums[i]=nums[i]^nums[j];
        nums[j]=nums[i]^nums[j];
        nums[i]=nums[i]^nums[j];
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */