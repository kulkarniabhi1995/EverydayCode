/*
https://leetcode.com/problems/alien-dictionary/
*/
class Solution 
{
    private Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    private Map<Character, Boolean> seen = new HashMap<>();
    private StringBuilder output = new StringBuilder();
    
    public String alienOrder(String[] words) 
    {
        
         for (String word : words) 
         {
            for (char c : word.toCharArray()) 
            {
                reverseAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) 
        {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) 
            {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) 
            {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        for (Character c : reverseAdjList.keySet()) 
        {
            boolean result = dfs(c);
            if (!result) return "";
        }
        
        
        if (output.length() < reverseAdjList.size()) 
        {
            return "";
        }
        return output.toString();
    }
    private boolean dfs(Character c) 
    {
        if (seen.containsKey(c)) 
        {
            return seen.get(c); 
        }
        seen.put(c, false);
        for (Character next : reverseAdjList.get(c)) 
        {
            boolean result = dfs(next);
            if (!result) return false;
        }
        seen.put(c, true);
        output.append(c);
        return true;
    }
}