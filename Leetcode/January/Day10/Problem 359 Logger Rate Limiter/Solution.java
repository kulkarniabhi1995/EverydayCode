/*
https://leetcode.com/problems/logger-rate-limiter/submissions/
*/
class Logger {

    private HashMap<String,Integer> messageDirectory;
    /** Initialize your data structure here. */
    public Logger() 
    {
        messageDirectory = new HashMap<String,Integer>();    
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) 
    {
        if(!this.messageDirectory.containsKey(message))
        {
            this.messageDirectory.put(message,timestamp);
            return true;
        }
        
        Integer oldTimeStamp= this.messageDirectory.get(message);
        
        if(timestamp-oldTimeStamp>=10)
        {
            this.messageDirectory.put(message,timestamp);
            return true;
        }
        else
        {
            return false;
        }
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */