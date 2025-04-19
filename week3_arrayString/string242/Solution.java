package week3_arrayString.string242;
//242. Valid Anagram
//        Solved
//        Easy
//        Topics
//        Companies
//        Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//
//        Output: true
//
//        Example 2:
//
//        Input: s = "rat", t = "car"
//
//        Output: false
//        Constraints:
//
//        1 <= s.length, t.length <= 5 * 104
//        s and t consist of lowercase English letters.
//
//
//        Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?



import java.util.HashMap;

class Solution {
    public static boolean isAnagram(String s, String t){
        if(s.length()!= t.length())
            return false;
        HashMap<Character, Integer> smap = new HashMap<>();
        for(int i=0; i< s.length();i++){
            char sch=s.charAt(i);
            smap.put(sch, smap.getOrDefault(sch, 0)+1);
        }
        for(int i=0; i< s.length();i++){
            char tch=t.charAt(i);
            if(! smap.containsKey(tch) || smap.get(tch)==0)
                return false;
            smap.put(tch, smap.get(tch)-1);
        }
        return true;
    }
}