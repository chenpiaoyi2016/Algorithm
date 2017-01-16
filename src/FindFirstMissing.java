public class FindFirstMissing {
    public static int firstMissingPositive(int[] nums) {

        // 对于有重复的数组比如 7812254377  找出的数字不对 1243527877

        if (nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != i+1) {
                if (nums[nums[i]-1] != nums[i]) {
                    swap(nums, i,nums[i]-1 );
        		        /*
            			int tmp = A[A[i]-1];
            			A[A[i]-1] = A[i];
            			A[i] = tmp;
            			*/
                    i--; //important//////交换完之后，再从这个i开始
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
    private static void swap(int[] a,int i,int j){
        if(a[i]!=a[j]){
            a[i]^=a[j];
            a[j]^=a[i];
            a[i]^=a[j];
        }
    }

    public static void main(String[] args){
        int[] a={ 7,8,1,2,2,5,4,3,7,7};
        int k=firstMissingPositive(a);
        System.out.print(k);
    }
}