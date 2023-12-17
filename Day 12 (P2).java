// Leetcode 1679. Max Number of K-Sum Pairs

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                count++;
                i++;
                j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else
                j--;
        }
        return count;
    }
}