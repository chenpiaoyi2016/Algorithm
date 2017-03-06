/**
 * Created by cpy on 2016/11/15.
 */
public class SortedArraytoBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0 ||nums==null)
            return null;
        return DFS(nums, -1, nums.length);
        }

    private TreeNode DFS(int[] nums, int low, int high){
        if(low>high) return null;

        int mid=(low+high)/2;

        TreeNode t1=new TreeNode( nums[mid]);
        t1.left=DFS(nums, low, mid-1);
        t1.right=DFS(nums, mid+1, high);
        return t1;
    }


}
