/*
https://leetcode.com/problems/pascals-triangle/
*/
class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        if(numRows==0) return new ArrayList<List<Integer>>();
        
        List<List<Integer>> finalList=new ArrayList();
        
        finalList.add(new ArrayList<>());
        finalList.get(0).add(1);
        
        
        for(int numRowss=1; numRowss < numRows; numRowss++)
        {
            
            List<Integer> newList= new ArrayList<Integer>();
            newList.add(1);
            
            List<Integer> oldList= finalList.get(numRowss-1);
            
            for(int j=1; j < oldList.size(); j++)
            {
                int temp= oldList.get(j-1)+oldList.get(j);
                newList.add(temp);
            }
            newList.add(1);
            
            finalList.add(newList);
            
        }
        return finalList;
    }
}