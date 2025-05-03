package week4_recursionBacktrack.combinations77;

import java.util.ArrayList;
import java.util.List;
//77. Combinations
//        Medium
//        Topics
//        Companies
//        Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
//
//        You may return the answer in any order.
//
//
//
//        Example 1:
//
//        Input: n = 4, k = 2
//        Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//        Explanation: There are 4 choose 2 = 6 total combinations.
//        Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
//        Example 2:
//
//        Input: n = 1, k = 1
//        Output: [[1]]
//        Explanation: There is 1 choose 1 = 1 total combination.
//
//
//        Constraints:
//
//        1 <= n <= 20
//        1 <= k <= n
class Solution {
    // backtrack from last digit until <=n; return if length matches k
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> path= new ArrayList<>();
        backtrack(1, n, k,path, res );
        return res;
    }

    private static void backtrack(int i, int n, int k, List<Integer> path,List<List<Integer>> res){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j =i; j<=n; j++){
            path.add(j);
            backtrack(j+1, n, k, path, res);
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {
        int n=5; int k=5;
        combine(n, k);
    }
}