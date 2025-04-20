package week3_arrayString.arrayg5subarraySum;
//Sum of Subarrays
//        Difficulty: MediumAccuracy: 23.85%Submissions: 25K+Points: 4
//        Given an array arr. Find the sum of all subarrays of the array since the sum could be very large print the sum modulo (109+7).
//
//        Examples:
//
//        Input: arr[] = [1, 2, 3]
//        Output: 20
//        Explanation: All subarray sums are: [1] = 1, [2] = 2, [3] = 3, [1,2] = 3, [2,3] = 5, [1,2,3] = 6. Thus total sum is 1+2+3+3+5+6 = 20.
//        Input: arr[] = [1, 3]
//        Output: 8
//        Explanation: All subarray sums are: [1] = 1 [3] = 3 [1,3] = 4. Thus total sum is 1+3+4 = 8.
//        Expected Time Complexity: O(n)
//        Expected Auxiliary Space: O(1)
//
//        Constraints :
//        1 ≤ arr.size() ≤ 106
//        1 ≤ arr[i] ≤ 109


class Solution {
//    For an element at index i, how many subarrays is it part of?
//    Use this count to compute its total contribution efficiently.
    public long subarraySum(int[] arr) {
        long sum=0;
        long mod=1000000007;
        int n = arr.length;
        for(int i=0; i< arr.length; i++){
            long res=((long)arr[i]* (n-i)*(i+1))%mod;
            sum= (sum+res)%mod;
        }
        return sum;

    }
}
