package week3_arrayString.arrayg1;

//Wave Array
//        Difficulty: EasyAccuracy: 63.69%Submissions: 266K+Points: 2Average Time: 20m
//        Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place). In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
//        If there are multiple solutions, find the lexicographically smallest one.
//
//        Note: The given array is sorted in ascending order, and you don't need to return anything to change the original array.
//
//        Examples:
//
//        Input: arr[] = [1, 2, 3, 4, 5]
//        Output: [2, 1, 4, 3, 5]
//        Explanation: Array elements after sorting it in the waveform are 2, 1, 4, 3, 5.
//        Input: arr[] = [2, 4, 7, 8, 9, 10]
//        Output: [4, 2, 8, 7, 10, 9]
//        Explanation: Array elements after sorting it in the waveform are 4, 2, 8, 7, 10, 9.
//
//        Input: arr[] = [1]
//        Output: [1]
//        Constraints:
//        1 ≤ arr.size ≤ 106
//        0 ≤ arr[i] ≤107

class Solution {
    public static void convertToWave(int[] arr) {
        // code here
        for(int i=1; i<arr.length;i=i+2){
            int temp=arr[i-1];
            arr[i-1]=arr[i];
            arr[i]=temp;
        }
    }
}