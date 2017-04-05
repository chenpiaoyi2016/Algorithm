package Leetcode;

/**
 * Created by cpy on 2016/11/15.
 */
public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0  ;
        while ( left< right ){
            max=Math.max( max, (right-left)*Math.min(height[left], height[right])    );
            if(height[left]>height[right])
                while( height[right]>=height[--right]);
            else
                while( height[left]>=height[++left] && left<right);
        }
        max=Math.max( max, (right-left)*Math.min(height[left], height[right])     );
        return max;
    }


}
