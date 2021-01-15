/*
https://leetcode.com/problems/palindrome-permutation/
*/
class Solution 
{
    public boolean canPermutePalindrome(String s) 
    {
        Set<Character> set = new HashSet<Character>();
        
        for(int i=0; i< s.length(); i++)
        {
            if(!set.add(s.charAt(i)))
            {
                set.remove(s.charAt(i));
            }
        }
        
        return set.size() <=1;
    }
}