// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class Driver_code
{
    static Node insert(Node head, int data)
    {
        Node temp = new Node(data);
        if(head == null)
        {
          head = temp;
          return head;
        }
        else{
                Node t = head;
            while(t.next != null)
            {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }
    
    static void printList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        
    }
   public static void main (String[] args)throws IOException {
       BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(read.readLine());
       
       while(t-- > 0)
       {
           int listSize = Integer.parseInt(read.readLine());
           String str[] = read.readLine().trim().split(" ");
           
           int m = Integer.parseInt(str[0]);
           int n = Integer.parseInt(str[1]);
           
           Node head = null;
           str = read.readLine().trim().split(" ");
           for(int i = 0; i < listSize; i++)
           {
               head = insert(head, Integer.parseInt(str[i]));
           }
          new Solution().linkdelete(head, m, n); 
          printList(head); 
          System.out.println();
       }
   } 
}

// } Driver Code Ends


//User function Template for Java

/*
delete n nodes after m nodes
The input list will have at least one element  
Node is defined as
  class Node
  {
      int data;
      Node next;
      Node(int data)
      {
          this.data = data;
          this.next = null;
      }
  }
*/

class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
       Node curr=head;
       int count=0;
       
       while(curr!=null && curr.next!=null)
       {
           count++;
           if(count==M)
           {
               int x=N;
               while(x-->0)
               {
                   curr.next=curr.next.next;  //delete one node
                   
                   if(curr.next==null) return;
                   
               }
               
               count=0;
               
           }
           curr=curr.next;
       }
    
    }
}


