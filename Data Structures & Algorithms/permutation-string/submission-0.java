class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        Arrays.sort(s1arr);
        String s1string = new String(s1arr);

        for(int i=0;i<s2.length();i++){
            for(int j=i;j<s2.length();j++){
                char[] subarr = s2.substring(i,j+1).toCharArray();
                Arrays.sort(subarr);
                String subarrstr = new String(subarr);

                if(subarrstr.equals(s1string)){
                    return true;
                }
            }
        }
        return false;
    }
}
