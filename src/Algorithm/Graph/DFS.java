package Algorithm.Graph;

/**
 * Created by cpy on 2017/4/6.
 */
public class DFS {
    private boolean mark[];
    private int count;
    public DFS(Graph g, int target){
        mark=new boolean[g.V()];
        dfs(g,target);
    }
    private void dfs(Graph g ,int target){
        mark[target]=true;
        count++;
        for(int vertice:g.adj(target))
            if(!mark[vertice])
                dfs(g, vertice);
    }

    public boolean getMark(int i){
        return mark[i];
    }
    public int count(){return count;}
}
