/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null&&n==1){
            return null;
        }
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        count=count-n;
        curr=head;
        while(count>1){
            curr=curr.next;
            count--;
        }
        if(count==0){
            ListNode ans=head.next;
            head.next=null;
            head=ans;
            return head;
        }
        ListNode next=curr.next.next;
        curr.next=next;
        return head;


    }
}
