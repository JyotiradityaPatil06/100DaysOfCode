// Equilibrium Point (GFG)

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();

            // calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends

class Solution {

    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        long sum1 = 0; // sum on left side
        long sum2 = 0; // sum on rigth side
        int eq = -1; // equilibrium point
        if (n == 1) {
            eq = 1;
        }
        for (int i = 1; i < n; i++) {
            sum2 += arr[i]; // first calculate sum on rigth
        }
        for (int i = 1; i < n; i++) {
            sum1 += arr[i - 1]; // add sum on left
            sum2 -= arr[i]; // remove sum from right

            if (sum1 == sum2) // check if both left and right sum equal
            {
                eq = i + 1;
                break;
            }

        }
        return eq;
    }
}
