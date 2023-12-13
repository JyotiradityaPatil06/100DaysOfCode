// Leetcode 1021. Remove Outermost Parentheses

public class Day 8 (P1) {
    class Solution {
        public String removeOuterParentheses(String s) {
            Stack<Character> stack = new Stack<>();
            StringBuilder res = new StringBuilder();
        
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    if(stack.size()>=1){
                        res.append(""+s.charAt(i));
                    }
                    stack.push(s.charAt(i));
                }else{
                
                    if(stack.size()>1){
                        res.append(""+s.charAt(i));
                    }
                    stack.pop();
                }
            }
        
            return res.toString();
        }
    }
}
