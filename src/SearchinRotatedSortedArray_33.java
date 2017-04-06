/**
 * Created by cpy on 2017/2/24.
 */
public class SearchinRotatedSortedArray_33 {
    public static int search(int[] nums, int target) {
        if(nums.length<1)return -1;
        int start=0, end=nums.length-1;
        int mid=start+(end-start)/2;
        while( start<end-1  && nums[start]>nums[end]){//

            System.out.println(start+"---"+mid+"---"+end);

            if(nums[mid]==target)
                return mid;

            else if( nums[mid]<target ){
                if(target<nums[start])
                    start=mid+1;
                else if( nums[mid]  > nums[start])
                    start=mid+1;
                else
                    end=mid-1;
            }
            else{// mid>目标
                if(target  > nums[start]   )
                    end=mid-1;
                else if(target  == nums[start])
                    return  start;
                else if( nums[start] >nums[mid])
                    end= mid-1;
                else //if(  nums[mid] <nums[start])
                    start=mid+1;
                //else
                //    end=mid-1;

            }
            mid=start+(end-start)/2;
        }

        if( start>=end-1){
            if(target==nums[start])return start;
            else if(target==nums[end])  return  end;
            else return -1;

        }
        while( start<end){
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]> target)
                end=mid-1;
            else
                start=mid+1;
            mid=start+(end-start)/2;
        }

        if(nums[start]==target)return start;
        return -1;
    }
    public static void main(String args[]){
        //int [] a={5,1,3};
        int [] a={5,1,2,3,4};
        int i=search(a,1);
        System.out.println(i);
    }


}
