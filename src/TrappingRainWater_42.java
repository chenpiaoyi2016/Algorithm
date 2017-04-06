/**
 * Created by cpy on 2017/3/1.
 */
public class TrappingRainWater_42 {
    public int trap(int[] height) {
//从left 和right中小的开始向中间移动 加上目前与leftmax或者 rightma的差。  每次比较的是左右边max小的

        Object A=new Object();


        int left=0, right=height.length, res=0,max_left=0, max_right=0;

        while(left<=right){
            if(max_left<=max_right){
                if(height[left]>=max_left)
                    max_left=height[left++];
                else
                    res+= max_left-height[left++];
            }
            else {
                if(height[right] >=max_right)
                    max_right=height[right--];
                else
                    res+= max_right-height[right--];
            }
        }
        return res;
    }

}
