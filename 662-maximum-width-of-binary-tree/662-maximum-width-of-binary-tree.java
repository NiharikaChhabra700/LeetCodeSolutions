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
    
    
    public class pair{
        TreeNode node=null;
        int idx=0;
        
        pair(TreeNode node,int idx)
        {
            this.node=node;
            this.idx=idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root==null) return 0;
        
        LinkedList<pair> que=new LinkedList<>();
        que.addLast(new pair(root,0));
        
        int max=0;
        
        while(que.size()!=0)
        {
            int size=que.size();
            int lm=que.getFirst().idx;
            int rm=que.getFirst().idx;
            
            while(size-->0)
            {
                pair rp=que.removeFirst();
                
                rm=rp.idx;
                
                if(rp.node.left!=null) que.addLast(new pair(rp.node.left,(rp.idx*2) + 1));
                if(rp.node.right!=null) que.addLast(new pair(rp.node.right,(rp.idx*2) +2));
            }
            
            max=Math.max(max,rm-lm+1);
        }
        
        
        return max;
        
    }
}