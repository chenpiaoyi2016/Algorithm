/**
 * Created by cpy on 2016/11/15.
 */
public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        if(height.length<=1) return 0;
        int low=0,high=height.length-1,max =0;
        while(low<high){
            max=Math.max( max, (high-low)*Math.min(height[low], height[high])     );
            if(height[low]>height[high])
                    high--;
            else
                low++;
        }
        return max;

    }


}
