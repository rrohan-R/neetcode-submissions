class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i=0; i<n; i++){
            int j = i+1;
            int count = 1;
            while(j<n){
                if(temperatures[j] > temperatures[i]){
                    break;
                }
                count++;
                j++;
            }
            count = (j == n)? 0 : count;
            result[i] = count;
        }
        return result;
    }
}
