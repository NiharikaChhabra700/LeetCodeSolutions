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
    public ListNode middle(ListNode head) {
        
        
        
        if(head==null || head.next==null)
        {
            return head;
        }
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
        
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        
        ListNode c1=list1;
        ListNode c2=list2;
        
        while(c1!=null && c2!=null)
        {
            if(c1.val<=c2.val)
            {
                prev.next=c1;
                c1=c1.next;
            }
            else
            {
                prev.next=c2;
                c2=c2.next;
            }
            
            prev=prev.next;
        }
        
        prev.next= (c1 != null) ? c1 : c2;
        
        
        return dummy.next;
        
        
    }
    
    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next==null)
        {
            return head;
        }
        
        ListNode middleNode=middle(head);
        ListNode nhead=middleNode.next;
        middleNode.next=null;
        
        return mergeTwoLists(sortList(head),sortList(nhead));
        
    }
}