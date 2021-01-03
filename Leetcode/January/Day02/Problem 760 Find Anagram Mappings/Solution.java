/*
https://leetcode.com/problems/find-anagram-mappings/
*/
class Solution 
{
    public int[] anagramMappings(int[] A, int[] B) 
    {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();        
        int[] result=new int[A.length];
        for(int i=0;i<B.length;i++)
        {
            map.put(B[i],i);
        }

        int t=0;
        for(int number : A)
        {
            result[t++]=map.get(number);
        }
        
        return result;
    }
}