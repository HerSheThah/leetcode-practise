package week5_2PointersSlidingWindow.lengthOfLongestSubstring3;
import java.util.HashSet;
//3. Longest Substring Without Repeating Characters
//        Solved
//        Medium
//        Topics
//        premium lock icon
//        Companies
//        Hint
//        Given a string s, find the length of the longest substring without duplicate characters.
//        Example 1:
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//        Constraints:
//        0 <= s.length <= 5 * 104
//        s consists of English letters, digits, symbols and spaces.

class Solution {
    // i, j pointer to start keep incrementing j while duplicate not found in set
    // If duplicate found add set sixe() to maxC and remove i (start) from set, continue.
    // Time => o(n), Space=> o(n)
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i=0; int j =0;
        int maxC=0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j));
                j++;
            }else{
                maxC= Math.max(maxC, set.size());
                set.remove(s.charAt(i));
                i++;
            }
        }
        maxC= Math.max(maxC, set.size());
        return maxC;
    }
}