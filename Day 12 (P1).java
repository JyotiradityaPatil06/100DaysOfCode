// Counting elements in two arrays (GFG)

//{ Driver Code Starts
import java.util.*;

class Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int arr1[] = new int[m];
            int arr2[] = new int[n];

            for (int i = 0; i < m; i++)
                arr1[i] = sc.nextInt();

            for (int i = 0; i < n; i++)
                arr2[i] = sc.nextInt();

            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }

    }
}
// } Driver Code Ends

// Complete the function given below
class Solution {
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        Arrays.sort(arr2);
        int count = 0;
        for (int i = 0; i < m; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (arr2[j] <= arr1[i])
                    count++;
                else
                    break;
            }
            a.add(count);
        }
        return a;
    }
}
