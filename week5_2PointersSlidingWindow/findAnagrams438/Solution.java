package week5_2PointersSlidingWindow.findAnagrams438;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//438. Find All Anagrams in a String
//        Solved
//        Medium
//        Topics
//        premium lock icon
//        Companies
//        Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//        Example 1:
//        Input: s = "cbaebabacd", p = "abc"
//        Output: [0,6]
//        Explanation:
//        The substring with start index = 0 is "cba", which is an anagram of "abc".
//        The substring with start index = 6 is "bac", which is an anagram of "abc".
//        Example 2:
//        Input: s = "abab", p = "ab"
//        Output: [0,1,2]
//        Explanation:
//        The substring with start index = 0 is "ab", which is an anagram of "ab".
//        The substring with start index = 1 is "ba", which is an anagram of "ab".
//        The substring with start index = 2 is "ab", which is an anagram of "ab".
//        Constraints:
//        1 <= s.length, p.length <= 3 * 104
//        s and p consist of lowercase English letters.

public class Solution {
    // Solution1 => so much o(n * mlogn) time and memory o(m)
     public List<Integer> findAnagrams(String s, String p) {
         List<Integer> res= new ArrayList<>();
         int n=s.length();
         int m= p.length();
         char[] pchar= p.toCharArray();
         Arrays.sort(pchar);
         p=new String(pchar);
         for(int i=0; i<= n-m; i++){
             char[] temp=s.substring(i, i+m).toCharArray();
             Arrays.sort(temp);
             String compare=new String(temp);
             if(compare.equals(p))
                 res.add(i);
         }
         return res;
     }
}
