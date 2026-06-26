class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()){
            return false;
        }

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String s1Str = new String(s1Arr);

        for(int i=0; i<s2.length(); i++){
            for(int j=i; j<s2.length(); j++){
                char[] s2Arr = s2.substring(i, j+1).toCharArray();
                Arrays.sort(s2Arr);
                String s2Str = new String(s2Arr);

                if(s1Str.equals(s2Str)){
                    return true;
                }
            }
        }

        return false;
    }
}
