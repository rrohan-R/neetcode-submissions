class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int l=0, r=0;
        Set<Character> set = new HashSet<>();

        for(r=0; r<s.length(); r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++; 
            }
            set.add(s.charAt(r));
            maxLength = Math.max(maxLength, r-l+1);
        }

        return maxLength;
    }
}
