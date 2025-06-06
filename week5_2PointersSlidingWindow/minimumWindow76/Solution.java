package week5_2PointersSlidingWindow.minimumWindow76;

import java.util.HashMap;
import java.util.Map;
//76. Minimum Window Substring
//        Solved
//        Hard
//        Topics
//        premium lock icon
//        Companies
//        Hint
//        Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//
//        The testcases will be generated such that the answer is unique.
//
//
//
//        Example 1:
//
//        Input: s = "ADOBECODEBANC", t = "ABC"
//        Output: "BANC"
//        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//        Example 2:
//
//        Input: s = "a", t = "a"
//        Output: "a"
//        Explanation: The entire string s is the minimum window.
//        Example 3:
//
//        Input: s = "a", t = "aa"
//        Output: ""
//        Explanation: Both 'a's from t must be included in the window.
//        Since the largest window of s only has one 'a', return empty string.
//
//
//        Constraints:
//
//        m == s.length
//        n == t.length
//        1 <= m, n <= 105
//        s and t consist of uppercase and lowercase English letters.
//
//
//        Follow up: Could you find an algorithm that runs in O(m + n) time?
class Solution {
    // Solution1 time-> o(n*m) space o(n)
    // Two pointers to create a window of letters in s, which would have all the characters from t
    // Expand the right pointer until all the characters of t are covered.
    // Once all the characters are covered, move the left pointer and ensure that all the characters arestill covered to minimize the subarray size.
    // Continue expanding the right and left pointers until you reach the end of s.
    public String minWindow(String s, String t) {
        int l=0; int r=0;
        int minLen=Integer.MAX_VALUE;
        String res="";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i< t.length(); i++){
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0)+1);
        }

        while(r<s.length()){
            Character c= s.charAt(r);
            if(t.contains(c.toString()))
                map.put(c, map.getOrDefault(c, 0)+1);
            System.out.println(map);
            while(l<=r && isValid(map, map1)){
                if(r-l+1 < minLen){
                    minLen=r-l+1;
                    res= s.substring(l, r+1);
                }
                char lch=s.charAt(l);
                if(map.containsKey(lch)){
                    map.put(lch, map.get(lch)-1);
                    if(map.get(lch)==0)
                        map.remove(lch);
                }


                l++;
            }
            r++;
        }
        return res;
    }

    private boolean isValid(HashMap<Character, Integer>map, HashMap<Character,Integer> map1){
        if(map.size() != map1.size())
            return false;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            char key= entry.getKey();
            int val= entry.getValue();
            if(!map1.containsKey(key) || map1.get(key)>val)
                return false;
        }
        return true;
    }
}