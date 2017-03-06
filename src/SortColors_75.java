/**
 * Created by cpy on 2016/11/20.
 */
public class SortColors_75 {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length<2) return;
        int left=0, right=nums.length-1;
        for(int i=0; i<=right; ){
            /**
             *   0 0 1 1 1 0 2 2 1 1 2 1 1 0 2 1 2
             */
            if (nums[i]==0) //i领先left时 left和i之间的肯定是1111 ，所以遇
                // 到0就和left位置的1交换，交换后的i位置肯定是1,所以i+1
                swap(nums, left++, i++);
            else if(nums[i]==2)//碰到2把i位置的2和右边未知的交换，重新while判定。right右边的全是2. 所以right-1
                swap(nums, i, right--);
            else
                i++;
        }
        //right1和left1中间置为1
    }
    private void swap(int[] a, int m, int n){
        a[m]=a[m]^a[n];
        a[n]=a[m]^a[n];
        a[m]=a[m]^a[n];
    }



}

