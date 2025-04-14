package week3_arrayString.arrayg3;

//Missing in Array
//        Difficulty: EasyAccuracy: 29.59%Submissions: 1.3MPoints: 2Average Time: 15m
//        You are given an array arr of size n - 1 that contains distinct integers in the range from 1 to n (inclusive). This array represents a permutation of the integers from 1 to n with one element missing. Your task is to identify and return the missing element.
//
//        Examples:
//
//        Input: arr[] = [1, 2, 3, 5]
//        Output: 4
//        Explanation: All the numbers from 1 to 5 are present except 4.
//        Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
//        Output: 6
//        Explanation: All the numbers from 1 to 8 are present except 6.
//        Input: arr[] = [1]
//        Output: 2
//        Explanation: Only 1 is present so the missing element is 2.
//        Constraints:
//        1 ≤ arr.size() ≤ 106
//        1 ≤ arr[i] ≤ arr.size() + 1
class Solution {
    int missingNumber(int arr[]) {
        // solution1
        // Arrays.sort(arr);
        // int n=arr.length;
        // for(int i=0;i<n ;i++){
        //     if(arr[i]!=i+1)
        //         return i+1;
        // }
        // return n+1;

        // solution2
        int n=arr.length;
        int[] dummy= new int[n+1];
        for(int i=0; i< n;i++){
            dummy[arr[i]-1]=1;
        }

        for(int i=0;i<dummy.length;i++){
            if(dummy[i]==0)
                return i+1;
        }
        return -1;
    }
}