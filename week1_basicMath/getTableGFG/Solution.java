package week1_basicMath.getTableGFG;

import java.util.ArrayList;

class Solution {
//    Time complexity o(10)
    static ArrayList<Integer> getTable(int n) {
        // code here
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=1; i<=10;i++)
            arr.add(n*i);
        return arr;
    }
}