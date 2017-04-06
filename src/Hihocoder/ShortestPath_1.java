package Hihocoder;

import java.util.Scanner;

/**
 * Created by cpy on 2017/4/5.
 * 5 23 5 4
 *
 */
/*
#define V 1005
using namespace std;

int n,m,s,t,d[V][V],k,f[V];
bool flag[V];

int main()
{
	int x,y,z;

	scanf("%d%d%d%d",&n,&m,&s,&t);
	memset(d,0x3F,sizeof(d));

	while (m--)
	{
		scanf("%d%d%d",&x,&y,&z);
		d[x][y]=d[y][x]=min(d[x][y],z);
	}



	memset(f,0x3F,sizeof(f));
	f[s]=0;


	for (int i=1;i<=n;i++)
	{
		k=-1;
		for (int j=1;j<=n;j++)
		 if (!flag[j] && (k==-1 || f[k]>f[j])) k=j;

		flag[k]=true;
		for (int j=1;j<=n;j++)
		f[j]=min(f[j],f[k]+d[k][j]);
	}
	printf("%d\n",f[t]);
	return 0;
}
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
            dis[i]=-1;

        boolean flag[] =new boolean[n+1];

        int m=in.nextInt();
        int start=in.nextInt();

        dis[start]= 0;

        int end=in.nextInt();


        for(int i=0; i<m; i++){
            int s=in.nextInt();
            int t=in.nextInt();
            int length=in.nextInt();
            if( distants[s][t] ==-1){
                distants[s][t]=length;
                distants[t][s]=length;
            }else if( distants[s][t] > length){
                distants[s][t]=length;
                distants[t][s]=length;
            }
        }

        /*
        	for (int i=1;i<=n;i++)
            {
                k=-1;
                for (int j=1;j<=n;j++)
                 if (!flag[j] && (k==-1 || f[k]>f[j])) k=j;
                flag[k]=true;
                for (int j=1;j<=n;j++)
                f[j]=min(f[j],f[k]+d[k][j]);
            }
         */
        for(int i=1;i<=n;i++){
            int k=-1;
            for(int j=1;j<=n;j++)
                if(!flag[j] && (k==-1 || dis[k]> dis[j]))
                    k=j;
            flag[k]=true;
            for (int j=1; j<=n; j++)
                dis[j]= Math.min( dis[j], dis[k]+distants[k][j] );

        }
System.out.println(dis[end]);

    }

}
