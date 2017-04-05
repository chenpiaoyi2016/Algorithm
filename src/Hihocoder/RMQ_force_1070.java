package Hihocoder;

import java.util.Scanner;

/**
 * Created by cpy on 2017/3/27.
 */
/*
10
618 5122 1923 8934 2518 6024 5406 1020 8291 2647

6
0 3 6
1 2 2009
0 2 2
0 2 10
1 1 5284
0 2 5
*/
public class RMQ_force_1070 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n+1];
        for(int i=1; i<=n;i++) nums[i]=in.nextInt();

        int m=in.nextInt();
        for (int i=0;i<m;i++){
            int flag=in.nextInt();
            int a=in.nextInt();
            int b=in.nextInt();
            if(flag==0){
                int min=nums[a];
                for( int j=a;j<=b;j++)
                    min=Math.min( min, nums[j]);
                System.out.println(min);
            }else if(flag==1){
                nums[a]= b ;
            }
        }

    }
}
