class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null){
            return true;
        }

        int len = 0;

        for(int i=0; i<nums.length; i++){
            if(len < i){
                return false;
            }

            len = Math.max(len, i + nums[i]);

            if(len >= nums.length - 1){
                return true;
            }

        }

        return false;
    }
}

