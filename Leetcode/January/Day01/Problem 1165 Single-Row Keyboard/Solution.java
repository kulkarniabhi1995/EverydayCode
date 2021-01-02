/*
https://leetcode.com/problems/single-row-keyboard/
*/
class Solution 
{
    public int calculateTime(String keyboard, String word) 
    {

        int[] indexArray=new int[26];
       
        for(int i=0;i<keyboard.length();i++)
        {
            indexArray[keyboard.charAt(i)-'a']=i;
        }
     
        int sum=0;
        int last=0;
        
        for(char c : word.toCharArray())
        {
            sum+= Math.abs(indexArray[c-'a']-last);
            last= indexArray[c-'a'];
        }
        return sum;
    }
}