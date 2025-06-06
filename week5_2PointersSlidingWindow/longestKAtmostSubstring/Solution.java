package week5_2PointersSlidingWindow.longestKAtmostSubstring;

import java.util.HashMap;

public class Solution {

    public static String LongestKMost(String s, int k){
        int l=0; int r=0; int maxCount= 0;
        String res="";
        HashMap<Character, Integer> map = new HashMap<>();
        while(r< s.length()){
            char c= s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.size()>k){
                char leftc= s.charAt(l);
                map.put(leftc, map.get(leftc)-1);
                if(map.get(leftc)==0)
                    map.remove(leftc);
                l++;
            }
            if(r-l+1 > maxCount){
                res= s.substring(l, r+1);
                maxCount=Math.max(maxCount, r-l+1);
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        String res=LongestKMost("aababbaccccdcdcdcdc", 2);
        System.out.println(res);
    }
}
