class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashSet<Character> set = new HashSet<>();

        for(char c : s.toCharArray()){
            set.add(c);
        }

        for(char c: set){
            int l=0, r=0, count=0;
            for(r=0; r<s.length(); r++){
                if(s.charAt(r) == c){
                    count++;
                }

                if(r-l+1 - count > k){
                    if(s.charAt(l)==c){
                        count--;
                    }
                    l++;
                }
                res = Math.max(res, r-l+1);
            }
        }
        return res;
    }
}
 