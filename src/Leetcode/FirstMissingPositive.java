package Leetcode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //先用快排思想把<=0的数移到后半边
        int k=partition( nums, 0, nums.length-1);
        int temp=0;
        int fmiss=k;
        for(int i=0; i<k;i++){
            temp=Math.abs(nums[i]);

        }

        return 0;

        /*int k=partition(A)+1;
        int temp=0;
        int first_missing_Index=k;
        for(int i=0;i<k;i++){
            temp=Math.abs(A[i]);
            if(temp<=k)
                A[temp-1]=(A[temp-1]<0)?A[temp-1]:-A[temp-1];
        }
        for(int i=0;i<k;i++){
            if(A[i]>0){
                first_missing_Index=i;
                break;
            }
        }
        return first_missing_Index+1;
        */

    }
    private static int partition(int[] a, int lo, int hi){
        int i=lo-1, j=hi+1;
        while( true ){
            while( a[--j] <=0  && i<j)
                if( i==hi) break;
            while( a[++i]>0 && i<j)
                if( j==lo) break;
            if(i>=j) break;
            exch(a, i, j);

        }
        while(a[i] <=0)
                i--;
        return i;
    }

    public static void main(String[] args){
        int[] a={ -1,0,2,0,3,-7,9,0,-2};
        int k=partition(a ,0,8  );
        System.out.println(k);
        System.out.println( "  ");

        for( int i=0; i<9;i++)
            System.out.println(a[i]);
    }

    private static void eaxch(int[] arr, int i, int j){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void exch(int A[] , int i, int j){
        if(i!=j){
            A[i]^=A[j];
            A[j]^=A[i];
            A[i]^=A[j];
        }
    }
}
