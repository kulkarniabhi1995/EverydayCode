/*
https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
*/
class Solution 
{
    public int countLetters(String S) 
    {
        int sum=1;
        int temp=1;
        for(int i=1; i< S.length();i++)
        {            
            if(S.charAt(i)==S.charAt(i-1))
            {
                temp++;
            }
            else
            {
                temp=1;
            }            
            sum+=temp;                
        }
        return sum;
    }
}