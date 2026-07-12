class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        if(nums == null || nums.length == 0){
            return new int[]{0,0};
        }

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(map.get(b), map.get(a)));
        pq.addAll(map.keySet());
        
        int[] res = new int[k];

        for(int i=0; i<k; i++){
            res[i] = pq.poll();
        }

        return res;
    }
}
