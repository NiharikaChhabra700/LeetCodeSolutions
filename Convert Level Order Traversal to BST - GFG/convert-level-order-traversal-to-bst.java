// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class GFG 
{
    //Function to construct the BST from its given level order traversal.
    
    public class pair{
        Node par=null;
        int lb=-(int)1e9;
        int rb=(int)1e9;
        
        pair(Node par,int lb,int rb)
        {
            this.par=par;
            this.lb=lb;
            this.rb=rb;
        }
        
        pair(){
            
        }
    }
    
    
    public Node constructBST(int[] arr)
    {
        
        LinkedList<pair> que=new LinkedList<>();
        que.addLast(new pair());
        
        Node root=null;
        int idx=0;
        
        while(que.size()!=0 && idx<arr.length)
        {
            pair rp=que.removeFirst();
            
            int ele=arr[idx];
            
            if(ele < rp.lb || ele > rp.rb) continue;
            
            Node node=new Node(ele);
            idx++;
            
            if(rp.par==null) root=node;
            else
            {
               Node par=rp.par;
               if(ele<=par.data)
               {
                   par.left=node;
               }
               else
               {
                   par.right=node;
               }
            }
            
            que.addLast(new pair(node,rp.lb,node.data));
            que.addLast(new pair(node,node.data,rp.rb));
            
            
        }
        
        return root;
        
    }
}