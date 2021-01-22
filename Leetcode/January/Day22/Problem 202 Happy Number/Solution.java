/*
https://leetcode.com/problems/happy-number/
*/
class Solution 
{
    public boolean isHappy(int n) 
    {
        Set<Integer> set = new HashSet<Integer>();
        
        while(n !=1 && !set.contains(n))
        {
            set.add(n);
            n=getNext(n);
        }
        
        return n==1;
        
    }
    
    private int getNext(int n)
    {
        
        int totalSum=0;
        while(n > 0)
        {
            int d=n%10;
            n=n/10;
            totalSum=totalSum+ (d*d);
        }
        return totalSum;
    }
}