package week5_2PointersSlidingWindow.longestOnes1004;

//1004. Max Consecutive Ones III
//        Solved
//        Medium
//        Topics
//        premium lock icon
//        Companies
//        Hint
//        Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//        Example 1:
//        Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//        Output: 6
//        Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//        Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//        Example 2:
//        Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//        Output: 10
//        Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//        Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//        Constraints:
//
//        1 <= nums.length <= 105
//        nums[i] is either 0 or 1.
//        0 <= k <= nums.length

class Solution {
    // same as characterReplacement 424
    // if r is 1 max++ see if gapes to fill 0 is >k then decrement l and max count if left is 1
    // else add that subarray length to result
    public int longestOnes(int[] nums, int k) {
        int l=0; int r=0;
        int max=0;
        int res=0;
        while(r<nums.length){
            if(nums[r]==1)
                max++;
            if(r-l+1-max>k){
                if(nums[l]==1)
                    max--;
                l++;
            }else{
                res=Math.max(res, r-l+1);
                r++;
            }
        }
        return res;
    }
}