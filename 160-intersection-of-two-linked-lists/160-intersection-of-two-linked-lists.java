/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
      public int lenofll(ListNode head)
    {
        if(head==null)
        {
            return 0;
        }
        ListNode curr=head;
        int len=0;
        while(curr!=null)
        {
            curr=curr.next;
            len++;
        }
        
        return len;
    }
    
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null || headB==null)
        {
            return null;
        }
        
        int l1=lenofll(headA);
        int l2=lenofll(headB);
        
        ListNode biggerlist= l1>l2 ? headA :headB;
        ListNode smallerlist= l1>l2 ? headB : headA;
        
        int diff=Math.max(l1,l2)-Math.min(l1,l2);
        
        while(diff-->0)
        {
            biggerlist=biggerlist.next;
        }
        
        while(biggerlist!=smallerlist)
        {
           biggerlist=biggerlist.next;
           smallerlist=smallerlist.next;
            
        }
        
        return smallerlist;
        
    }
}