/*
 * Created by cpy on 2016/11/9.
 */
import java.util.*;
public class Subsets {
/*
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(list, new ArrayList<Integer>(), nums,0);
        return list;
    }

    private void backtrace(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList)); //改变了引用？？
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrace(list, tempList, nums, i + 1);// 生成所有含nums[i]的字迹
            tempList.remove(tempList.size() - 1);  //不含nums[i]的子集
        }
    }
*/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        //Arrays.sort(nums);
        List<Integer> tp=new ArrayList<>();
        backtrace( list, tp, nums, 0);
        return list;
    }
    private void backtrace(List<List<Integer>> list, List<Integer> temp, int[] nums, int start){
        //list.add(temp);
        List<Integer> temp2=new ArrayList<>( temp);
        list.add(temp2);
        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            backtrace(list, temp, nums,i+1);// 生成所有含nums[i]的子集
            temp.remove( temp.size()-1 ); //不含nums[i]的子集
        }
    }





















}
