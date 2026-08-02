class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones){
            pq.offer(i);
        }

        while(pq.size() > 1){
            int smash = pq.poll() - pq.poll();

            if(smash != 0){
                pq.offer(smash);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
