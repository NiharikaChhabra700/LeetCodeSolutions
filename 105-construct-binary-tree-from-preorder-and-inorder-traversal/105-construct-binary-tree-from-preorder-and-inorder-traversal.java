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
    
    public TreeNode build(int[] preorder,int[] inorder,int psi,int pei,int isi,int iei)
    {
        if(isi>iei) return null;
        
        int idx=isi;
        while(inorder[idx]!=preorder[psi])
        {
            idx++;
        }
        
        int len=idx-isi;
        
        TreeNode node=new TreeNode(inorder[idx]);
        
        node.left=build(preorder,inorder,psi+1,psi+len,isi,idx-1);
        node.right=build(preorder,inorder,psi+len+1,pei,idx+1,iei);
        
        return node;
    }
    
    
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int n=preorder.length;
        
        return build(preorder,inorder,0,n-1,0,n-1);
        
    }
}