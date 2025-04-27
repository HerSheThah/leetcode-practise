package week2_searchSort.search719;
import java.util.Arrays;
//719. Find K-th Smallest Pair Distance
//        Solved
//        Hard
//        Topics
//        Companies
//        Hint
//        The distance of a pair of integers a and b is defined as the absolute difference between a and b.
//
//        Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
//        Example 1:
//
//        Input: nums = [1,3,1], k = 1
//        Output: 0
//        Explanation: Here are all the pairs:
//        (1,3) -> 2
//        (1,1) -> 0
//        (3,1) -> 2
//        Then the 1st smallest distance pair is (1,1), and its distance is 0.
//        Example 2:
//
//        Input: nums = [1,1,1], k = 2
//        Output: 0
//        Example 3:
//
//        Input: nums = [1,6,1], k = 3
//        Output: 5
//
//
//        Constraints:
//
//        n == nums.length
//        2 <= n <= 104
//        0 <= nums[i] <= 106
//        1 <= k <= n * (n - 1) / 2
class Solution {
    // o(nlogn+ nlongn)
    // sort the array, find mid of maxdistance - 0
    // count pairs <= mid using sliding window (distance>mid l++ else r++)
    // distance<k left=mid+1 else right=mid
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low=0;
        int high = nums[n-1]-nums[0];
        while(low< high){
            int mid = low + (high - low)/2;
            int l= 0;
            int count=0;
            for(int r=1; r< n; r++){
                while(nums[r]-nums[l]> mid)
                    l++;
                count += r-l;
            }

            if(count< k)
                low=mid+1;
            else
                high =mid;
        }
        return low;
    }
}