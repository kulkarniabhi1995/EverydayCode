/*
https://leetcode.com/problems/fizz-buzz/
*/
class Solution 
{
    public List<String> fizzBuzz(int n) 
    {
        List<String> result=new ArrayList<String>();
        for(int i=1;i<= n; i++)
        {
            boolean dividedBy3= (i%3==0);
            boolean dividedBy5= (i%5==0);
            boolean dividedBy3and5=(dividedBy3 && dividedBy5 );
            
            if(dividedBy3and5)
            {
                result.add("FizzBuzz");
            }
            else if(dividedBy3)
            {
                result.add("Fizz");
            }
            else if(dividedBy5)
            {
                result.add("Buzz");
            }
            else
            {
                result.add(String.valueOf(i));
            }
        }
        
        return result;
    }
}