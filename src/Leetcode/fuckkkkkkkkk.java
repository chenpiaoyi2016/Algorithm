package Leetcode;

/**
 * Created by cpy on 2016/12/1.
 */
public class fuckkkkkkkkk {
    public static void reorderList(ListNode head) {
        if(head==null ||head.next==null || head.next.next==null) return ;
        int len=0 , index ;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        ListNode head2=head, cur1=head, cur2=null ,next1, next2, tail=null;
        if(len%2==0) index=len/2;
        else index=len/2+1;

        for(int i=1;i<=index;i++){
            tail=head2;
            head2=head2.next;
        }

        if(tail!=null)  tail.next=null;


        ListNode newHead=null,next=null;
        while(head2!=null){
            next=head2.next;
            head2.next=newHead;
            newHead=head2;
            head2=next;
        }
        head2=newHead;

        int n=len/2;
        cur2=head2;
/*
        Leetcode.ListNodeOfPath aaa=cur1,bbb=cur2;
        while(aaa!=null ){
            System.out.println(aaa.val);
            aaa=aaa.next;
        }

        while(bbb!=null ){
            System.out.println(bbb.val);
            bbb=bbb.next;
        }
*/
        for(int i=1; i<=n; i++){
           // System.out.println(cur1.val);
            //System.out.println(cur2.val);
            next1=cur1.next;
            next2=cur2.next;

            cur1.next=cur2;
            cur2.next=next1;

            cur1=next1;
            cur2=next2;
        }

        //  1-2  4-3   1-4-2 3
        ListNode ccc=head;
        while(ccc!=null ){
            System.out.println(ccc.val);
            ccc=ccc.next;
        }

    }

    public  static void main(String[] args){
        ListNode head=new ListNode(1);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(3);
        ListNode head4=new ListNode(4);
        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=null;
        reorderList(head);

    }
}
