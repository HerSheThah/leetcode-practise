package week4_recursionBacktrack.nQueens51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//51. N-Queens
//        Solved
//        Hard
//        Topics
//        Companies
//        The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//
//        Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//        Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
//        Example 1:
//        Input: n = 4
//        Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//        Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
//        Example 2:
//        Input: n = 1
//        Output: [["Q"]]
//        Constraints:
//
//        1 <= n <= 9

class Solution {
    private List<List<String>> finalres=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] store= new String[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(store[i], ".");
        }
        backtrack(0, store, n);
        return finalres;
    }

    private void backtrack(int col, String[][] store, int n){
        if(col==n){
            List<String> res= new ArrayList<>();
            for(int i=0; i< n ; i++){
                String s ="";
                for(int j=0; j<n; j++){
                    s+= store[i][j];
                }
                res.add(s);
            }
            finalres.add(res);
            System.out.println(Arrays.deepToString(store));
            return;
        }

        for(int row=0; row<n;row++){
            if(isValid(row, col, store, n)){
                store[row][col]="Q";
                backtrack(col+1, store, n);
                store[row][col]=".";
            }
        }

    }

    private boolean isValid(int r, int c, String[][] store, int n){
        //same row
        for(int j=0; j<c; j++){
            if(store[r][j]=="Q")
                return false;
        }
        //upper diagonal
        for(int row=r-1,col=c-1; row>=0 && col>=0 ;row--, col--){
            if(store[row][col]=="Q")
                return false;
        }
        //lower diagonal
        for(int row=r+1, col=c-1; row<n && col>=0 ; row++,col--){
            if(store[row][col]=="Q")
                return false;
        }
        return true;
    }
}