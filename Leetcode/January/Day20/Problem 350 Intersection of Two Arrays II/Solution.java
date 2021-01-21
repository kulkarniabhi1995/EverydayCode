/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/
*/
class Solution 
{
    public int[] intersect(int[] nums1, int[] nums2) 
    {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        List<Integer> list=new ArrayList<Integer>();        
        
        for(int number : nums1)
        {            
            map.put(number, map.getOrDefault(number,0)+1);
        }
            
        for(int number2 : nums2)
        {
            
                if(map.containsKey(number2) && map.get(number2) > 0)
                {
                    list.add(number2);
                    map.put(number2,map.get(number2)-1);
                }
        }
        
        int[] resultArray=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            resultArray[i]=list.get(i);
        }
        
        return resultArray;
    }
}