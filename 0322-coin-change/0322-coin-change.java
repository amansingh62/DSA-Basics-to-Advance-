class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int result = solve(coins, amount);
        return result >= (int)1e9 ? -1 : result;
    }

    private int solve(int[] coins, int amount){
        if(amount == 0) return 0;
        if(amount < 0) return (int)1e9;

        if(dp[amount] != -1) return dp[amount];

        int ans = (int)1e9;

        for(int coin : coins){
            ans = Math.min(ans, 1 + solve(coins, amount - coin));
        }

        dp[amount] = ans;
        return ans;
    }
}