/*
https://leetcode.com/problems/group-anagrams/
*/
class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
    
        Map<String, List<String>> map = new HashMap<>();
        
        for(String word : strs)
        {
            
            char[] temparray= word.toCharArray();
            Arrays.sort(temparray);
            String temp=String.valueOf(temparray);
            
            
            if(map.containsKey(temp))
            {
                map.get(temp).add(word);
            }
            else
            {
                map.put(temp, new ArrayList<String>(Arrays.asList(word)));
            }
            
        }
        
        return new ArrayList<>(map.values());
        
    }
}