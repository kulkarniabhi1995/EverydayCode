/*
https://leetcode.com/problems/sparse-matrix-multiplication/
*/
class Solution 
{
    public int[][] multiply(int[][] A, int[][] B) 
    {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] result = new int[m][nB];

        List[] indexA = new List[m];
        for(int i = 0; i < m; i++) 
        {
            List<Integer> numsA = new ArrayList<>();
            for(int j = 0; j < n; j++) 
            {
                if(A[i][j] != 0)
                {
                    numsA.add(j); 
                    numsA.add(A[i][j]);
                }
            }
            indexA[i] = numsA;
        }

        for(int i = 0; i < m; i++) 
        {
            List<Integer> numsA = indexA[i];
            for(int p = 0; p < numsA.size() - 1; p += 2) 
            {
                int colA = numsA.get(p);
                int valA = numsA.get(p + 1);
                for(int j = 0; j < nB; j ++) 
                {
                    int valB = B[colA][j];
                    result[i][j] += valA * valB;
                }
            }
        }
        return result;   
    }
}