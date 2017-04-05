package Leetcode;

import java.util.*;

/*
  Created by cpy on 2016/11/7.

  thought :
    考虑到时间复杂度必然大于等于nlog2n 所以先sort
    3种情况
    从0最小数字到-1
 */
public class ThreeSum_15 {
    //beat 4%..................................................no
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) return res;

        for (int i = 0; i < nums.length - 2; i++) { //要过滤掉重复的
            if (nums[i] > 0) break; //优化
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {//
                if (map.containsValue(0 - nums[i] - nums[j])) {
                    if (!res.contains(Arrays.asList(nums[i], nums[j], 0 - nums[i] - nums[j])))
                        res.add(Arrays.asList(nums[i], nums[j], 0 - nums[i] - nums[j]));
                } else {
                    map.put(j, nums[j]);
                }
            }
            while (nums[i] == nums[i + 1] && i + 1 < nums.length - 2)
                i++;
        }
        return res;
    }


    public List<List<Integer>> threeSumByOthers(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if (sum <= 0) while (nums[j] == nums[++j] && j < k) ;
                if (sum >= 0) while (nums[k--] == nums[k] && j < k) ;
            }
            while (nums[i] == nums[++i] && i < nums.length - 2) ;
        }
        return result;
    }

    public List<List<Integer>> myImproveThreeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) return res;
        for (int i = 0; i < nums.length - 2; i++) { //要过滤掉重复的
            if (nums[i] > 0) break; //优化
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0)
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(j+1<k) j++;
                if (sum <= 0){
                    j++;
                    while (nums[j ] == nums[j-1] && j < k) j++;
                }
                if (sum >= 0) {
                    k--;
                    while (nums[k] == nums[k+1] && j < k) k--;
                }
            }
            while (nums[i] == nums[i + 1] && i + 1 < nums.length - 2)
                i++;
        }
        return res;
    }

}
