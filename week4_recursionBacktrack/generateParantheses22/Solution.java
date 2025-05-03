package week4_recursionBacktrack.generateParantheses22;

import java.util.ArrayList;
import java.util.List;
//        22. Generate Parentheses
//        Solved
//        Medium
//        Topics
//        Companies
//        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//        Example 1:
//
//        Input: n = 3
//        Output: ["((()))","(()())","(())()","()(())","()()()"]
//        Example 2:
//
//        Input: n = 1
//        Output: ["()"]
//
//
//        Constraints:
//
//        1 <= n <= 8

class Solution {
    public List<String> generateParenthesis(int n) {
        int l=n;
        int r=n;
        String s="";
        List<String> res= new ArrayList<>();
        parath(l, r, s, res);
        return res;
    }

    private static void parath(int l, int r, String s, List<String> res){
        // time complex- o(4^n/root(n))  space=> o(n)
        // try all valid parantheses by traversing
        if(l==0 && r==0){
            res.add(s);
            return;
        }
        if(l>r)
            return;
        if(l>0)
            parath(l-1, r, s+"(", res);
        parath(l, r-1, s+")", res);

    }
}