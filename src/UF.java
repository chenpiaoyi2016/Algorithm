import java.util.Scanner;

/**
 * Created by cpy on 2016/11/7.
 */
public class UF {
    private int[] id; // 分量以触点为索引  第i个触点的分量号
    private int count;

    public UF(int N){ //初始化分量数组
        count =N;
        id=new int[N];
        for(int i=0; i<N; i++)
            id[i]= i;
    }

    public int  count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p)==find(q);
    }

    public int find(int p) {//对处于相同分量中的点 返回想他的整数值
        return id[p];
    }
    public void union(int p, int q) {
        int pid=find(p);
        int qid = find(q);
        if( pid== qid) return;
        for(int i=0; i<id.length; i++)
            if( id[i]==pid)
                id[i]=qid;

        count--;

    }
    public static void main( String[] args){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        UF uf=new UF(N);
        while( in.hasNext()){
            int p=in.nextInt();
            int q=in .nextInt();
            if(uf.connected(p,q)) continue;
            uf.union(p,q);
            System.out.println(p+" "+q);
        }
        System.out.println(uf.count() + "components");
    }
}
