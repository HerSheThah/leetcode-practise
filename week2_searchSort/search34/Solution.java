package week2_searchSort.search34;

//34. Find First and Last Position of Element in Sorted Array
//        Solved
//        Medium
//        Topics
//        Companies
//        Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//        If target is not found in the array, return [-1, -1].
//
//        You must write an algorithm with O(log n) runtime complexity.
//        Example 1:
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]
//        Example 3:
//
//        Input: nums = [], target = 0
//        Output: [-1,-1]


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l= binarysearch(nums, target, true);
        int r= binarysearch(nums, target, false);
        return new int[]{l, r};
    }

    public static int binarysearch(int[] nums,int target, boolean isfirst){
        int l=0;
        int r=nums.length-1;
        int index=-1;
        while(l<=r){
            int mid= (l+r)/2;
            if(nums[mid]==target){
                index=mid;
                if(isfirst){
                    r=mid-1;
                }else{
                    l=mid+1;
                }

            }else if (target< nums[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
    }

}