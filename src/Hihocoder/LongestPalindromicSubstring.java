package Hihocoder;

import java.util.Scanner;

/**
 * Created by cpy on 2017/3/24.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            String str=in.next();
            System.out.println( LPS_manacher (  str) );

        }
        in.close();

    }

    public static int LPS_m (String s) {
        if(s.length() <= 1)
            return s.length();

        int len = s.length(), newlen = 2*len+1;
        char c[] = new char[newlen];
        for(int i = 0; i < newlen; i++)
            c[i] = (i % 2 == 1)?s.charAt(i/2):0;
        int p[] = new int[newlen];
        int id = 0, right = 0;
        int max = 0;
        for(int i = 0; i < newlen; i++){
            p[i] = 1;
            if(right > i){
                if(i + p[2*id-i] < right)
                    p[i] = p[2*id-i];
                else
                    p[i] = right - i;
            }
            while(i - p[i] >= 0 &&  i + p[i] < newlen && c[i-p[i]] == c[i+p[i]]){
                p[i]++;
            }
            if(p[i] + i > right){
                id = i;
                right = p[i] + i;
            }

            if(max < p[i]-1)
                max = p[i]-1;
        }
        return max;
    }


    public static int LPS_manacher(String s){
        if(s.length()<=1) return s.length();
        int len=s.length(), newlen=2*len+1;
        char c[]=new char[newlen];
        for(int i=0;i<newlen;i++){
            if(i%2==0)  c[i]= '#';
            else        c[i]= s.charAt( (i-1)/2);
        }
        int r[]=new int [newlen];
        int pos=0, maxRight=0;
        int maxLen=0;
        for(int i=0; i<newlen;i++){
            r[i]=1;
            if( i<maxRight)
                r[i]= Math.min( r[2*pos-i], maxRight-i);
            //没必要else 直接r[i]=1 从头开始
            while( i-r[i]>=0 && i+r[i]<newlen && c[i+r[i]]==c[i-r[i]])  //继续向外拓展
                r[i]++;

            if( r[i]+i>maxRight ){ //更新pos maxR
                pos=i;
                maxRight=r[i]+i;
            }
            maxLen=Math.max( maxLen, r[i]-1);
        }
        return maxLen;




    }




//DP也太慢了
    public static String longestPalindrome_leetcode(String s) {

        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        int max=1;
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        int start = 0, end = 0;
        for(int i=0; i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                max=2;
                start=i;
                end=i+1;
            }
            else
                dp[i][i+1]=false;
        }
        for(int l=3;l<=n;l++)
            for(int i=0; i<n-l+1; i++){
                int j=i+l-1;
                if( s.charAt(i)==s.charAt(j) &&  dp[i+1][j-1]==true){
                    dp[i][j]=true;
                    max=l;
                    start=i;
                }
            }
        return s.substring( start, start+max);
    }



    private static int LPS_from_center(String s){
        int max=1,len=s.length();
        for ( int c=0;c<len;c++){
            int limit=Math.min( c-0, len-1-c);
            for(int i=1;i<limit;i++){
                if(s.charAt(c-i)==s.charAt(c+i)){

                }
            }
        }
        return max;
    }

    private static int LPS_force(String s){
        int max=1,len=s.length();
        if ( len<=1) return len;
        for ( int i=0;i<len;i++){
            for(int j= i+1; j<len; j++){
                if( judge(s, i,j) )
                    max=Math.max( max, j+1-i);
            }
        }
        return max;
    }
    private static boolean judge(String s, int i, int j ){
        for( int k=i;k<i+(j-i+1)/2; k++){
            if( s.charAt(k)!=s.charAt( j-k+i))
                return false;
        }
        return  true;

    }
}
