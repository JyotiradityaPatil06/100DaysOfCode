// Print Pattern (GFG)

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine().trim());

            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public List<Integer> pattern(int N) {

        List<Integer> list = new ArrayList<>();
        list.add(N);

        if (N <= 0) {
            return list;
        }

        solve(list, N - 5, true, N);
        return list;
    }

    void solve(List<Integer> list, int n, boolean flag, int k) {
        list.add(n);

        if (n > 0 && flag)
            solve(list, n - 5, true, k);
        if (n <= 0)
            solve(list, n + 5, false, k);
        if (n > 0 && !flag && n < k)
            solve(list, n + 5, false, k);
        else
            return;
    }
}