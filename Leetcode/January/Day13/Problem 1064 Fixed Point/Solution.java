/*
https://leetcode.com/problems/fixed-point/
*/
class Solution 
{
    public int fixedPoint(int[] arr) 
    {
        int res = -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= mid) {
                if (arr[mid] == mid) res = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return res;
    }
}