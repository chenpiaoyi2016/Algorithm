package Hihocoder;

import java.util.Scanner;

/**
 * Created by cpy on 2017/3/25.
 * N<=10^6，Q<=10^6, 1<=Li<=Ri<=N，0<weight_i<=10^4
 */
public class RMQ_ST {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n+1];
        for(int i=1; i<=n;i++) nums[i]=in.nextInt();
        int[][] st=new int[n+1][22];
        for( int i=1;i<=n;i++)
            st[i][0]=nums[i];

        for( int j=1; (1<<j) <=n-1; j++ )
            for (int i=1; (i+ (1<<(j-1)) )<=n; i++)
                st[i][j]=Math.min( st[i][j-1],st[i+ (1<<(j-1)) ][j-1] );

        int m=in.nextInt();

        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();

            int k=1;
            while( (1<<k) < b-a +1)  k++;
            k--;
            System.out.println( Math.min( st[a][k], st[b-(1<<k)+1][k]));
        }
    }
}

/*

#include <stdio.h>
int dp[1000010][22];
#define min(a,b) a>b?b:a
int main()
{
	int n,i,j,m,a,b,k;
	scanf("%d",&n);
	for(i=1;i<=n;i++) scanf("%d",&dp[i][0]);
	for(j=1;(1<<j)<=n;j++) for(i=1;(i+(1<<(j-1)))<=n;i++)
		dp[i][j]=min(dp[i][j-1],dp[i+(1<<(j-1))][j-1]);
	scanf("%d",&m);
	while(m--){
		scanf("%d%d",&a,&b);
		k=1;while((1<<k)<(b-a+1)) k++;k--;
		printf("%d\n",min(dp[a][k],dp[b-(1<<k)+1][k]));
	}return 0;
}
 */