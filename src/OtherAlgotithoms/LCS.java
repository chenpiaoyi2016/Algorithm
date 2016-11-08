package OtherAlgotithoms;

/*
   最长公共子序列
 * Created by cpy on 2016/11/8.
 */
public class LCS {
    public static String LCSsolution( String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        int[][] c=new int[m][n]; //表示 xi yj的最长公共子序列的长度
        int[][] b=new int[m][n]; //bij表示 cij由哪个 之前的cij得到
        LCSLength(m,n,s1,s2,c,b);

        if( m==0 || n==0) return "";
        //if( b[m-1][n-1] ==1)

        return "";
    }



    public static void LCSLength( int m,int n, String s1, String s2, int[][] c, int[][] b){
        int i,j;
        for( i=1; i<m;i++)
            c[i][0]=0;
        for(j=0;j<n;j++)
            c[0][j]=0;
        for(i=1; i<m;i++)
            for(j=1; j<n; j++){
                if( s1.charAt(i)== s2.charAt(j) ){
                    c[i][j] =c[i-1][j-1]+1 ;
                    b[i][j]=1;
                }else if( c[i][j-1] >=c[i-1][j] ){
                    c[i][j]=c[i][j-1];
                    b[i][j]=2;
                }else {
                    c[i][j]=c[i-1][j];
                    b[i][j]=3;
                }

            }
    }
}
