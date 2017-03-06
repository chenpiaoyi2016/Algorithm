import java.util.*;

/**
 * Created by cpy on 2016/11/15.
 */
public class SumRootToLeafNumbers_129 {
    public int sumNumbers(TreeNode root) {
        int sum=0;
        String s="";
        return 0;
    }

    public static boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length() ; i++){
            char c=s.charAt(i);
            if( c=='(' || c=='[' || c=='{')
                stack.push(c);
            else{
                if(stack.size()<=0) {  return false;}
                char d=stack.pop();
                if( !( c==')'&&d=='(' ||  c=='}'&&d=='{' ||  c==']'&&d=='[' )   )
                    return false;
            }
        }

        return stack.size()== 0;


    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for( int i: nums )
                map.put(i,map.getOrDefault(i,0)+1 ); //java 8

        List<Integer> [] bucket =new List[nums.length+1];
        for( int key:map.keySet()){
            int f=map.get(key);
            if(bucket[f] ==null) bucket[f]=new LinkedList<>();
            bucket[f].add(key);
        }

        List<Integer> res=new ArrayList<>();
        for( int i=bucket.length-1; i>0&&k>0; --i){
            if(bucket[i]!=null){
                res.addAll(bucket[i]);
                k-=bucket[i].size();
            }
        }
        return res;
/*

        List<Integer> res = new LinkedList<>();
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i];
                res.addAll(list);
                k-= list.size();
            }
        }
*/



    }















    public  static void main(String[] args){
        System.out.println(isValid("()"));
    }


}

