class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0, n = heights.length;
        for(int i=0; i<n;i++){
            int height = heights[i];
            int maxRight = i+1;
            while(maxRight < n &&
             heights[maxRight] >= height){
                maxRight++;
            }
            int maxLeft = i;
            while(maxLeft >= 0 && heights[maxLeft] >= height){
                maxLeft --;
            }
            maxLeft++;
            maxRight--;
            maxArea = Math.max(maxArea, height * (maxRight - maxLeft + 1));
        }
        return maxArea;
    }
}
