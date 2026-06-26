class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        int[] res = new int[2];
        int minLength = Integer.MAX_VALUE;

        for(char c : t.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for(int i=0; i<s.length(); i++){
            Map<Character,Integer> map2 = new HashMap<>();

            for(int j=i; j<s.length(); j++){
                map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j), 0) + 1);
                boolean flag = true;
                
                for(char c : map1.keySet()){
                    if(map2.getOrDefault(c,0) < map1.get(c)){
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
