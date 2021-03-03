/*
https://leetcode.com/problems/tree-diameter/
*/
class Solution 
{
    private List<List<Integer>> graph;
    private Integer diameter = 0;

    public int treeDiameter(int[][] edges) 
    {
        this.graph = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[edges.length + 1];
        for (int i = 0; i < edges.length + 1; ++i) 
        {
            this.graph.add(new ArrayList<Integer>());
            visited[i] = false;
        }
        for (int[] edge : edges) 
        {
            Integer u = edge[0], v = edge[1];
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);
        }

        dfs(0, visited);

        return this.diameter;
    }

    private int dfs(int curr, boolean[] visited) 
    {
        Integer topDistance1 = 0, topDistance2 = 0;

        visited[curr] = true;
        for (Integer neighbor : graph.get(curr)) 
        {
            int distance = 0;
            if (!visited[neighbor])
                distance = 1 + this.dfs(neighbor, visited);

            if (distance > topDistance1) 
            {
                topDistance2 = topDistance1;
                topDistance1 = distance;
            } else if (distance > topDistance2) 
            {
                topDistance2 = distance;
            }
        }
        
        this.diameter = Math.max(this.diameter, topDistance1 + topDistance2);

        return topDistance1;
    }
}