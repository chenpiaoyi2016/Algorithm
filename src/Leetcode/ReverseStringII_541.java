package Leetcode;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * Created by cpy on 2017/3/24.
 */
public class ReverseStringII_541 {

    public static  String reverseStr(String s, int k) {
        char[] chars=s.toCharArray();
        int len=s.length();
        int loop=s.length()/ (2*k);//完整的
        for(int i=0;i<loop;i++){
            for (int j=0;j<k/2;j++){
                // i*2*k ->  i*2*k+k-1
                char temp=chars[i*2*k+j];
                chars[i*2*k+j]=chars[i*2*k+k-1-j];
                chars[i*2*k+k-1-j]= temp;
            }
        }
        if( len%(2*k) >k){
            for (int j=0;j<k/2;j++){
                char temp=chars[loop*2*k+j];
                chars[loop*2*k+j]=chars[loop*2*k+k-1-j];
                chars[loop*2*k+k-1-j]= temp;
            }
        }else {
            int remain=len%(2*k);
            for ( int i=0; i< remain/2;i++){
                char temp=chars[loop*2*k+i];
                chars[loop*2*k+i]=chars[len-1-i];
                chars[len-1-i]= temp;
            }
        }
        //String ss= chars.toString();  WRONG
        String ss=new String(chars);
        //String sss= String.valueOf(chars)
        return ss;
    }

    public static void main(String[] args) {
        System.out.print( reverseStr("12345678912",3) );
    }
    //private String reverseFromTo  String变换浪费太多时间
}
