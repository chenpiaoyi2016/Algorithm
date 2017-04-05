package Leetcode;

/**
 * Created by cpy on 2016/10/26.
 */
public class FindTheDifference_389 {
    public char findTheDifference(String s, String t) {
        /*
        if(s==null || s=="")
                return t.charAt(0);
        char c=s.charAt(0);
        */
        char c=0;        //c=0是每一位都是0
        for(char d:s.toCharArray()) //  str.toCharArray
            c^=d;

        for(char d:t.toCharArray()) //  str.toCharArray
            c^=d;


        return c;

    }
}
