class Solution {
    List<List<Integer>> res;
    

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        dfs(nums, temp, visited);

        return res;
    }

    public void dfs(int[] nums, List<Integer> temp, boolean[] visited){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                temp.add(nums[i]);
                visited[i] = true;
                dfs(nums, temp, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
