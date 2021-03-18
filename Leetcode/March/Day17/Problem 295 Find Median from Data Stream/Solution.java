/*
https://leetcode.com/problems/find-median-from-data-stream/
*/
class MedianFinder 
{
    class TreeNode
    {
        int val;
        TreeNode parent,left,right;
        TreeNode(int val, TreeNode p)
        {
            this.val=val;
            this.parent=p;
            left=null;
            right=null;
        }
        
        void add(int num)
        {
            if(num>=val)
            {
                if(right==null)
                    right=new TreeNode(num,this);
                else
                    right.add(num);
            }
            else
            {
                if(left==null)
                    left=new TreeNode(num,this);
                else
                    left.add(num);
            }
        }
        
        TreeNode next()
        {
            TreeNode ret;
            if(right!=null)
            {
                ret=right;
                while(ret.left!=null)
                    ret=ret.left;
            }
            else
            {
                ret=this;
                while(ret.parent.right==ret)
                    ret=ret.parent;
                ret=ret.parent;
            }
            return ret;
        }
        TreeNode prev()
        {
            TreeNode ret;
            if(left!=null)
            {
                ret=left;
                while(ret.right!=null)
                    ret=ret.right;
            }
            else
            {
                ret=this;
                while(ret.parent.left==ret)
                    ret=ret.parent;
                ret=ret.parent;
            }
            return ret;
        }
    }
    
    int n;
    TreeNode root, curr;
    public void addNum(int num) 
    {
        if(root==null)
        {
            root = new TreeNode(num,null);
            curr=root;
            n=1;
        }
        else
        {
            root.add(num);
            n++;
            if(n%2==1)
            {
                if(curr.val <= num)
                {
                    curr=curr.next();
                }
            }
            else
            {
                 if(curr.val > num)
                 {
                    curr=curr.prev(); 
                 }                    
            }   
        }
    }

    public double findMedian() 
    {
        if(n%2==0)
        {
            return ((double)curr.next().val + curr.val)/2;
        }
        else
            return curr.val;
    }
}