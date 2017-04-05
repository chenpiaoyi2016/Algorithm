package BUPT;
import java.util.*;
// ha
public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0; i<n;i++){
            String a=scanner.next();
            String b=scanner.next();
            if(a.length()!=b.length()){
                System.out.println("-1");
                continue;
            }

            int r=scanner.nextInt(); //rule个数


            HashMap<charPair, Integer> map=new HashMap<>();
            scanner.nextLine();
            for ( int j=0;j<r; j++) {
                String s = scanner.nextLine();
                map.put( new charPair(s.charAt(0),s.charAt(2)),
                        Integer.valueOf( s.substring(4,s.length() )) );
            }

            /////////////////pre calc
            int sum=0;
            int tp=0;
            //int
            for ( int j=0; j<a.length();j++){
                if( a.charAt(j)==b.charAt(j)) continue;
                if( map.containsKey( new charPair( a.charAt(j),b.charAt(j)) )){

                    tp=map.get( new charPair( a.charAt(j),b.charAt(j)) );
                }
                if( map.containsKey( new charPair( b.charAt(j),a.charAt(j)) )){
                    tp=Math.min( tp, map.get( new charPair( a.charAt(j),b.charAt(j)) ));
                }

// 无法解决 x-> a  y->a 的问题  失败

            }



        }


    }


}

class charPair{
    private char c;
    private char d;

    public charPair(char c, char d){
        this.c=c;
        this.d=d;
    }

}
