// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}
// } Driver Code Ends


/*
Structure of node class is:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
     public Node mergeTwoLists(Node list1, Node list2) {
        
        Node dummy=new Node(-1);
        Node prev=dummy;
        
        Node c1=list1;
        Node c2=list2;
        
        while(c1!=null && c2!=null)
        {
            if(c1.data<=c2.data)
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
        
        //  Node temp=dummy.next;
        // while(temp!=null)
        // {
        //     System.out.println(temp.data);
        //     temp=temp.next;
        // }
        
        
        
        
        
        return dummy.next;
        
        
    }
    
    
    public Node reverse(Node head)
    {
        if(head==null || head.next==null) return head;
        
        Node prev=null;
        Node curr=head;
        
        while(curr!=null)
        {
            Node forw=curr.next;
            
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        
        return prev;
    }
    
   public Node sort(Node head){
        if(head==null || head.next==null) return head;
        
        Node small=new Node(-1);
        Node big=new Node(-1);
        
        Node smallhead=small;
        Node bighead=big;
        
        int count=0;
        
        Node curr=head;
        
        while(curr!=null)
        {
            if(count%2==0)
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
            count++;
        }
        
        smallhead.next=null;
        bighead.next=null;
        
        
         Node biglist=reverse(big.next);
        //  Node temp=biglist;
        // while(temp!=null)
        // {
        //     System.out.println(temp.data);
        //     temp=temp.next;
        // }
        
        
         
        
        return mergeTwoLists(small.next,biglist);
        
    
    
   }


}