package week5_2PointersSlidingWindow.characterReplacement424;
//424. Longest Repeating Character Replacement
//        Solved
//        Medium
//        Topics
//        premium lock icon
//        Companies
//        You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//        Return the length of the longest substring containing the same letter you can get after performing the above operations.
//        Example 1:
//        Input: s = "ABAB", k = 2
//        Output: 4
//        Explanation: Replace the two 'A's with two 'B's or vice versa.
//        Example 2:
//        Input: s = "AABABBA", k = 1
//        Output: 4
//        Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//        The substring "BBBB" has the longest repeating letters, which is 4.
//        There may exists other ways to achieve this answer too.
//        Constraints:
//
//        1 <= s.length <= 105
//        s consists of only uppercase English letters.
//        0 <= k <= s.length


class Solution {
    // Solution1 Time -> o(n)space o(26)
    //  For every window find max occuring elements count
    // if r-l+1 - count > k increment l and remove from dictionary
    // else add r to dictionary and increment r
    // public int characterReplacement(String s, int k) {
    //     if(s.length()==1)
    //         return 1;
    // int l=0;
    // HashMap<Character, Integer> map= new HashMap<>();
    // map.put(s.charAt(0), 1);
    // int r=0;
    // int res=0;
    // while(r<s.length()){
    //     int maxval=getMaxVal(map);
    //     int rep=(r-l+1)-maxval;
    //     if(rep>k){
    //         map.put(s.charAt(l), map.get(s.charAt(l))-1);
    //         l++;
    //     }else{
    //         res= Math.max(res, r-l+1);
    //         r++;
    //         if(r<s.length())
    //             map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
    //     }
    // }
    // return res;
    // }
    // public int getMaxVal(HashMap<Character, Integer> map){
    //     int res=0;
    //     for(int val:map.values()){
    //         res=Math.max(val, res);
    //     }
    //     return res;
    // }


    // Solution2 without using hashmap
    // Have arr[26] for loop add r count get latest r value for maxelement,
    // get r-l+1 - max for replace elemet count
    // if >k increment i by reducing arr [l]
    //else add r-l+1 count to res if its
    public int characterReplacement(String s, int k) {
        if(s.length()==1)
            return 1;
        int[] arr = new int[26];
        int l=0; int r=0;
        int max=0;
        int res=0;
        while(r<s.length()){
            arr[s.charAt(r)-'A']+=1;
            max=Math.max(max, arr[s.charAt(r)-'A']);
            if(r-l+1-max > k){
                arr[s.charAt(l)-'A']--;
                l++;
            }
            res= Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}

