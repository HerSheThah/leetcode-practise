package week5_2PointersSlidingWindow.subarraysWithKDistinct992;

import java.util.HashMap;
//992. Subarrays with K Different Integers
//        Solved
//        Hard
//        Topics
//        premium lock icon
//        Companies
//        Hint
//        Given an integer array nums and an integer k, return the number of good subarrays of nums.
//
//        A good array is an array where the number of different integers in that array is exactly k.
//
//        For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//        A subarray is a contiguous part of an array.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,1,2,3], k = 2
//        Output: 7
//        Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
//        Example 2:
//
//        Input: nums = [1,2,1,3,4], k = 3
//        Output: 3
//        Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
//
//
//        Constraints:
//
//        1 <= nums.length <= 2 * 104
//        1 <= nums[i], k <= nums.length
class Solution {
    // brute force time -> o(n^2) TLE error will occur.
    // public int subarraysWithKDistinct(int[] nums, int k) {
    //     int n = nums.length;
    //     int count=0;
    //     for(int i=0; i<n; i++){
    //         HashSet<Integer> set = new HashSet<>();
    //         set.add(nums[i]);
    //          if(set.size()==k)
    //                 count++;
    //         for(int j=i+1; j<n; j++){
    //             set.add(nums[j]);
    //             if(set.size()==k)
    //                 count++;
    //             else if (set.size()>k)
    //                 break;

    //         }
    //     }

    //     return count;
    // }

    // Solution2 sliding window and 2 pointer
    // same logic as 930
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getMaxCount(nums, k) - getMaxCount(nums, k-1);
    }

    private int getMaxCount(int[] nums, int k){
        if(k<=0)
            return 0;
        int l=0; int r=0;
        int count=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r<nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(map.size()>k){
                int val=map.get(nums[l]);
                if(val==1)
                    map.remove(nums[l]);
                else
                    map.put(nums[l], val-1);
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
}