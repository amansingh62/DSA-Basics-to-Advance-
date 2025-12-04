class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

       while(mid <= right){
         // Mid will be swapped with left if found 0
        if(nums[mid] == 0){
            swap(nums, mid, left);
            mid++;
            left++;
        }
        
        // Mid will be just incremented if found 1
        else if(nums[mid] == 1){
            mid++;
        }

        // Mid will be swapped with right if found 2
         else{
            swap(nums, mid, right);
            right--;
         }
       }
    }

     // Method to swap
       private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
       }
}