package Algorithm;

/**
 * Created by cpy on 2016/11/22.
 */
public class Kmp {

    //暴力
    public static int searchForce(String pat, String txt){
        int m=pat.length(),n=txt.length();
        for(int i=0; i<=n-m;i++){
            int j=0;
            for(j=0; j<m;j++){
                if(pat.charAt(j)!=txt.charAt(i+j)) break;
            }
            if(j==m) return i;
        }
        return n; //not exist
    }



}
