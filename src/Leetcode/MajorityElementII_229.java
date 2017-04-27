package Leetcode; /**
 * Created by cpy on 2017/2/23.
 */

//Boyer-Moore Majority Vote algorithm  多数投票算法
import java.util.*;
public class MajorityElementII_229 {
    public static List<Integer> majorityElement_2(int[] nums, int k) {
        //大于三分之一的元素中最多两个  先找出出现次数最多的候选的2个元素 然后统计次数
        //  EXTEND TO K  GENERALIZATION
        HashMap<Integer,Integer> hash=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        List<Integer> cand=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(nums[i]))
                hash.put( nums[i], hash.get(nums[i])+1);
            else{
                if(hash.size()<k-1)
                    hash.put( nums[i],1);
                else {
                    for (int j : hash.keySet())
                        hash.put(j, hash.get(j) - 1);
                }
            }

            //移除0
            for( int j:hash.keySet()) {
                System.out.println(j+"->"+hash.get(j));
                if (hash.get(j) == 0) cand.add(j);
            }
            for( int j:cand)
                hash.remove(j);
            cand.clear();
            System.out.println("////////////////////////");
        }

        for( int j:hash.keySet()) {
            System.out.println(j);
            hash.put(j, 0);
        }

        for(int i=0;i<nums.length;i++)
            if(hash.containsKey(nums[i]))
                hash.put( nums[i], hash.get(nums[i])+1);

        System.out.println("----------------------------------------");
        for(  int i :hash.keySet())
            if (hash.get(i) > nums.length / k) {
                res.add(i);
                System.out.println(i);
            }

        return res;
    }




    public int  majorityElement_1(int[] nums) {
        //  > 一半的元素
        int candidate=-1, count=0;
        for(int i=0;i<nums.length; i++){
            if(count==0){
                candidate=nums[i];
                count=1;
            }
            else if( nums[i]== candidate)
                count++;
            else
                count--;
        }
        return candidate;//假设一定存在   count>0
    }
    public static void main(String args[]){
        int [] nums={0,3,4,0};
        majorityElement_2(nums,3);

    }

}
