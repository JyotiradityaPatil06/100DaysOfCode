// Leetcode 509. Fibonacci Number

class Solution {
    public int solve(int n, int[] dp) {
        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n];

        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        return dp[n];
    }

    public int fib(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        int ans = solve(n, dp);
        return ans;
    }
}