/*
https://leetcode.com/problems/moving-average-from-data-stream/
*/
class MovingAverage 
{

    int size=0;
    int windowSum=0;
    int count=0;
    Deque queue=new ArrayDeque<Integer>();
    
    public MovingAverage(int size) 
    {
        this.size=size;
    }
    
    public double next(int val) 
    {
        count++;
        queue.add(val);
        int tail=0;
        if(count > size)
        {
            tail=(int)queue.poll();
        }
        else
        {
            tail=0;
        }
        
        windowSum= windowSum-tail+val;
        
        return windowSum * 1.0/ Math.min(size,count);
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */