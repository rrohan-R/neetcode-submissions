class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<int[]> listArr=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            listArr.add(new int[]{entry.getValue(),entry.getKey()});
        }
        listArr.sort((a,b)->b[0]-a[0]);
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=listArr.get(i)[1];
        }
        return res;
    }
}
