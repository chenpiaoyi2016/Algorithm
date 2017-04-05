package Leetcode;

/**
 * Created by cpy on 2016/10/26.
 */
public class reverse_344 {
    public String reverseString(String s) {
        if(s=="" || s==null)
            return s;
        StringBuilder sb=new StringBuilder();
        int l=s.length();
        for(int i=l-1; i>=0; i--){
            sb.append( s.charAt(i));
        }
        return sb.toString();
    }
}
