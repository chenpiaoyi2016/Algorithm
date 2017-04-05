package Leetcode;

import java.util.*;

/**
 * Created by cpy on 2016/10/26.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res=0 ;
        for (int i:nums)
            res ^= i;
        return res;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for(int i=0;i<nums.length;){
            if( nums[i]!= i+1){
                if(nums[i]== nums[nums[i]-1]) {
                    i++;
                }
                else{
                    int c=nums[nums[i]-1];
                    nums[nums[i]-1]=nums[i];
                    nums[i]=c;
                }
            }
            else
                i++;
            /*
            while( !(nums[i]==nums[nums[i]-1])){
                int c=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=c;
            }
            */
        }

        for(int i=0;i<nums.length;i++)
            if(nums[i]!=i+1)
                ret.add(i+1);
        return ret;
    }

    public static void main( String[] args){
        int[] aha={1,2,3,3,4,2,7};
        List<Integer> ret= findDisappearedNumbers(aha);
        for(int n: ret)
            System.out.print(n);
    }





}
