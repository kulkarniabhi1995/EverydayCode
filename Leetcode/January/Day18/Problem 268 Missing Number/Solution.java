/*
https://leetcode.com/problems/missing-number/
*/
class Solution 
{
    public int missingNumber(int[] nums) 
    {       
        Set<Integer> set=new HashSet<Integer>();
        
        for(int number : nums)
        {
            set.add(number);
        }
        
        for(int number=0;number<nums.length+1;number++)
        {
            if(!set.contains(number))
            {
                return number;
            }
        }
        retun -1;
    }
}