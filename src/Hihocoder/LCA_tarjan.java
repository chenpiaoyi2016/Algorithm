package Hihocoder;

import java.util.*;

/**
 * Created by cpy on 2017/3/22.
 * hiho 1067
 *
 * 离线算法
 *
 * 先计算每个结点涉及到的询问，然后在深度优先搜索的过程中对结点染色，
 * 如果发现当前访问的结点是涉及到某个询问，看这个询问中另一个结点的颜色，
 * 如果是白色，则留待之后处理，如果是灰色，最近公共祖先必然就是这个灰色结点，
 * 如果是黑色，最近公共祖先就是这个黑色结点向上的第一个灰色结点。
 */
public class LCA_tarjan {
//    将一段时间内的询问收集起来统一处理，利用一些与询问个数无关的算法来进行计算
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, ListNodeOfPath> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String father = scanner.next();
            String child = scanner.next();


        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {

        }
        scanner.close();
    }

}

