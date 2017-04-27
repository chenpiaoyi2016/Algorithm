package Hihocoder;

import java.util.Scanner;

/**
 * Created by cpy on 2017/4/24.
 */
public class StateCompress_1 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int q=in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=in.nextInt();

        int[] muls = new int[m];
        for (int i = 0; i < m; i++) {
            muls[i] = 1 << i;
        }

        int M = 1 << m;
        int[] bits = new int[M];
        bits[0] = 0;
        int have = 1;
        while (have < M) {
            for (int i = 0; i < have; i++) {
                bits[have + i] = bits[i] + 1;
            }
            have *= 2;
        }

        int S = n - m + 1;
        int[][] f = new int[S][M];

        for (int i = 0; i < M; i++) {
            if (bits[i] <= q) {
                for (int t = 0; t < m; t++) {
                    if ((i & muls[t]) > 0) {
                        //f[0][i] += d[t];
                    }
                }
            }
        }

        for (int i = 1; i < S; i++)
            for (int j = 0; j < M; j++) {
                if (bits[j] <= q) {
                    int last = j << 1;
                    if (last >= M) {
                        last -= M;
                    }
                    int last2 = last | 1;
                    f[i][j] = Math.max(f[i - 1][last], f[i - 1][last2]);
                    if ((j & muls[m - 1]) > 0) {
                       // f[i][j] += d[i + m - 1];
                    }
                }
            }
        int max = f[S - 1][0];
        for (int i = 1; i < M; i++) {
            max = Math.max(max, f[S - 1][i]);
        }
        System.out.println(max);


    }
}
