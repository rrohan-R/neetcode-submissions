class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(nums, curr, 0, target);
        return res;
    }

    public void dfs(int[] nums, List<Integer> curr, int i, int target){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || i >= nums.length){
            return;
        }

        curr.add(nums[i]);
        dfs(nums, curr, i, target - nums[i]);
        curr.remove(curr.size() - 1);
        dfs(nums, curr, i+1, target);
    }
}
