/**
 * Created by cpy on 2016/10/26.
 */
public class SingleNumberII_137 {
    public static int singleNumber(int[] nums) {
        //int类型4字节 32bit  每一位之间操作

        int res =0;
        int l=nums.length;
        for(int i=0; i<32;i++){
            int sum=0;
            for (int j=0; j<l;j++)
                //第i位的二进制数相加mod3//sum=sum+ (nums[j]>>i)&1; //???????????
                if (  ((nums[j]>>i)&1) ==1 )
                    sum++;
            /*
            for (int j :nums)
                if (  ((j>>i)&1) ==1 )
                    sum++;
            */

            sum=sum%3;
            if(sum==1)
                res= res | (1<<i);  //res第i位置为sum
        }
        return res;
    }

    //public static int singleNumber2(int[] nums){ //map

    //}
    public static void main(String[] args){
        int[] nums= {1,2,4,2,4,3,4,1,1,2};
        int a= singleNumber(nums);
        System.out.print(a);
    }
}
