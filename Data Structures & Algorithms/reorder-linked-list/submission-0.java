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
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }
    public void reorderList(ListNode head) {
        
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        count=(count+1)>>1;
        curr=head;
        while(count>1){
            curr=curr.next;
            count--;
        }

        
        ListNode second=reverseList(curr.next);
        curr.next=null;
        ListNode first=head;
        
        while(first!=null&&second!=null){
            ListNode next=first.next;
            first.next=second;
            second=second.next;
            first.next.next=next;
            first=first.next.next;
        }
        
    }
}
