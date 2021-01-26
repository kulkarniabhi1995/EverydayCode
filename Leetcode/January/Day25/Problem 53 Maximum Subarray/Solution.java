/*
https://leetcode.com/problems/maximum-subarray/
*/
class Solution 
{
   public int maxSubArray(int[] A) 
   {
        int[] dp = new int[A.length];        
        dp[0] = A[0];
       
        int max = dp[0];
        
        for(int i = 1; i < A.length; i++)
        {
            dp[i] = Math.max(A[i] + dp[i - 1] , A[i]);
            max = Math.max(max, dp[i]);
        }        
        return max;
    }
}