package Hihocoder;

import java.util.Scanner;

/**
 * Created by cpy on 2017/3/27.
 */
/*
对于100%的数据，满足
N<=10^6， Q<=10^6,
1<=Li<=Ri<=N，1<=Pi<=N,
0<weight_i, Wi<=10^4。

10
3655 5246 8991 5933 7474 7603 6098 6654 2414 884
6
0 4 9
0 2 10
1 4 7009
0 5 6
1 3 7949
1 3 1227

样例输出
2414
884
7474
 */
public class RMQ_SegmentTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n+1];

        for (int i=1; i<=n;i++)
            nums[i]=in.nextInt();
        STNode root=buildST( nums);

        int m=in.nextInt();
        for(int i=0;i<m;i++){
            if( in.nextInt()==0 ) {
                // query
                int left = in.nextInt();
                int right = in.nextInt();
                System.out.println( queryST(root, left,right));
            }else{
                // adjust
                int index=in.nextInt();
                int val=in.nextInt();
                adjust(root,index,val );
            }
        }
        in.close();
    }

    private static STNode buildST(int[] nums){
        return buildingST(nums, 1, nums.length-1);
    }
    private static STNode buildingST(int[] nums, int left,int right){
        if( left==right)
            return new STNode( nums[left], left);
        else if( left<right){
            int mid=left+ ( (right-left)>>1 );
            STNode root=new STNode( nums[mid], mid); //??????????
            root.left=buildingST( nums,left, mid-1);
            root.right=buildingST(nums, mid+1, right);
            return root;
        }
        else
            return null;


    }


    private static int queryST(STNode root, int left, int right){
        if (root == null)
            return Integer.MAX_VALUE;

        if(root.index<left)
            return queryST(root.right, left, right);
        else if(root.index>right)
            return queryST(root.left,left,right);
        else if(left==right)// 在这里 left=right=root.index
                return root.val;
        else
            return Math.min(root.val, Math.min(queryST(root.left, left, root.index-1),
                    queryST(root.right, root.index+1, right)));

    }

    private static void adjust(STNode root,int index, int val ){
        if(root.index==index)
            root.val=val;
        else if(root.index <index)
            adjust( root.right, index, val);
        else
            adjust(root.left, index, val);
    }
}

class STNode{
    int val;

    int index;
    //index 为在nums中的位置
    STNode left, right;
    public STNode(int val, int index ){
        this.val=val;
        this.index=index;
        this.left=null;
        this.right=null;
    }
}
