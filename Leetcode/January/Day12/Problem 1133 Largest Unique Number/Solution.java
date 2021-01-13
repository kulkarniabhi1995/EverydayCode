s/*
https://leetcode.com/problems/largest-unique-number/
*/
class Solution 
{
    public int largestUniqueNumber(int[] A) 
    {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int number : A)
        {
            map.put(number,map.getOrDefault(number,0)+1);
        }
        
        int result = -1;
        for (int number: A)
        {
            if(map.get(number) == 1 && number> result)
            {
                result=number;
            }
        }
            
        return result;
    }
}