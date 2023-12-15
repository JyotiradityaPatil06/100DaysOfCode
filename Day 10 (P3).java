// Smallest factorial number (GFG)

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            System.out.println(new Solution().findNum(n));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    int findNum(int n) {
        for (int i = 0; i < 1e5; i++) {
            int x = i / 5 + i / 25 + i / 125 + i / 625 + i / 3125 + i / 15625;
            if (x >= n)
                return i;
        }
        return 0;
    }
}
