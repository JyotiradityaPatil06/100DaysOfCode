// Minimum sum (GFG)







import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            String ans = new Solution().solve(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java





class Solution {
    String solve(int[] arr, int n) {
        // code here
        Arrays.sort(arr);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        
        for(int i=0;i<n;i++){
            if(i%2!=0){
                a.append(""+arr[i]);
            }else{
                b.append(""+arr[i]);
            }
        }
        String sum = sum(a.reverse(), b.reverse());
        
        return sum;
    }
    
    String sum(StringBuilder a, StringBuilder b){
        int len = a.length() > b.length() ? a.length() : b.length();
        int carry = 0;
        StringBuilder temp = new StringBuilder();
        int i=0,j = 0;
        while(i<len || carry!=0){
            int d1 = i>=a.length() ? 0 : Character.getNumericValue(a.charAt(i));
            int d2 = i>=b.length() ? 0 : Character.getNumericValue(b.charAt(i));
            int sum = d1+d2+carry;
            carry = sum/10;
            sum = sum%10;
            temp.append(""+sum);
            ++i;
        }
        temp.reverse();
      
        //trim leading zeros
        i=0;
        while(i<temp.length() && temp.charAt(i)=='0'){
            i++;
        }
        if(i==temp.length())return "0"; 
        return temp.toString().substring(i);
    }
}


