/*
https://leetcode.com/problems/counting-elements/
*/
class Solution 
{
    public int countElements(int[] arr) 
    {
        Set<Integer> sett=new HashSet<Integer>();
        int counter=0;
        for(int s : arr)
        {
            sett.add(s);
        }
        
        for(int s : arr)
        {
            if(sett.contains(s+1))
                counter++;
            else
                continue;
        }
        
        return counter;
    }
}