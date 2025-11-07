class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long MOD =  1_000_000_007L;

        long[] prefix = new long[n + 1];
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        int[] right = new int[n];
        stack.clear();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }

        long maxProduct = 0;
        for(int i = 0; i < n; i++){
            long subarraysSum = prefix[right[i] + 1] - prefix[left[i]];
            long product = nums[i] * subarraysSum;
            maxProduct = Math.max(maxProduct, product);
        }

        return (int) (maxProduct % MOD);
    }
}