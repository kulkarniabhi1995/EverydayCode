/*
https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
*/
class Solution 
{
   public boolean isMajorityElement(int[] nums, int target) 
   {
        int n = nums.length;
        int first = search(nums, target);
        int last = search(nums, target + 1);
        return last - first > n / 2;
    }
	
    private int search(int[] nums, int target) 
    {
        int lo = 0, hi = nums.length;
        while (lo < hi) 
        {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) 
            {
                lo = mid + 1;
            } else 
            {
                hi = mid;
            }
        }
        return lo;
    }
}