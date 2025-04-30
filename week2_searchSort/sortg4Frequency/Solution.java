package week2_searchSort.sortg4Frequency;

import java.util.*;
//Sorting Elements of an Array by Frequency
//        Difficulty: MediumAccuracy: 37.02%Submissions: 69K+Points: 4
//        Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.
//
//        Input:
//        The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
//        Output:
//        For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space.
//
//        Constraints:
//        1 ≤ T ≤ 70
//        1 ≤ N ≤ 130
//        1 ≤ Ai ≤ 60
//
//        Example:
//        Input:
//        2
//        5
//        5 5 4 6 4
//        5
//        9 9 9 2 5
//
//        Output:
//        4 4 5 5 6
//        9 9 9 2 5
//
//        Explanation:
//        Testcase1: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are same then smaller element comes first. So 4 4 comes first then comes 5 5. Finally comes 6.
//        The output is 4 4 5 5 6.
//
//        Testcase2: The highest frequency here is 3. The element 9 has the highest frequency. So 9 9 9 comes first. Now both 2 and 5 have same frequency. So we print smaller element first.
//        The output is 9 9 9 2 5.
public class Solution {
    // Time complexity: o(nlogn)
    // Note frequencies in hashmap,
    // sort hashmap in desc by value, sort again asc if keys are same.
    public static void main (String[] args) {
        //code here
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i< n ; i++){
            int m = sc.nextInt();
            int[] arr= new int[m];
            for(int j=0; j<m; j++){
                arr[j]=sc.nextInt();
            }
            sortArray(arr, m);
        }
    }

    public static void sortArray(int[] arr, int n ){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< n ; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        List<Map.Entry<Integer, Integer>> list= new
                ArrayList<>(map.entrySet());
        list.sort((a, b)->{
            if(!b.getValue().equals(a.getValue()))
                return b.getValue()-a.getValue();
            else
                return a.getKey()-b.getKey();
        } );

        for(int i=0;i< list.size(); i++){
            int it=list.get(i).getValue();
            int val=list.get(i).getKey();
            while(it>0){
                System.out.print(val+" ");
                it--;
            }
        }
        System.out.println();
    }
}
