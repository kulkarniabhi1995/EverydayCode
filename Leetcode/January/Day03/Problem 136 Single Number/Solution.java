/*
https://leetcode.com/problems/single-number/
*/
class Solution 
{
    public int singleNumber(int[] nums) 
    {
                
       Map<Integer,Integer> map=new HashMap<Integer,Integer>();

            for(int number: nums)
            {
                map.put(number,map.getOrDefault(number,0)+1);
            }
            
           for(int i:nums)
           {
               if(map.get(i)==1)
                   return i;
           }
        
        return 0;
    }
}