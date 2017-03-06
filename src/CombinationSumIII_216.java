
import java.util.*;

/**
 * Created by cpy on 2016/11/15.
 */
public class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res= new ArrayList<>();
        if( k<1 || n<1) return res;
        backtracking(res, new ArrayList<Integer>(), k, n ,1);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> list,int k, int n, int m){
        // 126 135 14 234               9  1.3.  k=1 n=3 m=4   133 223
        if( k==0 && n==0 )
            res.add(  new ArrayList<>(list));
        else if(k>0 && n>=m) {
            for( int i=m;i<=9;i++){
                if(n-i>= 0){
                    list.add(i);
                    backtracking(res, list, k-1,n-i, i+1);
                    list.remove(list.size()-1 );
                }
            }
        }
    }
    /**

     private void backtracking(List<List<Integer>> res, List<Integer> list,int k, int n, int m){

     if( k==0 && n==0 )
     res.add(  new ArrayList<>(list));
     else if(k>0 && n>=m) {
     for( int i=m;i<=9;i++){
     if(n-i>= 0){
     list.add(i);

     backtracking(res, list, k-1,n-i, m+1);
     list.remove(list.size()-1 );
     }
     }
     }

     }
     */
}
