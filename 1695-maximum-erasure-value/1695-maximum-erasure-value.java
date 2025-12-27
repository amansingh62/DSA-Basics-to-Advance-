import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int left = 0;
        int currSum = 0;
        int maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            // If duplicate found, shrink window
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }

            // Add current element
            set.add(nums[right]);
            currSum += nums[right];

            // Update max sum
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
