class Solution {
    public void nextPermutation(int[] nums) {
        // Next decreasing element from the right
        int n = nums.length;
        int i = n - 2;

         while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
         }

         // Next greater element than the pivot(that is smallest from the right)
          if(i >= 0){
            int j = n - 1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
          }
         
         // Reverse the element from right to i + 1
         reverse(nums, i + 1, n - 1);
    }
        // Method for swapping
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Method for reversing the nums
    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}