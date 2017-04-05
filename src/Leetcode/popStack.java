package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpy on 2017/1/13.
 */
public class popStack {
    public static ArrayList<String> getStrings(String init){
        //dont use recurse
        //  用Stringindex模拟出栈顺序
        //  abc    dabc adbc          abcde  abced
        ArrayList<String> res1=new ArrayList<>();
        ArrayList<String> res2=new ArrayList<>();

        ArrayList<String> res3=new ArrayList<>();
        for(int i=0;i<=init.length();i++){
            StringBuilder s1=new StringBuilder(init);
            res1.add(  s1.insert(i,'d').toString());
        }
        for(String s:res1){
            int j=s.indexOf('d');
            for(int i=j+1;i<=s.length();i++){
                StringBuilder s2=new StringBuilder(s);
                res2.add( s2.insert(i, 'e').toString() );
            }
        }
        for(String s:res2){
            //find start
            int j=s.indexOf('e');
            for(int i=j+1;i<=s.length();i++){
                StringBuilder s3=new StringBuilder(s);
                res3.add( s3.insert(i, 'f').toString() );
            }
        }
        return res3;
    }

    public static ArrayList<String> getStrings(String init, String ins){
        ArrayList<String> res1=new ArrayList<>();
        for(int i=0;i<=init.length();i++){
            StringBuilder s1=new StringBuilder(init);
            res1.add(  s1.insert(i,ins.charAt(0)).toString());
        }
        ArrayList<String> res;

        for(int i=1;i<ins.length();i++){  //插入ins.charAt(i)
            res=new ArrayList<>();
            for(String s:res1){

                int j=s.indexOf( ins.charAt(i-1));
                for(int k=j+1;k<=s.length();k++){
                    StringBuilder sb=new StringBuilder(s);
                    res.add(    sb.insert(k,ins.charAt(i)).toString());
                }
            }
            res1=res;

        }
        return res1;
    }

    public static void main(String[] args){
        ArrayList<String> res1=getStrings("ABC", "DEF");
        System.out.println( res1.size());
        for (String s:res1)
            System.out.println(s);
    }
}
