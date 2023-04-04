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
    
    
	ListNode th=null;
    ListNode tt=null;
    
    public void addFirst(ListNode node)
    {
        if(th==null)
        {
            th=node;
            tt=node;
        }
        else
        {
            node.next=th;
            th=node;
        }
        
    }
    
    public ListNode reverseBetween(ListNode head, int n, int m) {
        
        if(head==null || head.next==null || m==n)
        {
            return head;
        }
        
        ListNode curr=head,prev=null;
        int idx=1;
        
        while(curr!=null)
        {
            while(idx>=n && idx<=m)
            {
                ListNode forw=curr.next;
                curr.next=null;
                addFirst(curr);
                curr=forw;
                idx++;
            }
            if(idx>m)
            {
                if(prev!=null)
                {
                    prev.next=th;
                    tt.next=curr;
                    return head;
                }
                else
                {
                    tt.next=curr;
                    return th;
                }
            }
            idx++;
            prev=curr;
            curr=curr.next;
            
            
            
        }
        
        return head;
        
    }
}