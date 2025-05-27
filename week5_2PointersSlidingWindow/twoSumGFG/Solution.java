package week5_2PointersSlidingWindow.twoSumGFG;

import java.util.HashSet;
//Two Sum - Pair with Given Sum
//        Difficulty: EasyAccuracy: 30.61%Submissions: 374K+Points: 2Average Time: 20m
//        Given an array arr[] of positive integers and another integer target. Determine if there exist two distinct indices such that the sum of their elements is equal to the target.
//        Examples:
//
//        Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
//        Output: true
//        Explanation: arr[3] + arr[4] = 6 + 10 = 16.
//        Input: arr[] = [1, 2, 4, 3, 6], target = 11
//        Output: false
//        Explanation: None of the pair makes a sum of 11.
//        Input: arr[] = [11], target = 11
//        Output: false
//        Explanation: No pair is possible as only one element is present in arr[].
//        Constraints:
//        1 ≤ arr.size ≤ 105
//        1 ≤ arr[i] ≤ 105
//        1 ≤ target ≤ 2*105
class Solution {
    // o(nlog n)
    // boolean twoSum(int arr[], int target) {
    //     Arrays.sort(arr);
    //     int l=0;
    //     int r=arr.length-1;
    //     while(l<r){
    //         int sum=arr[l]+arr[r];
    //         if(sum==target)
    //             return true;
    //         if(sum>target)
    //             r--;
    //         else
    //             l++;
    //     }
    //     return false;
    // }

    // Time o(n) space o(n)
    boolean twoSum(int arr[], int target) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< arr.length;i++){
            if(set.contains(target-arr[i]))
                return true;
            set.add(arr[i]);
        }
        return false;
    }
}