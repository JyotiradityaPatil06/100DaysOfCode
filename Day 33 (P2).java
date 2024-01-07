// Split Array Largest Sum (GFG)

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String St[] = read.readLine().split(" ");

            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);

            String S[] = read.readLine().split(" ");

            int[] arr = new int[N];

            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr, N, K));
        }
    }
}
// } Driver Code Ends

class Solution {
    static int splitArray(int[] nums, int N, int k) {
        int left = Arrays.stream(nums).max().orElse(0);
        int right = Arrays.stream(nums).sum();
        int res = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, mid, k)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    private static boolean canSplit(int[] nums, int largest, int k) {
        int subarray = 0, currSum = 0;

        for (int n : nums) {
            currSum += n;

            if (currSum > largest) {
                subarray++;
                currSum = n;
            }
        }

        return subarray + 1 <= k;
    }

    // Optimized approach using dynamic programming
    static int splitArrayOptimized(int[] nums, int N, int k) {
        int[][] dp = new int[k + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[1][i] = dp[1][i - 1] + nums[i - 1];
        }

        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= N; j++) {
                int currSum = 0;
                dp[i][j] = Integer.MAX_VALUE;

                for (int p = j; p > i - 1; p--) {
                    currSum += nums[p - 1];
                    dp[i][j] = Math.min(dp[i][j], Math.max(currSum, dp[i - 1][p - 1]));
                }
            }
        }

        return dp[k][N];
    }
}