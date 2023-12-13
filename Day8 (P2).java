// Smallest distinct window (GFG)
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public int findSubString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int matchCount = 0, size = str.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++)
            set.add(str.charAt(i));
        int uniqueCount = set.size();
        int maxLen = str.length();
        int left = 0;
        // first we need to get the length where all the unique character has
        // then reduce from left, until unique count is not change
        // when unique count change, then we have to start to aquire from right
        for (int right = 0; right < size; right++) {

            char ch = str.charAt(right);

            if (matchCount < uniqueCount) {

                if (map.containsKey(ch) == false) {
                    map.put(ch, 1);
                    matchCount++;
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
            if (matchCount == uniqueCount) {

                maxLen = Math.min(maxLen, right - left + 1);

                while (left < size && matchCount == uniqueCount) {

                    char leftChar = str.charAt(left);
                    if (map.get(leftChar) == 1) {
                        matchCount--;
                        map.remove(leftChar);
                        left++;
                        break;
                    } else {
                        map.put(leftChar, map.get(leftChar) - 1);
                        left++;
                        maxLen = Math.min(maxLen, right - left + 1);
                    }

                }
            }
        }
        return maxLen;
    }
}
