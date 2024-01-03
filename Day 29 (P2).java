// Smallest window containing 0, 1 and 2 (GFG)

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        int zero = -1;
        int one = -1;
        int two = -1;
        int ans = Integer.MAX_VALUE;
        int mini, maxi;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0')
                zero = i;
            else if (S.charAt(i) == '1')
                one = i;
            else if (S.charAt(i) == '2')
                two = i;

            if (zero != -1 && one != -1 && two != -1) {
                mini = Math.min(zero, Math.min(one, two));
                maxi = Math.max(zero, Math.max(one, two));

                ans = Math.min(ans, (maxi - mini + 1));
            }
        }

        if (ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;

    }
}
