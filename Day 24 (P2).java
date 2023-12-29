// Leetcode 231. Power of Two

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        return solve(n);
    }

    public boolean solve(int n) {
        if (n == 1) {
            return true;
        }

        if (n % 2 != 0) {
            return false;
        }

        return solve(n / 2);
    }
}