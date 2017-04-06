package Hihocoder;

import java.util.Scanner;

/**
 * Created by cpy on 2017/4/5.
 * 5 23 5 4
 *
 */

public class ShortestPath_1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int distants[][]= new int[n+1][n+1];
        for( int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                distants[i][j]=-1;


        int dis[]=new int[n+1];
        for ( int i=1;i<=n;i++)
            dis[i]=Integer.MAX_VALUE;

        boolean flag[] =new boolean[n+1];
        for (int i=0;i<=n;i++)
            flag[i]=false;

        int m=in.nextInt();
        int start=in.nextInt();

        dis[start]= 0;

        int end=in.nextInt();

        for (int i=1;i<=n;i++)
            distants[i][i]= 0;

        for(int i=0; i<m; i++){
            int s=in.nextInt();
            int t=in.nextInt();
            int length=in.nextInt();
            if( distants[s][t] ==-1 || distants[s][t] > length){
                distants[s][t]=length;
                distants[t][s]=length;
            }
        }


        for(int i=1;i<=n;i++){  //一次加入一个到最短路径集合中
            int k=-1;
            for(int j=1;j<=n;j++) {
                if (!flag[j] && (k==-1) )//j还不在最短路径集合中
                    k = j;
                else if(!flag[j] && dis[k] > dis[j])
                    k=j;
            }
            flag[k]=true;
            for (int j=1; j<=n; j++) //更新经过k的其他点的最小值
                dis[j]= Math.min( dis[j], dis[k]+distants[k][j] );

        }
System.out.println(dis[end]);

    }

}
