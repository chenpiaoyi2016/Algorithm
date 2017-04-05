package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpy on 2016/10/12.
 */

/*
thought: array list ?
 */
public class Permutations_46 {


    public List<List<Integer>> mypermute(int[] num) {
        List<List<Integer>> res=new ArrayList<>() ;
        backtracking(res,num, new ArrayList<Integer>() , 0);
        return res;

    }


    private void backtracking3(List<List<Integer>> res, int[] nums, List<Integer> list ,int t ){
        if(list.size()== nums.length)
            res.add(new ArrayList<>(list));

        else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]); //list的引用副本改变 原来的不变
                backtracking(res, nums, list, t + 1);
                list.remove(t);
            }
        }
    }


    private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> list ,int t ){
        if(list.size()== nums.length) {
            //res.add(list);
            //上一行代码是错误的： 从头到尾都是操作这个引用句柄，同一个句柄。
            // 正确的做法是：   新建一个对象，里面的值和原来的一样。
            //res.add(new ArrayList<>(list));

            //List<Integer> li=new ArrayList<>(list) ;
            List<Integer> li=list;
            List<Integer> li3=li;
            res.add(li3);
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]); //list的引用副本改变 原来的不变
                backtracking(res, nums, list, t + 1);
                list.remove(t);
            }
        }
    }

//  i=t+1开始呢。。









    public static List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length ==0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i< num.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
            for (int j = 0; j<=i; ++j){
                for (List<Integer> l : ans){
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j,num[i]);
                    new_ans.add(new_l);
                }
            }
            ans = new_ans;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr= {1,2,3,4};
        List<List<Integer>> li=permute2(arr);


    }



}

