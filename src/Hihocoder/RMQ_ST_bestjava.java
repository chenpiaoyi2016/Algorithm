package Hihocoder;

/**
 * Created by cpy on 2017/3/25.
 */

import java.io.*;

public class RMQ_ST_bestjava {
    static int maxn=1000005;
    static int min[]=new int[maxn<<2];
    static StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt()throws IOException {in.nextToken();return (int)in.nval;}

    public static String next()throws IOException {in.nextToken();return in.sval;}

    public static void buildTree(int l, int r, int rt)throws IOException
    {
        if(l==r) {min[rt]=nextInt();return;}

        int mid=(l+r)>>1;
        buildTree(l, mid, rt<<1);
        buildTree(mid+1, r, rt<<1|1);
        pushUp(rt);
    }

    public static void pushUp(int rt) {min[rt]=Math.min(min[rt<<1], min[rt<<1|1]);}

    public static int query(int L, int R, int l, int r, int rt)
    {
        if(L<=l && r<=R) return min[rt];

        int mid=(l+r)>>1, min=0xfffffff;
        if(L<=mid) {min=Math.min(min, query(L, R, l, mid, rt<<1));}
        if(R>mid) {min=Math.min(min, query(L, R, mid+1, r, rt<<1|1));}

        return min;
    }

    public static void main(String[] args)throws IOException
    {
        int n=nextInt();
        buildTree(1, n, 1);
        int m=nextInt(),a,b;
        while(m-->0)
        {
            a=nextInt();b=nextInt();
            out.println(query(a, b, 1, n, 1));
        }
        out.flush();
    }
}
