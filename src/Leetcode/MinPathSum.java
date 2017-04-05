package Leetcode;

/**
 * Created by cpy on 2016/11/1.
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int row= grid.length;    //行
        int col=grid[0].length; //列
        int[][] dp=new int [row][col]; //到dp[i][j]最小路径值

        dp[0][0]=grid[0][0];
        for (int i=1;i<col; i++)
            dp[0][i]= dp[0][i-1]+ grid[0][i]; //初始化第1行
        for (int i=1;i<col; i++)
            dp[i][0]= dp[i-1][0]+ grid[i][0]; //初始化第1列

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j]= grid[i][j]+ Math.min( dp[i][j-1], dp[i-1][j]);
            }
        }


        return dp[row-1][col-1];
    }

}
