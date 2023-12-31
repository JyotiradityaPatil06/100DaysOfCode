// Kth smallest element (GFG)

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int k = sc.nextInt();
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, 0, n - 1, k));
        }
        out.flush();
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        // Your code here
        findKthSmallest(arr, 0, r, k - 1);
        return arr[k - 1];
    }

    public static void findKthSmallest(int[] arr, int start, int end, int indexToFind) {
        if (start >= end) {
            return;
        }
        int pivotIndex = new Random().nextInt(end - start) + start;
        int pivot = arr[pivotIndex];

        int smaller = start;
        int currentPointer = start + 1;
        // bring pivot to the left
        swap(arr, start, pivotIndex);

        while (currentPointer <= end) {
            if (arr[currentPointer] < pivot) {
                smaller++;
                swap(arr, smaller, currentPointer);
            }
            currentPointer++;
        }
        // bring pivot back to its position
        swap(arr, smaller, start);
        pivotIndex = smaller;

        if (pivotIndex == indexToFind) {
            return;
        } else if (pivotIndex > indexToFind) { // search left
            findKthSmallest(arr, start, pivotIndex - 1, indexToFind);
        } else { // search right
            findKthSmallest(arr, pivotIndex + 1, end, indexToFind);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
