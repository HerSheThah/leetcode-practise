package week4_recursionBacktrack.permuteUnique47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//47. Permutations II
//        Solved
//        Medium
//        Topics
//        Companies
//        Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [1,1,2]
//        Output:
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        Example 2:
//
//        Input: nums = [1,2,3]
//        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//        Constraints:
//
//        1 <= nums.length <= 8
//        -10 <= nums[i] <= 10
class Solution {
    //Solution1 without using backtracking using loop
    // public List<List<Integer>> permuteUnique(int[] nums) {
    //     Arrays.sort(nums);
    //     List<List<Integer>> res= new ArrayList<>();
    //     List<Integer> t = Arrays.stream(nums).boxed().collect(Collectors.toList());
    //     res.add(new ArrayList<>(t));

    //     int n = nums.length;
    //     int i=n-1;
    //     while(i>0){
    //         System.out.println("i"+i);
    //         System.out.println(Arrays.toString(nums));
    //         if(nums[i-1]<nums[i]){
    //             int minInd=mini(i, n, nums, nums[i-1]);
    //             int temp=nums[minInd];
    //             nums[minInd]=nums[i-1];
    //             nums[i-1]=temp;
    //             Arrays.sort(nums, i, n);
    //             t = Arrays.stream(nums).boxed().collect(Collectors.toList());
    //             res.add(new ArrayList<>(t));
    //             i=n-1;
    //         }
    //         else
    //             i--;
    //     }

    //     return res;
    // }

    // private static int mini(int i, int n, int[] nums, int cur){
    //     int min= i;
    //     int mVal=nums[i];
    //     for(int j =i+1; j<n; j++){

    //         if(nums[j]<mVal && nums[j]>cur){
    //                 mVal=nums[j];
    //                 min=j;
    //         }
    //     }
    //     return min;
    // }

    // Solution2, backtracking and recursion
    public List<List<Integer>> permuteUnique(int[] nums){
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> arr= new ArrayList<>();
        int n = nums.length;
        boolean[] track= new boolean[n];
        backtrack(nums, n, res, arr, track, set);
        return res;
    }

    private static void backtrack(int[] nums, int n, List<List<Integer>> res, List<Integer> arr, boolean[] track,
                                  Set<List<Integer>> set){
        if(arr.size()==n){
            if(!set.contains(arr)){
                set.add(arr);
                res.add(new ArrayList<>(arr));
            }
            return;
        }
        for(int i=0; i< n; i++){
            if(!track[i]){
                track[i]=true;
                arr.add(nums[i]);
                backtrack(nums, n, res, arr, track, set);
                track[i]=false;
                arr.remove(arr.size()-1);
            }
        }
    }
}