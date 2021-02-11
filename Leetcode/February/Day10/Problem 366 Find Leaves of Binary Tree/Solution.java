/*
https://leetcode.com/problems/find-leaves-of-binary-tree/
*/
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
class Solution 
{
     private List<List<Integer>> solution;
    
    private int getHeight(TreeNode root) 
    {
        if (root == null) 
        {
            return -1;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        
        if (this.solution.size() == currHeight) 
        {
            this.solution.add(new ArrayList<>());
        }
        
        this.solution.get(currHeight).add(root.val);
        
        return currHeight;
    }
    public List<List<Integer>> findLeaves(TreeNode root) 
    {
        this.solution = new ArrayList<>();        
        getHeight(root);        
        return this.solution;
    }
}