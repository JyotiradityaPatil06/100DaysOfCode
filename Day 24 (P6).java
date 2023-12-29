// Sum Triangle for given array (GFG)

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int) (n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }

            Compute obj = new Compute();
            long Triangle[] = obj.getTriangle(a, n);
            int sz = Triangle.length;

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < sz; i++)
                output.append(Triangle[i] + " ");
            System.out.println(output);

        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Compute {

    public long[] getTriangle(long arr[], long n) {
        ArrayList<Long> total = new ArrayList<>();
        helper(arr, n, total);

        for (int j = 0; j < arr.length; j++) {
            total.add(arr[j]);
        }

        long[] temp = new long[(int) n * ((int) n + 1) / 2];
        for (int i = 0; i < total.size(); i++) {
            temp[i] = total.get(i);
        }
        return temp;
    }

    public void helper(long[] arr, long n, ArrayList<Long> total) {
        if (n == 0) {
            return;
        }
        long[] newarr = new long[(int) n - 1];
        for (int i = 0; i <= n - 2; i++) {
            newarr[i] = arr[i] + arr[i + 1];
        }
        helper(newarr, n - 1, total);
        for (int i = 0; i < newarr.length; i++) {
            total.add(newarr[i]);
        }
    }
}