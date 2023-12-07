//Leetcode 1351. Count Negative Numbers in a Sorted Matrix

class Solution {
    public int countNegatives(int[][] grid) {

        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            int start = 0;
            int end = grid[row].length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (grid[row][mid] < 0) {
                    count += (end - mid + 1);
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return count;
    }
}