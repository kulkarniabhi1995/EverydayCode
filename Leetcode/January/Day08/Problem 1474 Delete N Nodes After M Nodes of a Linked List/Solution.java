/*
https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{    
    public ListNode deleteNodes(ListNode head, int m, int n) 
    {
      
        ListNode currentNode=head;
        ListNode lastNode=head;
        
        
        while(currentNode!=null)
        {
            int mCount=m;
            int nCount=n;
            
            while(currentNode!=null && mCount!=0)
            {
                lastNode=currentNode;
                currentNode=currentNode.next;
                mCount--;
            }
            
            while(currentNode !=null && nCount!=0)
            {
                currentNode=currentNode.next;
                nCount--;
            }
            lastNode.next=currentNode;
        }
        
        
        return head;
    }
}