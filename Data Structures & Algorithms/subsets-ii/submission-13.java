class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, subset, res, 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> subset, List<List<Integer>> res, int i){
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, subset, res, i+1);
        subset.remove(subset.size() - 1);

        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }

        dfs(nums, subset, res, i+1);
    }
}
