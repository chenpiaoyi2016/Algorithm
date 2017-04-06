package Algorithm.Graph;

import java.util.ArrayList;

/**
 * Created by cpy on 2017/4/6.
 */
public class Graph {
    private  int V;
    private int E;
    private ArrayList<Integer>[] adj;//邻接表


    public void Graph(int v){
        this.V=v; this.E=0;
        adj=new ArrayList[V];//????????????

        for(int i=0;i<V;i++)
            adj[i]=new ArrayList<Integer>();
    }


    public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    public void addEghe(int v, int u){
        adj[v].add(u);
        adj[u].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){// 定点v相连的点
        return adj[v];
    }
    public  String toString(){
        String s=V+"vertices,"+E+"edges\n";
        for (int i=0;i<V;i++){
            s+=i+":";
            for(int j:this.adj[i]) //点i的相连的点
                s+=  j+" ";
            s+= "\n";
        }
        return s;
    }

}
