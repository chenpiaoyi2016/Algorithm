package Hihocoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
/**
 * Created by cpy on 2017/4/6.
 */
public class ShortestPath_SPFA {
        //  Shortest Path Faster Algorithm----队列优化 可以处理负边 不能处理负环
    //执行该算法前做一次拓扑排序，以判断是否存在负权回路，但这不是我们讨论的重点
        static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt(), m = in.nextInt(), s = in.nextInt() - 1, t = in
                .nextInt() - 1;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 0; i < n; i++)
            map.put(i, new HashMap<Integer, Integer>());
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1, v = in.nextInt() - 1, l = in.nextInt();
            int p = map.get(u).containsKey(v) ? Math.min(map.get(u).get(v), l)
                    : l;
            map.get(u).put(v, p);
            map.get(v).put(u, p);
        }

        SPFA spfa = new SPFA(map, s);
        System.out.println(spfa.get(t));
    }
}


class SPFA {
    Map<Integer, Map<Integer, Integer>> map;
    int s;
    int d[];
    boolean inQ[];

    public SPFA(Map<Integer, Map<Integer, Integer>> map, int s) {
        this.map = map;
        this.s = s;
        d = new int[map.size()];
        Arrays.fill(d, -1);
        inQ = new boolean[map.size()];
        calc();
    }

    private void calc() {
        d[s] = 0;
        inQ[s] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            inQ[u] = false;
            for (int v : map.get(u).keySet()) {
                int len = map.get(u).get(v);
                if (d[v] == -1 || d[v] > d[u] + len) {
                    d[v] = d[u] + len;
                    // If there is no negative cycle in the graph, a point which
                    // has been removed from the queue will never be added back
                    if (!inQ[v]) {
                        inQ[v] = true;
                        queue.add(v);
                    }
                }
            }
        }
    }

    public int get(int t) {
        return d[t];
    }
}

