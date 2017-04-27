package Leetcode;

/**
 * Created by cpy on 2017/2/27.
 */
public class MedianOfTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
// the median is used for dividing a set into two equal length subsets,
// that one subset is always greater than the other
        int m=nums1.length,  n=nums2.length;// need n>=m
        if( m>n)  return findMedianSortedArrays(nums2, nums1);

        int  imin=0, imax=m,i=0, j=0,mid=(m+n+1)/2;
        int x=0,y=0;
        while(imin<=imax){
            i=( imin+imax)/2;
            j=(m+n+1)/2;
            if( i<m && j>0 && nums2[j-1] > nums1[i]  )
                imin= i+1;
            else if ( i>0 && j<m && nums1[i-1]>nums2[j])
                imax=i-1;
            else{
                if( i==0) x=nums2[j-1];
                else if( j==0 ) x=nums1[i-1];
                else x=Math.max(nums1[i-1],  nums2[j-1]);
                break;

            }


        }
        if ( (m + n)%2==1) return x;

        if(i==m) y=nums2[j];
        else if(j==n) y=nums1[i];
        else  y=Math.min(nums1[i], nums2[j]);

        return (x+y)/2;
        /*

    int minidx = 0, maxidx = m, i, j, num1, mid = (m + n + 1) >> 1,num2;
    while (minidx <= maxidx)
    {
      i = (minidx + maxidx) >> 1;
      j = mid - i;
      if (i<m && j>0 && B[j-1] > A[i]) minidx = i + 1;
      else if (i>0 && j<n && B[j] < A[i-1]) maxidx = i - 1;
      else
      {
        if (i == 0) num1 = B[j-1];
        else if (j == 0) num1 = A[i - 1];
        else num1 = max(A[i-1],B[j-1]);
        break;
      }
    }
    if (((m + n) & 1)) return num1;
    if (i == m) num2 = B[j];
    else if (j == n) num2 = A[i];
    else num2 = min(A[i],B[j]);
    return (num1 + num2) / 2.;
        */
    }
}
