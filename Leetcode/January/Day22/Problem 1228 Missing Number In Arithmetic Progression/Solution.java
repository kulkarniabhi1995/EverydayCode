/*
https://leetcode.com/problems/missing-number-in-arithmetic-progression/
*/
class Solution 
{
    public int missingNumber(int[] arr) 
    {
        int n=arr.length;
        int difference=(arr[arr.length-1]-arr[0])/n;
    
        int expected=arr[0];
        
        
        for(int value : arr)
        {
            if(value!=expected) return expected;   
            
            expected+=difference;
        }
        return expected;
    }
}