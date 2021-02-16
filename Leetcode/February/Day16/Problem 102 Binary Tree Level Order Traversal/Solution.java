/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> finalList=new ArrayList<>();
        binaryTreeLevelTraversal(finalList, root, 0);
        return finalList;
    }
    
    public void binaryTreeLevelTraversal(List<List<Integer>> finalList, TreeNode root, int height)
    {
        if(root==null) return;
        
        if(height>=finalList.size())
        {
            finalList.add(new ArrayList<>());
        }
        
        finalList.get(height).add(root.val);
        binaryTreeLevelTraversal(finalList, root.left, height + 1);
        binaryTreeLevelTraversal(finalList, root.right, height + 1);
    }
    
}