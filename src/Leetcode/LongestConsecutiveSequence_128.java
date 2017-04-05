package Leetcode;

import java.util.*;

/**
 * Created by cpy on 2017/3/8.
 */
public class LongestConsecutiveSequence_128 {
    /**
     * Given an unsorted array of integers,
     * find the length of the longest consecutive elements sequence.

     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

     Your algorithm should run in O(n) complexity.
     */

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 hehe=new LongestConsecutiveSequence_128();
        int[] array={1,7,2,9,3,8,4,5,10,11,13,12};
        System.out.print(  hehe.longestConsecutive(array));
    }

    public  int longestConsecutive(int[] nums) {

        UF_ConpressPathWeightedQuickUnion uf = new UF_ConpressPathWeightedQuickUnion(nums.length);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                continue;

            map.put(nums[i],i);
            if(map.containsKey(nums[i]+1))
                uf.union(i,map.get(nums[i]+1));

            if(map.containsKey(nums[i]-1))
                uf.union(i,map.get(nums[i]-1));

        }
        return uf.maxUnion();
    }


    class UF_ConpressPathWeightedQuickUnion {
        private int[] id; // 分量以触点为索引  第i个触点的分量号
        private int[] size; // 节点对应分量大小
        private int count;

        public UF_ConpressPathWeightedQuickUnion(int N) { //初始化分量数组
            count = N;
            id = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++)
                id[i] = i;
            Arrays.fill(size, 1);

        }

        public int count() {
            return count;
        }
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int find(int p) {
            int copy = p, p2=p;
            while (p2 != id[p2])
                p2 = id[p2];
            //此时p为root
            // 路径压缩
            int temp;
            while (copy != p2) {
                temp = id[copy];
                id[copy] = p2;
                copy = temp;
            }
            return p2;
        }

        public void union(int p, int q) {
            int pRoot = find(p), qRoot = find(q);
            if (pRoot == qRoot)
                return;
            //把小数的根节点连接到大数的根节点
            if (size[pRoot] > size[qRoot]) {
                id[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                id[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
            count--;
        }

        public int maxUnion() {
            int max = -1;
            for (int i = 0; i < size.length; i++)
                max = Math.max(max, size[i]);
            return max;
        }
    }
















    class UnionFind{
        private int[] list;
        public UnionFind(int n){
            list=new int[n];
            for(int i=0;i<n;i++) list[i]=i;
        }

        private int root(int i){ //找到表示
            while( list[i] !=i ) {
                list[i]=list[list[i]];//优化 下次会加快速度  beat  4%  -> 27%
                i = list[i];
            }
            return i;
        }

        private boolean isConnected(int i, int j){
            return root(i)==root(j);
        }

        public void  union(int i, int j){
            list[root(i)] = list[root(j)];
        }
        public int maxUnion(){
            int[] count = new int[list.length];
            int max = 0;
            for(int i=0;i<list.length;i++){
                count[root(i)]++;
                max=Math.max(count[root(i)],max);
            }
            return max;
        }
    }

    public int longestConsecutive2(int[] nums) { //use  Set
        int max = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        //use O(n)
// 为什么使用这些容器 它的特殊方法就能让不需要排序查找地 降低时间复杂度。。。看看源码吧。。

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            // look left
            int num = nums[i];
            while (set.contains(--num)) {
                count++;
                set.remove(num);    //  important!!!!!!!!!!!!!!!!!
            }
            // look right
            num = nums[i];
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }
            set.remove(nums[i]); //不可以，nums[i] 可能在之前轮次的操作中被移除
            max = Math.max(max, count);
        }
        return max;
    }

    public int highestVoted(int[] nums){
        int res=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int n:nums){
            if( map.containsKey(n) ==false){
                int left= map.containsKey(n-1)?map.get(n-1):0;
                int right=map.containsKey(n+1)? map.get(n+1):0;
                int sum= left+right+1;
                map.put(n,sum);
                //   3-4  5   6-7-8
                //sum=2+1+3=6
                res= Math.max(res,sum);
                map.put(n-left,sum);
                map.put(n+right, sum);
            }
            else continue;
        }
        return res;
    }
}
