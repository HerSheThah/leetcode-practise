package week5_2PointersSlidingWindow.niceSubarrayCount1248;
//1248. Count Number of Nice Subarrays
//        Solved
//        Medium
//        Topics
//        premium lock icon
//        Companies
//        Hint
//        Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
//        Return the number of nice sub-arrays.
//        Example 1:
//        Input: nums = [1,1,2,1,1], k = 3
//        Output: 2
//        Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
//        Example 2:
//        Input: nums = [2,4,6], k = 1
//        Output: 0
//        Explanation: There are no odd numbers in the array.
//        Example 3:
//        Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//        Output: 16
//        Constraints:
//        1 <= nums.length <= 50000
//        1 <= nums[i] <= 10^5
//        1 <= k <= nums.length
class Solution {
    // Same as binary subarray problem 930, change all even as 0 odd as 1
    // and follow the same as other problem
    public int numberOfSubarrays(int[] nums, int k) {
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i]%2==0)
        //         nums[i]=0;
        //     else
        //         nums[i]=1;
        // }
        return countOdd(nums, k)-countOdd(nums, k-1);
    }

    public int countOdd(int[] nums, int k){
        int l=0; int r=0; int sum=0; int count=0;
        while(r<nums.length){
            sum+= nums[r]%2;
            while(sum> k){
                sum-= nums[l]%2;
                l++;
            }
            count+= r-l+1;
            r++;
        }
        return count;
    }
}