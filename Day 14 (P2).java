// Subarray with given sum (GFG)

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String s[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for (int ii = 0; ii < res.size(); ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends

class Solution {
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> a = new ArrayList<>();
        int sum = 0;
        int i, j;
        i = j = 0; // Set two pointers i,j to the 1st position
        while (j < n) {
            sum += arr[j]; // Increment sum till sum>s to find the pos of ub/j
            while (sum > s) { // Increment i till sum<=s
                sum -= arr[i];
                i++;
            }
            if (sum == s) { // Subarray found
                if (i > j)
                    break;
                a.add(i + 1);
                a.add(j + 1);
                break;
            }
            j++;
        }
        if (a.isEmpty())
            a.add(-1); // No subarray found
        return a;
    }
}
