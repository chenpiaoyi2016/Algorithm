package BUPT;

import java.util.Scanner;

/**
 * Created by cpy on 2017/4/2.
 */
public class Floyed {
    int vertexSize=26;

    public void shortestPath_FLOYD() {
        int n = vertexSize;
        int[][] D = new int[n][n];//保存从i到j的最小路径值
        int[][] p = new int[n][n];//保存经过的中间节点

        for (int i = 0; i < n; i++) {//初始化D，p
            for (int j = 0; j < n; j++)
                p[i][j] = -1;
        }

        Scanner scanner=new Scanner(System.in);
        int cases=scanner.nextInt();
        for(int i=0; i<cases;i++) {
            String a = scanner.next();
            String b = scanner.next();
            if (a.length() != b.length()) {
                System.out.println("-1");
                continue;
            }

            int r = scanner.nextInt(); //rule个数

            scanner.nextLine();
            for ( int j=0;j<r; j++) {
                String s = scanner.nextLine();
                int temp1=(int)s.charAt(0)-65;
                int temp2=(int)s.charAt(2)-65;
                int temp3=Integer.valueOf( s.substring(4,s.length() ));



            }










        }

///////////////////////////////////////////////////////////////////////////////
        for (int x = 0; x < n; x++) {//进行Floyd算法，从0到n-1所有可能进行遍历
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][j] > D[i][x] + D[x][j]) {
                        D[i][j] = D[i][x] + D[x][j];
                        p[i][j] = p[i][x];
                    }
                }
            }
        }
        // 下面对获得的结果进行展示
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + D[i][j]);
            }
            System.out.println();
        }
        System.out.println("++++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + p[i][j]);
            }
            System.out.println();
        }
        System.out.println("+++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("输出i=" + i + "到j=" + j + "最短路径：");
                int k = p[i][j];
                if (k == -1) {
                    System.out.println("没有最短路径");
                } else {
                    System.out.print(" " + k);
                    while (k != j) {
                        k = p[k][j];
                        System.out.print(" " + k);
                    }
                    System.out.println(" "+k);
                    System.out.println();
                }
            }
        }
    }
}
