class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, r = 0;
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[n-k+1];

        while(r < n){
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[r]){
                dq.removeLast();
            }
            dq.addLast(r);

            while(dq.getFirst() < l){
                dq.removeFirst();
            }

            if(r+1 >= k){
                res[l] = nums[dq.getFirst()];
                l++;
            }
            r++;
        }

        return res;
    }
}
