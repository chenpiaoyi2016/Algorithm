/**
 * Created by cpy on 2016/10/26.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res=0 ;
        for (int i:nums)
            res ^= i;
        return res;



    }
}
