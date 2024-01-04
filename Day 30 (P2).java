// Find element occuring once when all other are present thrice (GFG)

//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");

            int[] arr = new int[N];

            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.singleElement(arr, N));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int singleElement(int[] arr, int N) {
        int ans = 0;
        for (int i = 0; i <= 32; i++) {
            int x = 1 << i; // (if i=0,x=2^0) ( if i=1,x=2^1)
            int sum = 0;

            for (int j = 0; j < N; j++) {
                if ((arr[j] & x) != 0) {
                    sum++;
                }
            }

            if (sum % 3 != 0) {
                ans = ans | x;
            }
        }
        return ans;
    }
}