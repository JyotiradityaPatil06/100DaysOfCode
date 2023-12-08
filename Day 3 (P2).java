// Leetcode 378. Kth Smallest Element in a Sorted Matrix

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;

        int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, maxNum = lo;

            for (int r = 0, c = cols - 1; r < rows; r++) {
                while (c >= 0 && matrix[r][c] > mid)
                    c--;

                if (c >= 0) {
                    count += (c + 1);
                    maxNum = Math.max(maxNum, matrix[r][c]);

                } else {
                    break;
                }
            }

            if (count == k)
                return maxNum;
            else if (count < k)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}