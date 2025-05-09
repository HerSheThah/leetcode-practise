package week2_searchSort.search540;
//540. Single Element in a Sorted Array
//        Solved
//        Medium
//        Topics
//        Companies
//        You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
//
//        Return the single element that appears only once.
//
//        Your solution must run in O(log n) time and O(1) space.
//        Example 1:
//
//        Input: nums = [1,1,2,3,3,4,4,8,8]
//        Output: 2
//        Example 2:
//
//        Input: nums = [3,3,7,7,10,11,11]
//        Output: 10
//
//
//        Constraints:
//
//        1 <= nums.length <= 105
//        0 <= nums[i] <= 105
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r= nums.length-1;
        while(l < r){
            int mid= (l+r)/2;
            if(nums[mid-1]== nums[mid]){
                if(mid%2==0)
                    r=mid-2;
                else
                    l=mid+1;
            }
            else if (nums[mid]== nums[mid+1]){
                if(mid%2==0)
                    l=mid+2;
                else
                    r=mid-1;
            }
            else
            {
                return nums[mid];
            }
        }
        return nums[l];
    }
}