package Algorithm;

import java.util.Scanner;

/**
 * Created by cpy on 2017/4/2.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Long n=scanner.nextLong();
        hehe h=new hehe();
        //System.out.println( Long.MAX_VALUE);
        System.out.println( h.getNthNumber1(n) );

        for( Long k= 0l; k<1000;k++ ){
            hehe qq=new hehe();
            System.out.println( qq.getNthNumber1(k) );
        }
    }

}
class hehe {
    long[][] f = new long[][]{{2, 3}, {1, 0}};

    public int getNthNumber1(Long n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        f = pow(n-1, f);
        return (int) ( f[0][0]+f[0][1] ) % 1000000007;
    }

    private long[][] pow(Long n, long[][] f) {
        if (n == 1)
            return f;
        if (n == 2) {
            return fun(f, f);
        }
        if (n % 2 == 0) {
            f = pow(n / 2, f);
            return fun(f, f);
        } else {
            return fun(pow(n / 2, f), pow(n / 2 + 1, f));
        }
    }

    private long[][] fun(long[][] f, long[][] m) {
        long[][] temp = new long[2][2];
        temp[0][0] = (f[0][0] * m[0][0] + f[0][1] * m[1][0]) % 1000000007;
        temp[0][1] = (f[0][0] * m[0][1] + f[0][1] * m[1][1]) % 1000000007;
        temp[1][0] = (f[1][0] * m[0][0] + f[1][1] * m[1][0]) % 1000000007;
        temp[1][1] = (f[1][0] * m[0][1] + f[1][1] * m[1][1]) % 1000000007;
        return temp;
    }
}