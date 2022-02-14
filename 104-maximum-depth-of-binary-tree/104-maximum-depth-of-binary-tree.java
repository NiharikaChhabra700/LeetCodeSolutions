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
     public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        
        LinkedList<TreeNode> que=new LinkedList<>();
        que.addLast(root);
        int level=0;
        
        while(que.size()!=0)
        {
            int size=que.size();
            level++;
            while(size-->0)
            {
                TreeNode rn=que.removeFirst();
                
                if(rn.left!=null)
                {
                    que.addLast(rn.left);
                }
                if(rn.right!=null)
                {
                    que.addLast(rn.right);
                }
            }
        
        }
        
        return level;
}
}