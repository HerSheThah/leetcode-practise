package week3_arrayString.string1614;
//1614. Maximum Nesting Depth of the Parentheses
//        Solved
//        Easy
//        Topics
//        Companies
//        Hint
//        Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
//
//
//
//        Example 1:
//
//        Input: s = "(1+(2*3)+((8)/4))+1"
//
//        Output: 3
//
//        Explanation:
//
//        Digit 8 is inside of 3 nested parentheses in the string.
//
//        Example 2:
//
//        Input: s = "(1)+((2))+(((3)))"
//
//        Output: 3
//
//        Explanation:
//
//        Digit 3 is inside of 3 nested parentheses in the string.
//
//        Example 3:
//
//        Input: s = "()(())((()()))"
//
//        Output: 3
//
//
//
//        Constraints:
//
//        1 <= s.length <= 100
//        s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
//        It is guaranteed that parentheses expression s is a VPS.

class Solution {
    public int maxDepth(String s) {
        int count=0;
        int maxcount=0;
        for(int i=0; i< s.length();i++){
            char ch= s.charAt(i);
            if(ch=='(')
                count++;
            else if (ch==')'){
                maxcount= Math.max(count, maxcount);
                count--;
            }
        }
        maxcount= Math.max(count, maxcount);
        return maxcount;
    }
}