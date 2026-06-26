public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = height[i];
            int rightMax = height[i];

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int k = i + 1; k < n; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }

            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }
}