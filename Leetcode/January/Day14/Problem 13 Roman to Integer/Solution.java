/*
https://leetcode.com/problems/roman-to-integer/
*/
class Solution 
{
    public int romanToInt(String s) 
    {
        int[] array=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
            switch(s.charAt(i))
            {
                case 'I':
                    array[i]=1;
                    break;
                
                case 'V':
                    array[i]=5;
                    break;
                    
                case 'X':
                    array[i]=10;
                    break;
                    
                case 'L':
                    array[i]=50;
                    break;
                    
                case 'C':
                    array[i]=100;
                    break;
                    
                case 'D':
                    array[i]=500;
                    break;
                    
                case 'M':
                    array[i]=1000;
                    break;
            }
        }
        int result=0;
        for(int j=0;j<array.length-1;j++)
        {
            if(array[j]<array[j+1])
            {
                result=result-array[j];
            }
            else
            {
                result=result+array[j];
            }
        }
        
        return result+array[array.length-1];
        
    }
}