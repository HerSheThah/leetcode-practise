package week4_recursionBacktrack.lexicographicOrderGFG;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//Power Set in Lexicographic order
//        Last Updated : 23 May, 2024
//        This article is about generating Power set in lexicographical order.
//        Examples :
//
//        Input : abc
//        Output : a ab abc ac b bc c
//        The idea is to sort array first. After sorting, one by one fix characters and recursively generates all subsets starting from them. After every recursive call, we remove last character so that next permutation can be generated.


public class Solution {
    // o(2^n) Time
    public static List<String> lexiCo(String a){
        List<String> res= new ArrayList<>();
        String cur="";
        Backtrack(0, a, res, cur);
        res.sort(Comparator.naturalOrder());
        return res;
    }

    private static void Backtrack(int index,String a, List<String> res, String curStr){
        if(curStr.length()> 0)
                res.add(curStr);
        if (index==a.length())
            return;
        for(int i=index; i<a.length(); i++){
            curStr+=a.charAt(i);
            Backtrack(i+1, a, res, curStr);
            curStr= curStr.substring(0, curStr.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(lexiCo("cba"));
    }
}
