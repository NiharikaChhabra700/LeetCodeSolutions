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
    public ListNode partition(ListNode head, int x) {
        
        ListNode small=new ListNode(-1);
        ListNode big=new ListNode(-1);
        
        ListNode smallhead=small;
        ListNode bighead=big;
        
        ListNode curr=head;
        
        while(curr!=null)
        {
            if(curr.val<x)
            {
                smallhead.next=curr;
                smallhead=smallhead.next;
            }
            else
            {
                bighead.next=curr;
                bighead=bighead.next;
            
            }
            curr=curr.next;
        }
        
        bighead.next=null;
        smallhead.next=big.next;
        return small.next;
        
    }
}