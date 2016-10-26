/**
 * Created by cpy on 2016/10/18.
 */
public class HouseRobber198 {

    public static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1)return nums[0];

        //初始化数组 来存储sum
        int[] sum = new int[nums.length];
        sum[0]= nums[0];
        sum[1]= Math.max(nums[0], nums[1]);

        for(int i =2;i<nums.length;i++){
            sum[i]= Math.max(nums[i]+sum[i-2],  sum[i-1]);
        }

        return sum[nums.length-1];
    }

    public static void main(String[] args){
        int[] a= {2,1,3,1,4,2};
        int s=rob(a);
        System.out.print(s);
    }
}
