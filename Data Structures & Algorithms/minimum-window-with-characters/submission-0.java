class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mapT = new HashMap<>();
        
        for(char c : t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c,0)+1);
        }
        int resLength = Integer.MAX_VALUE;
        int[] res  ={-1 , -1};
        for(int i=0; i<s.length(); i++){
            HashMap<Character, Integer> mapS = new HashMap<>();
            for(int j=i; j<s.length(); j++){
                mapS.put(s.charAt(j),mapS.getOrDefault(s.charAt(j),0)+1);
                boolean flag = true;
                for(char c : mapT.keySet()){
                    if(mapS.getOrDefault(c,0) < mapT.get(c)){
                        flag = false;
                        break;
                    }
                }
                if(flag && j-i+1 < resLength){
                    resLength = j-i+1;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return (resLength == Integer.MAX_VALUE) ? "" : s.substring(res[0], res[1] + 1);
    }
}
