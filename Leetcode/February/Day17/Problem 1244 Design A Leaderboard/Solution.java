/*
https://leetcode.com/problems/design-a-leaderboard/
*/
class Leaderboard 
{

    Map<Integer, Integer> scores;
    TreeMap<Integer, Integer> sortedScores;
    
    public Leaderboard() 
    {
        this.scores = new HashMap<Integer, Integer>();
        this.sortedScores = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) 
    {
        if (!this.scores.containsKey(playerId)) 
        {
            this.scores.put(playerId, score);
            this.sortedScores.put(score, this.sortedScores.getOrDefault(score, 0) + 1);
        } 
        else 
        {
            int preScore = this.scores.get(playerId);
            int playerCount = this.sortedScores.get(preScore);
            if (playerCount == 1) 
            {
                this.sortedScores.remove(preScore);
            } else {
                this.sortedScores.put(preScore, playerCount - 1);
            }
            
            // Updated score
            int newScore = preScore + score;
            this.scores.put(playerId, newScore);
            this.sortedScores.put(newScore, this.sortedScores.getOrDefault(newScore, 0) + 1);
        }
    }
    
    public int top(int K) 
    {
        
        int count = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: this.sortedScores.entrySet()) 
        {
            int times = entry.getValue();
            int key = entry.getKey();
            
            for (int i = 0; i < times; i++) 
            {
                sum += key;
                count++;
                
                // Found top-K scores, break.
                if (count == K) 
                {
                    break;
                }
            }
            if (count == K) 
            {
                break;
            }
        }
        
        return sum;
    }
    
    public void reset(int playerId) 
    {
        int preScore = this.scores.get(playerId);
        this.sortedScores.put(preScore, this.sortedScores.get(preScore) - 1);
        if (this.sortedScores.get(preScore) == 0) 
        {
            this.sortedScores.remove(preScore);
        }
        
        this.scores.remove(playerId);
    }
}