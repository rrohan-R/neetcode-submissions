class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        for(int i:set){
            if(!set.contains(i-1)){
                int length=1;
                while(set.contains(i+length)){
                    length++;
                }
                maxLength=Math.max(maxLength,length);
            }
        }
        return maxLength;
    }
}
