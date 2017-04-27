package Leetcode;

/**
 * Created by cpy on 2017/2/23.
 */
public class MinimumSizeSubarraySum_209 {

    public static int minSubArrayLen(int s, int[] nums) {
        int fast=-1,slow=0, min=Integer.MAX_VALUE ,sum=0,length=0;
        boolean flag=true;//1是right 0是left
        while( fast<nums.length-1 ){
            while( flag && fast <nums.length-1){//    从别人的代码中可以看出 这个放在上一个while即可
                if(nums[++fast]>=s) return 1;//void sth
                sum+=nums[fast];
                if(sum>=s){
                    flag=false;
                    length=fast-slow+1;
                    min=   length<min? length: min ;
                }
            }
            while(!flag  &&slow<fast){ //handle the domain  //判断条件不对 sum beter
                sum-=nums[slow++];
                if( sum<s){
                    flag=true;
                }else{//update min
                    length=fast-slow+1;
                    min=   length<min? length: min ;
                }
            }
        }
        return  min==Integer.MAX_VALUE? 0: min;
    }


    public static void main(String args[]){
        int [] nums={2,3,1,2,4,3};

    }

}
