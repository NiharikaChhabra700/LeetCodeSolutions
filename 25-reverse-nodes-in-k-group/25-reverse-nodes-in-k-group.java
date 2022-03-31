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
    
    public int length(ListNode head)
    {
        int len=0;
        
        while(head!=null)
        {
            head=head.next;
            len++;
        }
        
        return len;
    }
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null || head.next==null || k<1) return head;
        
        int len=length(head);
        ListNode curr=head;
        
        ListNode oh=null,ot=null;
        
        while(len>=k)
        {
            int tempk=k;
            while(tempk-->0)
            {
                ListNode forw=curr.next;
                
                curr.next=null;
                addFirst(curr);
                curr=forw;
            }
            
            if(oh==null)
            {
                oh=th;
                ot=tt;
            }
            else
            {
                ot.next=th;
                ot=tt;
            }
            
            len=len-k;
            th=null;
            tt=null;
        }
        
        ot.next=curr;
        
        return oh;
        
        
    }
}