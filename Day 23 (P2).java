// Minimize the sum of product (GFG)

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int) (n)];
            long b[] = new long[(int) (n)];

            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.minValue(a, b, n));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {

    public long minValue(long a[], long b[], long n) {
        // Sort the given Arrays
        Arrays.sort(a);
        Arrays.sort(b);
        // Reverse one array so that we get in descending order
        for (int i = 0, j = b.length - 1; i < j; i++, j--) {
            long temp = b[i];
            b[i] = b[j];
            b[j] = temp;
        }
        // Multiply the same index elements
        long minProductSum = 0;
        for (int i = 0; i < n; i++) {
            minProductSum += a[i] * b[i];
        }
        return minProductSum;
    }
}