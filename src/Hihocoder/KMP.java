package Hihocoder;

import java.util.Scanner;

/**
 * Created by cpy on 2017/3/24.
 */
public class KMP {

    static int[] next;

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++)
            System.out.println( getKMP( in.next(), in.next() ));

        in.close();
    }

    private static void getNext(String partern){
        next=new int[partern.length()];
        next[0]=-1;
        int len=partern.length();
        for (int i = 0, j = -1 ; i < len - 1; ++i, ++j) {
            while (j != -1 && partern.charAt(j) != partern.charAt(i)) {
                j = next[j];
            }
            next[i + 1] = j + 1;
        }
        for( int i =0;i<next.length;i++)
            System.out.print(next[i]+" ");
        System.out.print("\n");

    }

    private static  int getKMP(String pattern, String origin){
        getNext(pattern);
        int res=0;
        for(int i=0,j=0;i<origin.length(); i++,j++ ){
            while( j!=-1  &&  pattern.charAt(j)!= origin.charAt(i))
                j=next[j];
            // 此时 j=-1  或者 那两个字符相等

            if( j==pattern.length()-1 ) { // 对应的字符相等 并且是模式串最后一个了
                res++;
                j=next[j]; //!!!!!!
                while ( j!=-1 && pattern.charAt(j)==origin.charAt(i))
                    j=next[j];
            }
        }
        return res;
    }

}