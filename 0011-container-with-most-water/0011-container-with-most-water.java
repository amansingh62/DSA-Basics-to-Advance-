class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int left = 0, right = height.length - 1;

        while(left < right) {
            int water = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, water);

            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}