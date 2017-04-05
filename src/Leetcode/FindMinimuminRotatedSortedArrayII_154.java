package Leetcode;

/**
 * Created by cpy on 2016/11/17.
 */
public class FindMinimuminRotatedSortedArrayII_154 {
    public static int findMin(int[] nums) {
        if(nums.length==0 || nums==null)  return Integer.MIN_VALUE;
        int left=0, right=nums.length-1, mid;
        while( left<right){
            mid= left+ ( (right-left)>>1) ;
            //mid= left+ (right-left)/2;
            if( nums[mid] < nums[right]) right=mid;
            else if( nums[mid]>nums[right])
                //left=mid;
                left=mid+1;
            else right--; //nums[right]== nums[mid] 最小数不会被排除
        }
        return nums[left];
    }


    public static void main(String[] args){
        int[] arr={1,3,1,1};
        System.out.println( findMin(arr));
    }
}
