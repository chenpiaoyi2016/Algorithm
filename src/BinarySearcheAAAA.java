/**
 * Created by cpy on 2016/11/17.
 */
public class BinarySearcheAAAA {

    private static int binarySaerch(int[] nums, int target){
        if(nums==null) return -1;
        int left=0, right=nums.length-1, mid;
        while( left<right){
            mid=left+ (right-left)/2;  //到left right相邻时  mid会=left

            if( nums[mid]<target)  left=mid+1;
            else if( nums[mid]> target) right=mid-1;
            else return mid;

        }
        if(nums[left]==target) return left;
        else return -1;
    }
/*
    private static int binarySaerch2(int[] nums, int target){
        if(nums==null) return -1;
        int left=0, right=nums.length, mid;
        while( left<=right){
            mid=left+ (right-left)/2;

            if( nums[mid]<target)  left=mid+1;
            else if( nums[mid]> target) right=mid-1;
            else return mid;

        }
        if(nums[left]==target) return left;
        else return -1;
    }
*/


    private static int binarySaerchFirstTime(int[] nums, int target){
        if(nums==null) return -1;
        int left=0, right=nums.length-1, mid;
        while( left< right){
            mid=left+ (right-left)/2;

            if( nums[mid]>=target)  right=mid; //mid可能是第一次 也可能是在mid之前
            else if( nums[mid]< target) left=mid+1;// 第一次出现的位置肯定不在mid和之前

            //else return mid;

        }
        if(nums[left]==target) return left;
        else return -1;
    }

    private static int binarySaerchLastTime(int[] nums, int target){
        if(nums==null) return -1;
        int left=0, right=nums.length-1, mid;
        /*
        while( left< right){
            mid=left+ (right-left)/2;

            if( nums[mid]<=target) {
                left = mid; //mid可能是第一次 也可能是在mid之前
                //可能死循环

            }
            else if( nums[mid]> target) right=mid-1;// 第一次出现的位置肯定不在mid和之前

            //else return mid;

        }
        if(nums[left]==target) return left;
        else return -1;
        */
        while( left< right){
            mid=left+ (right-left)/2;

            if( nums[mid]< target)
                left = mid+1; // mid可能是第一次 也可能是在mid之前
            else if( nums[mid]> target) right=mid-1;// 第一次出现的位置肯定不在mid和之前
            else{
                if(left == mid)//left right相邻时的情况
                    if(nums[right] == target)
                        return right;
                    else
                        return left;
                else
                    left = mid;
            }

        }
        if(nums[left]==target) return left;
        else return -1;
    }

    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while( i<s.length() && j<t.length()){
            if( t.charAt(j)==s.charAt(i))
                i++;
            j++;
        }
        return i==s.length();
    }

    public static void main(String[] args){
        int[] arr={1,2,4,4,4,4,7};
        System.out.println(  binarySaerchLastTime(arr,4));
    }
}

/*
    private static int binarySaerch(int[] nums, int target){
        if(nums==null) return -1;
        int left=0, right=nums.length, mid;
        while( left<right){
            mid=left+ (right-left)/2;

            if( nums[mid]<target)  left=mid+1;
            else if( nums[mid]> target) right=mid-1;
            else return mid;

        }
        if(nums[left]==target) return left;
        else return -1;
    }

 */

