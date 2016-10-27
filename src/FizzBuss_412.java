import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpy on 2016/10/26.
 */
public class FizzBuss_412 {
    public List<String> fizzBuzz(int n) {
        String s3="Fizz",s5="Buzz";
        List<String> list=new ArrayList<>() ;
        for(Integer i=1;i<=n;i++){
            if(i%3!=0 && i%5!=0){
                list.add( Integer.toString(i) );
            }else if (i%3==0 && i%5!=0){
                list.add(s3);
            }else if (i%3!=0 && i%5==0){
                list.add(s5);
            }else {
                list.add(s3+s5);
            }
        }
        return list;
    }

    public  static void main(String[] args){
        Integer i=1;
        System.out.println(i.toString());

    }
}
