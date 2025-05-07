package week4_recursionBacktrack.subsetsTwo90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
//90. Subsets II
//        Solved
//        Medium
//        Topics
//        Companies
//        Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//        The solution set must not contain duplicate subsets. Return the solution in any order.
//        Example 1:
//
//        Input: nums = [1,2,2]
//        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
//        Example 2:
//
//        Input: nums = [0]
//        Output: [[],[0]]
//        Constraints:
//
//        1 <= nums.length <= 10
//        -10 <= nums[i] <= 10

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> arr= new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        boolean[] elements = new boolean[nums.length];
        backtrack(0, nums, res, arr, set, elements);
        return res;

    }

    private static void backtrack(int index, int[] nums, List<List<Integer>> res, List<Integer> arr, HashSet<List<Integer>> set, boolean[] elements){
        // System.out.println("set:"+ set);
        // System.out.println("arr:"+ arr);
        if(!set.contains(arr)){
            set.add(new ArrayList<>(arr));
            res.add(new ArrayList<>(arr));
        }
        if(index==nums.length)
            return;
        for(int i=index; i<nums.length;i++){
            if(!elements[i]){
                elements[i]=true;
                arr.add(nums[i]);
                backtrack(i+1, nums, res, arr, set, elements);
                elements[i]=false;
                arr.remove(arr.size()-1);
            }
        }
    }
}