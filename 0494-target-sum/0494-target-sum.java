class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return solve(nums, 0, 0, target, memo);
    }

    private int solve(int[] nums, int i, int sum, int target, Map<String, Integer> memo){
        if(i == nums.length){
            return sum == target ? 1 : 0;
        }

        String key = i + "," + sum;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int add = solve(nums, i + 1, sum + nums[i], target, memo);
        int substract = solve(nums, i + 1, sum - nums[i], target, memo);

        memo.put(key, add + substract);
        return add + substract;
    }
}