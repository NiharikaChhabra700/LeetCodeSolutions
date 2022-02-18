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
    public ListNode oddEvenList(ListNode head) {
        
        ListNode even=new ListNode(-1);
        ListNode pe=even;
        
        ListNode odd=new ListNode(-1);
        ListNode po=odd;
        
        ListNode curr=head;
         int count=1;
        
        while(curr!=null)
        {
            if(count % 2 == 0)
            {
                pe.next=curr;
                pe=pe.next;
            }
            else
            {
                po.next=curr;
                po=po.next;
            }
            curr=curr.next;
            count++;
        }
        
        po.next=even.next;
        pe.next=null;
        
        return odd.next;
        
    }
}