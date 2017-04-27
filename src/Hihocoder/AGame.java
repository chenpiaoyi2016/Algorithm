package Hihocoder;

/**
 * Created by cpy on 2017/4/27.
 */

import java.util.Scanner;
public class AGame {

    static int[][] dp=new int[1000][1000];
    static int[] sum=new int[1000];

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=in.nextInt();
        sum[0]=nums[0];
        // 技巧1： 预处理
        for(int i=1;i<n;i++)
            sum[i]=sum[i-1]+nums[i];
        for(int i=0; i<n; i++)
            dp[i][i]= nums[i];

        for(int step=1;step<n;step++){
            //技巧2  尽量不用自顶向下的方法 占用太多内存
            // 用step的方式 从对角线往边上拓展 可以避免用到的dp[][]还没算
            for(int i=0;i<n-step;i++){
                int localSum=sum[i+step]-sum[i]+nums[i];
                dp[i][i+step]= localSum-Math.min(dp[i+1][i+step],dp[i][i+step-1]);
            }
        }
        System.out.println( dp[0][n-1] );

    }



}


  class Solution {

    int[][] dp=new int[20][20];
    int[] sum=new int[20];

    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length;
        sum[0]=nums[0];
        for(int i=1;i<n;i++)
            sum[i]=sum[i-1]+nums[i];

        for(int i=0;i<n;i++)
            dp[i][i]=nums[i];
        int maxA= recurse(nums, 0,n-1 ) ;
        int maxB=sum[n-1]-maxA;
        if(maxA>=maxB) return true;
        else return false;
    }

    private int recurse(int[] nums, int left, int right){
        if(left==right)
            return nums[left];
        else if(dp[left][right]!=0)
            return dp[left][right];
        else{
            int localSum=sum[right]-sum[left]+nums[left];
            dp[left][right]= localSum -Math.min( recurse(nums, left,right-1 ), recurse(nums,left+1,right) );
            return dp[left][right];
        }

    }

}