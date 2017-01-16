/**
 * Created by cpy on 2016/11/10.
 */
import java.util.*;
public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res= new LinkedList<>();
        backtracking( res, "(", n );
        return res;
    }

    private void backtracking(List<String> res , String s, int n ){

        if(s.length() == 2*n && constraint(s, n))
                res.add(s);

        else
            if (constraint(s, n)) {
                backtracking(res, s + "(", n);
                backtracking(res, s + ")", n);
            }
    }


    private boolean constraint(String s ,int n){
        int flag=0,left=0,right=0;
        for (int i=0; i<s.length() ;i++){
            if(s.charAt(i)== '('){
                left++;
                flag++;
            }
            else if (s.charAt(i)==')') {
                right++;
                flag--;
            }
            if ( flag<0 || left>n || right >n) return false;
        }
            return true;
    }


    //人家的DFS
    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        generateOneByOne("", list, n, n);
        return list;
    }
    private void generateOneByOne(String sublist, List<String> list, int left, int right){
        if(left > right){
            return;
        }
        if(left > 0){
            generateOneByOne( sublist + "(" , list, left-1, right);
        }
        if(right > 0){
            generateOneByOne( sublist + ")" , list, left, right-1);
        }
        if(left == 0 && right == 0){
            list.add(sublist);
            return;
        }
    }







}
