// Leetcode 1578. Minimum Time to Make Rope Colorful 

class Solution {
    public int minCost(String s, int[] cost) {
        int result = 0;
        char[] a = s.toCharArray();
        int max = 0; // pointer to the element with highest cost in sequence of identical characters
        for (int i = 1; i < a.length; ++i) {
            if (a[max] == a[i]) {
                result += Math.min(cost[max], cost[i]);
                if (cost[max] < cost[i])
                    max = i; // if i points to the character with higher cost we set this character as our
                             // current maximum.
            } else
                max = i; // If characters are different we move "max" by one place, or in other words
                         // element at max has the highest cost in it's sequence of size 1.
        }
        return result;
    }
}