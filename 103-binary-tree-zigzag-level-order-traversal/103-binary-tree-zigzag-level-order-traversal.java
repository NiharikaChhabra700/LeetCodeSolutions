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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        
        
        List<List<Integer>> ans=new ArrayList<>();
        
        if(root==null) return ans;
        
        LinkedList<TreeNode> que=new LinkedList<>();
        
        que.addLast(root);
        int level=1;
        
        while(que.size()!=0)
        {
            int size=que.size();
            List<Integer> list=new ArrayList<>();
            
            while(size-->0)
            {
                TreeNode rn=que.removeFirst();
                list.add(rn.val);
                
                if(rn.left!=null)
                {
                    que.addLast(rn.left);
                }
                
                if(rn.right!=null)
                {
                    que.addLast(rn.right);
                }
                
            }
            
            if(level %2 ==0)
            {
                Collections.reverse(list);
            }
            ans.add(list);
            level++;
        
        }
        
        return ans;
        
        
        
        
        
    }
}