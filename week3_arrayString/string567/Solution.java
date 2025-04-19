package week3_arrayString.string567;

import java.util.HashMap;

//567. Permutation in String
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//
//        In other words, return true if one of s1's permutations is the substring of s2.
//
//
//
//        Example 1:
//
//        Input: s1 = "ab", s2 = "eidbaooo"
//        Output: true
//        Explanation: s2 contains one permutation of s1 ("ba").
//        Example 2:
//
//        Input: s1 = "ab", s2 = "eidboaoo"
//        Output: false
//
//
//        Constraints:
//
//        1 <= s1.length, s2.length <= 104
//        s1 and s2 consist of lowercase English letters.

public class Solution {
    // SOLUTION 1
    // public boolean checkInclusion(String s1, String s2) {
    //     if(s1.length()> s2.length())
    //         return false;
    //     HashMap<Character, Integer> map= new HashMap<>();
    //     int count=0;
    //     for(char ch: s1.toCharArray()){
    //         map.put(ch, map.getOrDefault(ch, 0)+1);
    //         count++;
    //     }
    //     HashMap<Character, Integer> dummy= new HashMap<>();
    //     for(int i=0; i< count; i++){
    //         char curch= s2.charAt(i);
    //         dummy.put(curch, dummy.getOrDefault(curch, 0)+1);
    //     }
    //     if(check(map, dummy))
    //         return true;

    //     for(int i=0, j=count; j<s2.length(); i++, j++){
    //         char remove=s2.charAt(i);
    //         if(dummy.get(remove)>1)
    //             dummy.put(remove, dummy.get(remove)-1);
    //         else
    //             dummy.remove(remove);
    //         char add= s2.charAt(j);
    //         if(dummy.containsKey(add))
    //             dummy.put(add, dummy.get(add)+1);
    //         else
    //             dummy.put(add, 1);

    //         System.out.println(dummy);
    //         boolean result =  check(map, dummy);
    //         System.out.println(result);
    //         if(result)
    //             return true;
    //     }



    //     return false;
    // }

    // private boolean check(HashMap<Character, Integer> map,
    // HashMap<Character, Integer> dummy){
    //     for(Map.Entry<Character, Integer> entry: map.entrySet()){
    //         char key = entry.getKey();
    //         if(!dummy.containsKey(key) || !dummy.get(key).equals(entry.getValue()))
    //             return false;
    //     }
    //     return true;
    // }

    // SOLUTION2
    public boolean checkInclusion(String s1, String s2){
        if (s1.length()> s2.length())
            return false;
        HashMap<Character, Integer> s1map= new HashMap<>();
        HashMap<Character, Integer> s2map= new HashMap<>();
        for(int i=0; i< s1.length(); i++){
            char s1ch= s1.charAt(i);
            char s2ch= s2.charAt(i);
            s1map.put(s1ch, s1map.getOrDefault(s1ch, 0)+1);
            s2map.put(s2ch, s2map.getOrDefault(s2ch, 0)+1);
        }
        if(s1map.equals(s2map))
            return true;

        for(int i=0,j=s1.length();j<s2.length();i++, j++){
            char right= s2.charAt(j);
            s2map.put(right, s2map.getOrDefault(right, 0)+1);
            char left = s2.charAt(i);
            if(s2map.get(left)==1)
                s2map.remove(left);
            else
                s2map.put(left, s2map.get(left)-1);

            if(s1map.equals(s2map))
                return true;
        }
        return false;

    }
}
