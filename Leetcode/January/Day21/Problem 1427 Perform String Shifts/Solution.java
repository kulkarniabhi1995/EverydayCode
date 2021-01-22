/*
https://leetcode.com/problems/perform-string-shifts/
*/
class Solution 
{
    public String stringShift(String s, int[][] shift) 
    {
        int start = 0;
        for (int[] swap : shift) 
        {
            if (swap[0] == 1)
                start += swap[1];
            else  
                start -= swap[1];
        }

        start %= s.length();

        if (start == 0)
            return s;

        if (start > 0)
            start = s.length() - start;
        else
            start = Math.abs(start);

        return s.substring(start) + s.substring(0, start);
    }
}