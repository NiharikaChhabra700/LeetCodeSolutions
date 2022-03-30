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
    public ListNode swapNodes(ListNode head, int k) {
        
        if(head==null || head.next==null) return head;
        
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        
        while(k-->0)
        {
            fast=fast.next;
        }
        ListNode m=fast;
        
        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        int temp=m.val;
        m.val=slow.val;
        slow.val=temp;
        
        return dummy.next;
        
        
    }
}