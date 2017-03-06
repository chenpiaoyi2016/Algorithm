package ThinkingInJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cpy on 2017/1/15.
 */
class Address{
    private String s;
    public Address(String s){this.s=s;}

    public String toString(){
        return super.toString()+" "+s;
    }
}

public class StringAddress {
    public static void main(String [] args){
        List<Address > list=new ArrayList<>( Collections.nCopies(6, new Address("hello")));
        System.out.println(list);
        Collections.fill(list ,new Address("cpy"));
        System.out.println(list);
    }


}
