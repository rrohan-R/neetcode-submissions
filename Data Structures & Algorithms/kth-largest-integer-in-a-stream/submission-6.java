class KthLargest {
    private PriorityQueue<Integer> pq;
    private int K;

    public KthLargest(int k, int[] nums) {
        this.K = k;
        this.pq = new PriorityQueue<>();

        for(int i : nums){
            pq.offer(i);

            if(pq.size() > K){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        if(pq.size() > K){
            pq.poll();
        }

        return pq.peek();
    }
}
