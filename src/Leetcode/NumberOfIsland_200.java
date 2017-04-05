package Leetcode;

/**
 * Created by cpy on 2017/3/12.
 */
public class NumberOfIsland_200 {
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid[0].length==0)
            return 0;
        int x=grid.length,y=grid[0].length;// x每一列的长度=行数 y每一行长度=列数
        UnionFind uf=new UnionFind(x*y);
        boolean exist=false;
        int indexOf0=-1;
        for(int i=0;i<x;i++)
            for(int j=0;j<y; j++){
                if(grid[i][j]=='1' ){
                    if(j!=0) {
                        if (grid[i][j - 1] == '1')
                            uf.union(i * y + j, i * y + j - 1);
                    }

                    if(i!=0){ //不是第一行 可以和上面的比较
                        if(grid[i-1][j]=='1')
                            uf.union(i*y+j, i*y+j-y);
                    }

                }else if(grid[i][j]=='0'){
                    if(exist){
                        uf.union(indexOf0,i*y+ j );
                    }else{
                        indexOf0=i*y+ j;
                        exist=true;
                    }
                }
            }
        return exist? uf.countUnionOf1()-1: 1;

    }

    class UnionFind{
        private int[] list;

        public UnionFind(int n){
            list=new int[n];
            for(int i=0;i<n;i++) list[i]=i;
        }

        private int root(int i){ //找到表示
            while( list[i] !=i ) {
                list[i]=list[list[i]];//优化 下次会加快速度
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
        public int countUnionOf1(){ //仅仅适合用于200
            int[] count = new int[list.length];
            int cnt=0;
            for(int i=0;i<list.length;i++)
                count[root(i)]++;
            for(int i:count) {
                System.out.println(i);
                if (count[i] != 0)
                    cnt++;
            }
            System.out.println(cnt);
            return cnt;
        }
    }
}
