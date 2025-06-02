package week5_2PointersSlidingWindow.binarySubarraySum930;
//930. Binary Subarrays With Sum
//        Solved
//        Medium
//        Topics
//        premium lock icon
//        Companies
//        Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
//        A subarray is a contiguous part of the array.
//        Example 1:
//        Input: nums = [1,0,1,0,1], goal = 2
//        Output: 4
//        Explanation: The 4 subarrays are bolded and underlined below:
//        [1,0,1,0,1]
//        [1,0,1,0,1]
//        [1,0,1,0,1]
//        [1,0,1,0,1]
//        Example 2:
//        Input: nums = [0,0,0,0,0], goal = 0
//        Output: 15
//        Constraints:
//        1 <= nums.length <= 3 * 104
//        nums[i] is either 0 or 1.
//        0 <= goal <= nums.length

class Solution {
    // To calculate  sum=goal calculate (sum<= goal) - (sum <= goal-1)
    // Time => o(2 2n) space => o(1)
    // while sum<=goal keep incrementing r count r-l+1 while
    // sum> goal keep incrementing l and sum-= arr[l] using sliding window
    public int numSubarraysWithSum(int[] nums, int goal) {
        return goalCount(nums, goal)- goalCount(nums, goal-1);
    }
    private  int goalCount(int[] nums, int goal){
        if(goal<0)
            return 0;
        int l=0; int r=0; int count=0; int sum=0;
        while(r<nums.length){
            sum+= nums[r];
            while(sum> goal){
                sum-= nums[l];
                l++;
            }
            count+= (r-l+1);
            r++;
        }
        return count;
    }
}