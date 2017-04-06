/**
 * Created by cpy on 2017/2/22.
 */

import java.util.*;
public class Triangle_120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n =triangle.size();
        int dp[]=new int [n];
        int dp2[]=new int [n];
        for(List<Integer>  list: triangle){

            dp[0] =dp2[0]+ list.get(0);
            if(list.size()!=1)
                dp[list.size()-1] = dp2[list.size()-2]+list.get( list.size()-1);

            for(int i=1;i<list.size()-1;i++)
                dp[i]= Math.min( dp2[i], dp2[i-1])+list.get(i);
            //dp ->dp2
            System.arraycopy(dp, 0, dp2, 0, n);
// time performance too bad  n方时间  n空间
        }
        Arrays.sort(dp);

        return dp[0];
    }

    public static void main(String args[]){
        List<List<Integer>> triangle=new ArrayList<List<Integer>>() ;
        List<Integer> list=new ArrayList<>();
        list.add(-1);
        List<Integer> list2=new ArrayList<>();
        list2.add(-2);
        list2.add(-3);
        triangle.add(list);
        triangle.add(list2);
        int n= minimumTotal(triangle);
        //System.out.print(n);
    }
}

