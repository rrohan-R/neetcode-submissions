class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dequeue = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int l=0, r=0;

        while(r<n){
            while(!dequeue.isEmpty() && nums[dequeue.getLast()] < nums[r]){
                dequeue.removeLast();
            }
            dequeue.addLast(r);
            if(l > dequeue.getFirst()){
                dequeue.removeFirst();
            }

            if((r+1) >= k){
                res[l] = nums[dequeue.getFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
