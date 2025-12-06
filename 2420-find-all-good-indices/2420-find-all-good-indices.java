class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;

        int[] nonInc = new int[n];
        int[] nonDec = new int[n];

        for(int i = 1; i < n; i++){
            if(nums[i] <= nums[i - 1]){
                nonInc[i] = nums[i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(nums[i + 1] >= nums[i]){
                nonDec[i] = nums[i + 1] + 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = k; i < n - k; i++){
            if(nonInc[i - 1] >= k && nonDec[i + 1] >= k){
                result.add(i);
            }
        }
        return result;
    }
}