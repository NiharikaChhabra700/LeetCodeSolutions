class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {
        return b-a;
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        
        if(maxHeap.size() == 0 || num<=maxHeap.peek() )
        {
            maxHeap.add(num);
        }
        else
        {
            minHeap.add(num);
        }
        
        if(maxHeap.size() > minHeap.size() + 1)
        {
            minHeap.add(maxHeap.poll());
        }
        else if(maxHeap.size() < minHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        
        if(minHeap.size() == maxHeap.size())
        {
            return minHeap.peek()/2.0 + maxHeap.peek()/2.0;
        }
        else
        {
            return maxHeap.peek() * 1.0;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */