/*
https://leetcode.com/problems/two-sum-iii-data-structure-design/
*/
class TwoSum 
{
    private HashMap<Integer, Integer> number_counts;
    /** Initialize your data structure here. */
    public TwoSum() 
    {
        this.number_counts=new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) 
    {
        if(this.number_counts.containsKey(number))
        {
            this.number_counts.replace(number,this.number_counts.get(number)+1);
        }
        else
        {
            this.number_counts.put(number,1);
        }
    }
    
    public boolean find(int value) 
    {
         for (Map.Entry<Integer, Integer> entry : this.number_counts.entrySet()) 
         {
            int complement = value - entry.getKey();
            if (complement != entry.getKey()) 
            {
                if (this.number_counts.containsKey(complement))
                    return true;
            } 
            else 
            {
                if (entry.getValue() > 1)
                    return true;
            }
        }
        return false;
    }
}