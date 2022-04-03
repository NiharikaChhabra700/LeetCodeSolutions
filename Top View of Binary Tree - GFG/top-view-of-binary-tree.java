// { Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    
    public static class verticalpair{
        Node node;
        int hl;
        
        verticalpair(Node node,int hl)
        {
            this.node=node;
            this.hl=hl;
        }
        
    }
    
    public static void minmax(Node root,int[] ans,int width)
    {
        if(root==null) return;
        
        ans[0]=Math.min(ans[0],width);
        ans[1]=Math.max(ans[1],width);
        
        minmax(root.left,ans,width-1);
        minmax(root.right,ans,width+1);
    }
    
    
    
    
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> sol=new ArrayList<>();
        int[] ans=new int[2];
        
        minmax(root,ans,0);
        
        int length=ans[1]-ans[0]+1;
        
        LinkedList<verticalpair> que=new LinkedList<>();
        
        for(int i=0;i<length;i++) sol.add(null);
        
        que.addLast(new verticalpair(root,-ans[0]) );
        
        while(que.size()!=0)
        {
            int size=que.size();
            
            while(size-->0)
            {
                verticalpair rp=que.removeFirst();
                
                Node node=rp.node;
                
                if(sol.get(rp.hl)==null) sol.set(rp.hl,node.data);
                
                if(node.left!=null)
                {
                    que.addLast(new verticalpair(node.left,rp.hl-1));
                }
                if(node.right!=null)
                {
                    que.addLast(new verticalpair(node.right,rp.hl+1));
                }
            }
        }
        
        return sol;
        
    }
}