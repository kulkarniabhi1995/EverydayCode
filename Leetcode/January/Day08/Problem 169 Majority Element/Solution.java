/*
https://leetcode.com/problems/majority-element/solution/
*/
class Solution 
{
    public int majorityElement(int[] nums) 
    {
        int count =0;
        Integer candidate=null;
        
        for(int number : nums)
        {            
            if(count ==0)
            {
                candidate=number;
            }
            
            if(number==candidate)
            {
                count++;
            }
            else
            {
                count--;
            }            
        }        
        return candidate;        
    }
}