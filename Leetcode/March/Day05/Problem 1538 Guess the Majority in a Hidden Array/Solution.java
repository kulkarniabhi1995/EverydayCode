/*
https://leetcode.com/problems/guess-the-majority-in-a-hidden-array/
*/
/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *   public:
 *     // Compares 4 different elements in the array
 *     // return 4 if the values of the 4 elements are the same (0 or 1).
 *     // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
 *     // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
 *     public int query(int a, int b, int c, int d);
 *
 *     // Returns the length of the array
 *     public int length();
 * };
 */

class Solution 
{
    public int guessMajority(ArrayReader reader) 
    {
         int n = reader.length();
        int[] map = new int[n];   
        map[0] = 1;
        int a = reader.query(0,1,2,3);
        int e = reader.query(1,2,3,4); map[4] = a==e?1:2;
        int b = reader.query(0,2,3,4); map[1] = b==e?1:2;
        int c = reader.query(0,1,3,4); map[2] = b==c?map[1]:3-map[1];
        int d = reader.query(0,1,2,4); map[3] = c==d?map[2]:3-map[2];
        int count1 = 0, count2 = 0;
        int id1 = -1, id2 =-1;
        int res = -1;
        for(int i=0;i<5;i++) 
        {
            if(map[i] == 1) 
            {
                count1++; id1 = i;
            }
            else 
            {
                count2 ++; id2= i;
            }
        }
        int last = e;
        for(int i=5;i<n;i++)
        {
            int cur = reader.query(i-3,i-2,i-1,i);
            map[i] = cur == last? map[i-4]:(3-map[i-4]);
            last = cur;
            if(map[i] == 1) 
            {
                count1++; id1 = i;
            }
            else 
            {
                count2 ++; id2= i;
            }
        } 
        if(count1 == count2) return -1;
        return count1 > count2? id1:id2;        
    }
}