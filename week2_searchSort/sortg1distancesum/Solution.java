package week2_searchSort.sortg1distancesum;

import java.util.Arrays;
//Sum of Manhattan distances between all pairs of points
//        Last Updated : 26 Mar, 2025
//        Given n integer coordinates. The task is to find the sum of the Manhattan distance between all pairs of coordinates.
//        Manhattan Distance between (x1, y1) and (x2, y2) is: |x1 – x2| + |y1 – y2|
//
//        Examples :
//
//        Input : n = 4, p1 = { -1, 5 }, p2 = { 1, 6 }, p3 = { 3, 5 }, p4 = { 2, 3 }
//        Output : 22
//        Explanation :
//        Distance of { 1, 6 }, { 3, 5 }, { 2, 3 } from { -1, 5 } are 3, 4, 5 respectively. Therefore, sum = 3 + 4 + 5 = 12.
//        Distance of { 3, 5 }, { 2, 3 } from { 1, 6 } are 3, 4 respectively. Therefore, sum = 12 + 3 + 4 = 19
//        Distance of { 2, 3 } from { 3, 5 } is 3. Therefore, sum = 19 + 3 = 22.
public class Solution {
    // Time complex:  o (nlogn)
    // sort the arr,  each iteration calculate (el*index)- sum till now add to result
    // it is equivalent to (x2-x1)+(x3-x2)+(x3-x1)...
    public static int distanceSum(int []x, int[]y){
        return calculateSum(x)+ calculateSum(y);
    }

    public static int calculateSum(int[] arr){
        Arrays.sort(arr);
        int sum=arr[0];
        int total=0;
        for(int i=1; i< arr.length; i++){
            total += ((arr[i]*i)-sum);
            sum+= arr[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int x[] = { -1, 1, 3, 2 };
        int y[] = { 5, 6, 5, 3 };
        System.out.println(distanceSum(x, y));
    }
}
