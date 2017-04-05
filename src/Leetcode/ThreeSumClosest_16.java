package Leetcode;

import java.util.*;

/**
 * Created by cpy on 2016/11/7.
 */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res=nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-2; i++){
            int j=i+1, k=nums.length-1;
            while( j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if( Math.abs(target-sum)< Math.abs(target-res))
                    res=sum;
                if(sum>target)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }

}
