/*
https://leetcode.com/problems/reverse-string/
*/
class Solution 
{
    public void reverseString(char[] s) 
    {
        int leftIndex=0;
        int rightIndex=s.length-1;
        
        while(leftIndex < rightIndex)
        {
            char temp=s[leftIndex];
            s[leftIndex]=s[rightIndex];
            s[rightIndex]=temp;
            leftIndex++;
            rightIndex--;
        }        
    }
}