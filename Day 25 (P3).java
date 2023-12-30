// Insertion Sort (GFG)

//{ Driver Code Starts
import java.util.*;
import java.lang.Math;

class Sorting {

    static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            new Solution().insertionSort(a, n);
            printArray(a, n);

            t--;
        }

    }
}
// } Driver Code Ends

class Solution {
    static void insert(int arr[], int i) {
        // Your code here
        int k = i - 1;
        arr[k] = arr[k] ^ arr[i];
        arr[i] = arr[k] ^ arr[i];
        arr[k] = arr[k] ^ arr[i];
        k--;
        i--;
        if (k > -1 && arr[k] > arr[i])
            insert(arr, i);
        return;
    }

    // Function to sort the array using insertion sort algorithm.
    public void insertionSort(int arr[], int n) {
        // code here
        int i = 0;
        for (int j = 1; j < n; j++) {
            i = j - 1;
            if (arr[i] > arr[j])
                insert(arr, j);
        }
    }
}