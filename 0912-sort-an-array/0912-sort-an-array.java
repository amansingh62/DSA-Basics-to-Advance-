class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end, int[] temp){
        if(start >= end) return;

        int mid = start + (end - start) / 2;

        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);

        merge(nums, start, mid, end, temp);
    };

    private void merge(int[] nums, int start, int mid ,int end, int[] temp){
        int i = start, j = mid + 1; int k = start;
  
        while(i <= mid && j <= end){
            if(nums[i] <= nums[j]){
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
             k++;
        }

        while(i <= mid) {
            temp[k] = nums[i];
            k++;
            i++;
        }

        while(j <= end){
            temp[k] = nums[j];
            k++;
            j++;
        }
        for(int p = start; p <= end; p++){
            nums[p] = temp[p];
        }
    }

}