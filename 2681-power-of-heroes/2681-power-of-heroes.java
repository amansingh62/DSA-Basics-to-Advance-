class Solution {
    public int sumOfPower(int[] nums) {
         final int MOD = 1_000_000_007;
        Arrays.sort(nums);

        long ans = 0L;
        long sum = 0L;  // tracks weighted contribution of previous elements as possible mins

        for (int num : nums) {
            long x = num;

            // Contribution when x is the maximum:
            // (x + sum) * x^2
            long x2 = (x * x) % MOD;
            long contrib = ((x + sum) % MOD) * x2 % MOD;

            ans = (ans + contrib) % MOD;

            // Update sum for future elements:
            // all previous contributions double (choose / not choose),
            // plus x as a new possible min base
            sum = (sum * 2 + x) % MOD;
        }

        return (int) ans;
    }
}