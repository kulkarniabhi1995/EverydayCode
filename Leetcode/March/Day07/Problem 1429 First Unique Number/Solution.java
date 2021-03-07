/*
https://leetcode.com/problems/first-unique-number/
*/
class FirstUnique 
{
    private Set<Integer> unique = new LinkedHashSet<>(); 
    private Set<Integer> total = new HashSet<>();
    
    public FirstUnique(int[] nums) 
    {
        for (int n : nums) 
        {
            add(n);
        }
    }
    
    public int showFirstUnique() 
    {
        return unique.isEmpty() ? -1 : unique.iterator().next(); 
    }
    
    public void add(int value) 
    {
        if (total.add(value)) 
        {
            unique.add(value);
        }
        else 
        {
            unique.remove(value);
        }
    }
}