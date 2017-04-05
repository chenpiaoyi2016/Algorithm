package BUPT;

/**
 * Created by cpy on 2017/4/2.
 *
 1
 uayd
 uxxd
 3
 a x 8
 x y 13
 d c 3

 */


import java.util.Scanner;
public class Floyd {//H

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++){
            String s1 = sc.next();
            String s2 = sc.next();

            int n = sc.nextInt();
            int[][] pathWeight = new int[26][26];   //距离矩阵初始化为-1
            for (int l = 0; l < 26; l++) {
                for (int k = 0; k < 26; k++) {
                    pathWeight[l][k] = -1;
                }
            }


            for(int d=0;d<26;d++)pathWeight[d][d]=0;  //到自己的点初始化位0

            for (int j = 1; j <= n; j++) {
                int ch1 = sc.next().charAt(0) - 'a' ;//so....
                int ch2 = sc.next().charAt(0) - 'a' ;
                int w = sc.nextInt();

                if(pathWeight[ch1][ch2] ==-1 || pathWeight[ch1][ch2]>w)
                    pathWeight[ch1][ch2]=w;

            }
            //////////////////////以上完成初始化工作

            if(s1.length() == s2.length()) {//长度一样
                for (int k = 0; k < 26; k++) {  //Floyd算法的本质是DP，而k是DP的阶段，因此要写最外面
                    //  pathWeight[k][i][j] = 表示 i可以通过1、 2、。。。、K 到达j的最短路径
                    for (int x = 0; x < 26; x++) {
                        for (int y = 0; y < 26; y++) {
                            if (pathWeight[x][k] != -1 && pathWeight[k][y] != -1) {
                                if(pathWeight[x][y] == -1){
                                    pathWeight[x][y] = pathWeight[x][k] + pathWeight[k][y];
                                }
                                else{
                                    if (pathWeight[x][k] + pathWeight[k][y] < pathWeight[x][y]) {
                                        pathWeight[x][y] = pathWeight[x][k] + pathWeight[k][y];
                                    }
                                }
                            }
                        }
                    }
                }
//            for(int x = 0; x < 26; x++) {
//                for (int y = 0; y < 26; y++) {
//                    System.out.print(pathWeight[x][y] + " ");
//                }
//                System.out.println();
//            }
                long result = 0;
                for (int s = 0; s < s1.length(); s++) {
                    if (s1.charAt(s) != s2.charAt(s)) {
                        long now=-1;//??? why is long
                        for(int d=0;d<26;d++){
                            // here is the point

                            // 如果题目说a只能变换到b 不能经过中间点 就可以直接来
                            if(pathWeight[s1.charAt(s) - 'a'][d]==-1||pathWeight[s2.charAt(s) - 'a'][d]==-1)continue;
                            if(now==-1)now=pathWeight[s1.charAt(s) - 'a'][d]+pathWeight[s2.charAt(s) - 'a'][d];
                            else now=Math.min(pathWeight[s1.charAt(s) - 'a'][d]+pathWeight[s2.charAt(s) - 'a'][d],now);
                        }
                        if (now!=-1) {
                            result += now;
                        } else {//不可达
                            result = -1;
                            break;
                        }
                    }
                }
                System.out.println(result);
            }
            else{
                System.out.printf("%d%n", -1);
            }
        }

    }
}


