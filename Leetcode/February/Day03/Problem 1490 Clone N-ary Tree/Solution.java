/*
https://leetcode.com/problems/clone-n-ary-tree/
*/
/*
// Definition for a Node.
class Node 
{
    public int val;
    public List<Node> children;

    
    public Node() 
    {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) 
    {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) 
    {
        val = _val;
        children = _children;
    }
};
*/

class Solution
{
    public Node cloneTree(Node root)
    {
        if (root == null)
            return null;
        
        var new_r = new Node(root.val);
            for (var child: root.children)
                new_r.children.add(cloneTree(child));
        return new_r;
    }
}