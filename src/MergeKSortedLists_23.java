
import java.util.*;

/**
 * Created by cpy on 2016/12/3.
 */
public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val<o2.val) return -1;
                else if( o1.val == o2.val) return 0;
                else return 1;
            }
        });

        ListNode dummy = new ListNode(0), tail=dummy;

        for( ListNode node:lists)   //都加到队列中
            if(node != null) queue.add(node);

        while (!queue.isEmpty()){   // 队列头是最小的 提取出来
            tail.next=queue.poll();
            tail=tail.next;
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }


    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map=new HashMap<>();
        RandomListNode cur=head;
        while(cur!=null){
            map.put(cur, new RandomListNode(cur.label));
            cur=cur.next;
        }

        cur=head;
        while( cur!=null){
            //map.get(cur).next= cur.next; //错误！！ 要指向新的节点而不是旧的
            //map.get(cur).random=cur.random;
            map.get(cur).next=map.get( cur.next);
            map.get(cur).random=map.get( cur.random);
            cur=cur.next;
        }
        return map.get(head);



    }

    private static int Findfirst(int[] nums,int t) {
        int start=0, end=nums.length-1;
        while(start<end){
            int mid=start+ (end-start)/2;
            if(nums[mid] > t ){
                end=mid-1;
            }else if(nums[mid] <t){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        if( nums[start]==t)
            return start;
        return -1;
    }

    private static int findLast(int[] nums,int t) {
        int start=0, end=nums.length-1;
        while(start<end-1){
            int mid=start+ (end-start)/2;
            if(nums[mid] > t ){
                end=mid-1;
            }else if(nums[mid] <t){
                start=mid+1;
            }else
                start=mid;

        }
        if( nums[end]==t)
            return end;
        else if(nums[start]==t)
            return start;
        return -1;
    }

    public static void main(String[] args){
        int[] nums={0,1,1,1,2,3,3};
        System.out.print( findLast(nums,2) );

    }



}


class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
};
