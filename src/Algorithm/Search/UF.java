package Algorithm.Search;

import java.util.Arrays;
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
//        int pid=find(p);
//        int qid = find(q);
//        if( pid== qid) return;
//        for(int i=0; i<id.length; i++)
//            if( id[i]==pid)
//                id[i]=qid;
//
//        count--;
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

/**
 加权quickUnion算法
 任意节点的深度最多是 lg(n)
 对于n个触点和m条连接 最多是  c * m * lg(n) 次
 */
class UF_weightedQuickUnion {
    private int[] id; // 分量以触点为索引  第i个触点的分量号
    private int[] size; // 节点对应分量大小
    private int count;

    public UF_weightedQuickUnion(int N){ //初始化分量数组
        count =N;
        id=new int[N];
        size=new int[N];
        for(int i=0; i<N; i++)
            id[i] = i;
        Arrays.fill(size,1);
    }
    public int count(){
        return count;
    }
    public boolean connected(int p, int q){
        return find(p)==find(q);
    }

    public int find(int p) {
        while( p!=id[p])
            p=id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot=find(p), qRoot=find(q);
        if(pRoot==qRoot) return;
        //把小数的根节点连接到大数的根节点
        if( size[pRoot]>size[qRoot]) {
            id[qRoot]=pRoot;
            size[pRoot]+=size[qRoot];
        }else {
            id[pRoot]=qRoot;
            size[qRoot]+=size[pRoot];
        }
        count--;
    }
}

class UF_quickUnion {
    //大多数情况下比quickFind快 最差情况下也是平方级别
    private int[] id; // 分量以触点为索引  第i个触点的分量号
    private int count;

    public UF_quickUnion(int N){ //初始化分量数组
        count =N;
        id=new int[N];
        for(int i=0; i<N; i++)
            id[i]= i;
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p)==find(q);
    }

    public int find(int p) {   //*************

        while( p!=id[p])
            p=id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot=find(p), qRoot=find(q);
        if(pRoot==qRoot) return;
        id[pRoot]=qRoot;         //////////////////////////***
        count--;
    }
}


class UF_quickFind {
//    无法处理大型问题 对于每一组union操作，都要扫描整个数组
    private int[] id; // 分量以触点为索引  第i个触点的分量号
    private int count;

    public UF_quickFind(int N){ //初始化分量数组
        count =N;
        id=new int[N];
        for(int i=0; i<N; i++)
            id[i]= i;
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p)==find(q);
    }

    public int find(int p) {    //对处于相同分量中的点 返回想他的整数值
        return id[p];
    }

    public void union(int p, int q) {
        //(n+3)->(2n+1)
        //quickFind算法对于最终只能得到少数分量的一般应用是平方级别的  O（n*n）
        int pid=find(p);
        int qid = find(q);
        if( pid== qid) return;
        //两个联通分量中所有值置为相同 后者
        for(int i=0; i<id.length; i++)
            if( id[i]==pid)
                id[i]=qid;
        count--;
    }
}

class UF_ConpressPathWeightedQuickUnion {
    private int[] id; // 分量以触点为索引  第i个触点的分量号
    private int[] size; // 节点对应分量大小
    private int count;

    public UF_ConpressPathWeightedQuickUnion(int N){ //初始化分量数组
        count =N;
        id=new int[N];
        size=new int[N];
        for(int i=0; i<N; i++)
            id[i] = i;
        Arrays.fill(size,1);
    }
    public int count(){
        return count;
    }
    public boolean connected(int p, int q){
        return find(p)==find(q);
    }

    public int find(int p) {

        int copy=p;
        while( p!=id[p])
            p = id[p];
        //此时p为root、

        // 路径压缩
        int temp;
        while( copy!= id[copy]){
            temp=id[copy];
            id[copy]= p;
            copy=temp;
        }

        return p;
    }

    public void union(int p, int q) {
        int pRoot=find(p), qRoot=find(q);
        if(pRoot==qRoot) return;
        //把小数的根节点连接到大数的根节点
        if( size[pRoot]>size[qRoot]) {
            id[qRoot]=pRoot;
            size[pRoot]+=size[qRoot];

        }else {
            id[pRoot]=qRoot;
            size[qRoot]+=size[pRoot];
        }
        count--;
    }
}