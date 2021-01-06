/*
https://leetcode.com/problems/armstrong-number/
*/
class Solution 
{
    public boolean isArmstrong(int N) 
    {
        int sum=0;
        int M=N;
        int length=(int)Math.log10(N)+1;
        while(M!=0)
        {                    
            sum+= (Math.pow(M % 10,length));            
             M=M / 10;               
        }
        System.out.println(sum);
        
        return N==sum;
        
    }
}