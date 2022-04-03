/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int maxelement(TreeNode root)
    {
        TreeNode curr=root;
        TreeNode prev=curr;
        
        while(curr!=null)
        {
            prev=curr;
            curr=curr.right;
            
        }
        
        return prev.val;
    }
    
    
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null) return null;
        
        if(root.val<key)
        {
            root.right=deleteNode(root.right,key);
        }
        
        else if(root.val>key)
        {
            root.left=deleteNode(root.left,key);
        }
        
        else
        {
            if(root.left==null || root.right==null)
            {
                return root.left != null ? root.left : root.right; 
            }
            
            int maxele=maxelement(root.left);
            
            root.val=maxele;
            
            root.left=deleteNode(root.left,maxele);
        }
        
        return root;
    }
}