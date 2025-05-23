package week4_recursionBacktrack.reverseString344;
//344. Reverse String
//        Solved
//        Easy
//        Topics
//        Companies
//        Hint
//        Write a function that reverses a string. The input string is given as an array of characters s.
//
//        You must do this by modifying the input array in-place with O(1) extra memory.
//
//
//
//        Example 1:
//
//        Input: s = ["h","e","l","l","o"]
//        Output: ["o","l","l","e","h"]
//        Example 2:
//
//        Input: s = ["H","a","n","n","a","h"]
//        Output: ["h","a","n","n","a","H"]
//
//
//        Constraints:
//
//        1 <= s.length <= 105
//        s[i] is a printable ascii character.
class Solution {
    public static void reverseString(char[] s) {
        int l =0;
        int r= s.length-1;
        rev(s, l, r);
    }

    public static void rev(char[] s, int l, int r){
        if(l>=r)
            return;
        char temp = s[l];
        s[l]=s[r];
        s[r]=temp;
        l++;
        r--;
        rev(s, l, r);
    }
}