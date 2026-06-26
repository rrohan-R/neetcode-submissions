class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> count1 = new HashMap<>();

        for(char c : t.toCharArray()){
            count1.put(c, count1.getOrDefault(c,0) + 1);
        }

        int[] res = {-1, -1};
        int minLength = Integer.MAX_VALUE;

        for(int i=0; i<s.length(); i++){
            Map<Character,Integer> count2 = new HashMap<>();

            for(int j=i; j<s.length(); j++){
                count2.put(s.charAt(j), count2.getOrDefault(s.charAt(j), 0) + 1);

                boolean flag = true;
                for(char c : count1.keySet()){
                    if(count2.getOrDefault(c, 0) < count1.get(c)){
                        flag = false;
                        break;
                    }
                }

                if(flag && j-i+1 < minLength){
                    minLength = j-i+1;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
