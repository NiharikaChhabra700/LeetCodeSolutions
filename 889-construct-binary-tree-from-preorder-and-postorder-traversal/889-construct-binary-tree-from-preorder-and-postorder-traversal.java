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
    
    public TreeNode build(int[] preorder,int[] postorder,int psi,int pei,int ppsi,int ppei)
    {
        if(psi>pei) return null;
        
        int idx=ppsi;
        TreeNode root=new TreeNode(preorder[psi]);
        
        if(psi==pei) return root;
        
        while(postorder[idx]!=preorder[psi+1])
        {
            idx++;
        }
        
        int tnel=idx-ppsi+1;
        
        
        root.left=build(preorder,postorder,psi+1,psi+tnel,ppsi,idx);
        root.right=build(preorder,postorder,psi+tnel+1,pei,idx+1,ppei-1);
        
        return root;
        
    }
    
    
    
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        
        return build(preorder,postorder,0,n-1,0,n-1);
    }
}