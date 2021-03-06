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
//     Time complexity : O(n)O(n). A total of nn nodes of the given tree will be considered in the worst case.

// Space complexity : O(x)O(x). The size of the queuequeue or temptemp queue can grow upto xx only. Here, xx refers to the number of maximum number of nodes at any level in the given tree.
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth==1)
        {
            TreeNode node=new TreeNode(val);
            node.left=root;
            root=node;
            return root;
        }
        
        LinkedList<TreeNode> que=new LinkedList<>();
        que.addLast(root);
        
        int currDepth=1;
        
        while(currDepth<depth-1)
        {
            int size=que.size();
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
            
            currDepth++;
        }
        
        while(que.size()!=0)
        {
            TreeNode rn=que.removeFirst();
            
            TreeNode left= (rn.left!=null ? rn.left : null );
            TreeNode right= (rn.right!=null ? rn.right : null );
            
            TreeNode leftadd=new TreeNode(val);
            TreeNode rightadd=new TreeNode(val);
            
            rn.left=leftadd;
            rn.right=rightadd;
            
            leftadd.left=left;
            rightadd.right=right;
            
        
    }
        
        return root;
}
}