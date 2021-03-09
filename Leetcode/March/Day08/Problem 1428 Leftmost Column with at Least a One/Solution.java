/*
https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
*/
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution 
{
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) 
    {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        int smallestIndex = cols;
        for (int row = 0; row < rows; row++) 
        {
            int lo = 0;
            int hi = cols - 1;
            while (lo < hi) 
            {
                int mid = (lo + hi) / 2;
                if (binaryMatrix.get(row, mid) == 0) 
                {
                    lo = mid + 1;
                }
                else 
                {
                    hi = mid;
                }
            }
            if (binaryMatrix.get(row, lo) == 1) 
            {
                smallestIndex = Math.min(smallestIndex, lo);
            }
        }
        return smallestIndex == cols ? -1 : smallestIndex;    
    }
}