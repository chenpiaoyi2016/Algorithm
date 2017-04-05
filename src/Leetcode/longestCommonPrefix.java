package Leetcode;

/**
 * Created by cpy on 2016/10/11.
 * thought: length 前n的最长公共序列和第n个String对比，更新公共序列串
 *
 * 边界错误..
 */
public class longestCommonPrefix {
    public static String longestCommonPrefix2(String[] strs) {
        int length= strs.length;
        if(length==0)
            return "";
        String ss=strs[0];
        //System.out.println(ss);
        int j;
        for (int i=0; i<length-1;i++){//n-1次
            for (j=0; j<strs[i+1].length()&& j<strs[i].length()&& (strs[i].charAt(j)==strs[i+1].charAt(j)); j++ ){

            }
            String ss2=strs[i].substring(0,j);
            ss= ss.length()>ss2.length() ?  ss2:ss;
        }
        return ss;
    }

    public  static void main(String[] args){
        String[] myStrings={ };
        String s=longestCommonPrefix2(myStrings);
        System.out.println(s);

    }

}
