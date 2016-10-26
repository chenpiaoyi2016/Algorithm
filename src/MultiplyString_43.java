/**
 * Created by cpy on 2016/10/12.
 *
 * thought :  第i位和第j位相乘，得到两位数， 加到数组上
 */
public class MultiplyString_43 {
    public static String multiplyStr(String num1, String num2) {

        int n1=num1.length(),n2=num2.length();
        int[] pos=new int[n1+n2];

        for(int i=n1-1; i>=0;i--)
            for (int j=n2-1; j>=0;j--){
                int mul=(num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum= pos[i+j+1]+mul;

                pos[i+j+1]= sum%10;
                pos[i+j]+= sum/10;
            }
        //注释掉看看
        /*
        for(int k=n1+n2-1;k>=0;k--){
            if(pos[k]>=10){
                int tp= pos[k];
                pos[k]=tp%10;
                pos[k-1]+=tp/10;
            }
        }
*/
        /*
        for(int k=0;k<n1+n2;k++){
            System.out.println(pos[k]);
        }
        */

        StringBuilder sb=new StringBuilder();

        /*
        for(int k=0;k<n1+n2;k++){
            sb.append( pos[k]);
        }
        //9898 * 0 会 = 0000

         */



        for (int k=0;k<n1+n2;k++){
            if(sb.length()!=0 | pos[k]!=0  ){
                sb.append( pos[k]);
            }
        }

        String s = sb.toString();
        //这里要对“0”处理
        //第二个错 全是0.。。。

        s= s.length()==0? "0": s ;
        return s;
    }

    public static void main(String[] args){
        //String a="1234", b="56";
        String a="0", b="72";
        String c=multiplyStr(a,b);
        System.out.println(c);
        //subString(a,b) 从第a个数开始截取，到第b个。包括第a个，不包括第b个。长度b-a

        //为什么stringbuilder.append 不用是char


    }


}
