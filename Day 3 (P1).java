// Find pair given difference (GFG)

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int l = sc.nextInt();
            int n = sc.nextInt();

            int arr[] = new int[l];

            for (int i = 0; i < l; i++)
                arr[i] = sc.nextInt();

            Solution ob = new Solution();

            if (ob.findPair(arr, l, n) == true)
                System.out.println(1);

            else
                System.out.println(-1);

        }

    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public boolean findPair(int arr[], int size, int n) {
        HashSet<Integer> list = new HashSet<Integer>();

        for (int a : arr) {
            list.add(a);
        }
        if (n == 0 && list.size() == size)
            return false;
        for (int i = 0; i < size; i++) {
            int y = arr[i] + n;
            if (list.contains(y))
                return true;
        }
        return false;
    }

}