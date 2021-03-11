/*
https://leetcode.com/problems/shortest-word-distance-iii/
*/
class Solution 
{
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) 
    {
        long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
        boolean same = word1.equals(word2);
        for (int i=0; i<wordsDict.length; i++) 
        {
            if (wordsDict[i].equals(word1)) 
            {
                if (same) 
                {
                    i1 = i2;
                    i2 = i;
                } 
                else 
                {
                    i1 = i;
                }
            } 
            else if (wordsDict[i].equals(word2)) 
            {
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        
        return (int) dist;    
    }
}