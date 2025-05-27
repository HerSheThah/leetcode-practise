package week5_2PointersSlidingWindow.distinctPairGFG;

import java.util.HashMap;
import java.util.Map;
//Count distinct pairs with difference k
//        Difficulty: MediumAccuracy: 24.76%Submissions: 40K+Points: 4Average Time: 15m
//        Given an integer array of size n and a non-negative integer k, count all distinct pairs with a difference equal to k, i.e., A[ i ] - A[ j ] = k.
//        Example 1:
//
//        Input: array = {1, 5, 4, 1, 2}, k = 0
//        Output: 1
//        Explanation: There is only one pair (1, 1) whose difference equal to 0.
//        Example 2;
//
//        Input: array = {1, 5, 3}, k = 2
//        Output: 2
//        Explanation: There are two pairs (5, 3) and (1, 3) whose difference equal to 2.
//        Your Task:
//        You don't need to read or print anything. Your task is to complete the function TotalPairs() which takes array and k as input parameters and returns the count of all distinct pairs.
//
//        Expected Time Complexity: O(n)
//        Expected Space Complexity: O(n)
//
//        Constraints:
//        2 <= n <= 104
//        0 <= k <= 104
//        1 <= nums[i] <= 106


class Solution {
    // Time=> o(n), Space o(n)
    // Count all frequency of array no in a hashmap
    // If k==0 for each unique arr no if hashmap val>1 count++
    // If k!=0 for each unique arr no if diff/sum with k is present
    // in hashmap count++
    public int TotalPairs(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                if (k == 0) {
                    if (val > 1)
                        count++;
                } else {
                    if (map.containsKey(key - k))
                        count++;
                }
            }
        }
        return count;
    }

    // Solution2 using 2 pointers=> o(nlogn) for sorting
    //create pointer i=0 j=1 sort array keep looping till i<n,j<n
    // if diff is less i++ if more j++ if equal check hashset for duplicate pair and count++

    
//    public int TotalPairs(int[] nums, int k) {
//        Arrays.sort(nums);
//        int i=0; int j=1;
//        int n = nums.length;
//        HashSet<String> set=new HashSet<>();
//        int count=0;
//        while(i<n && j<n){
//            if(i==j){
//                j++;
//                continue;
//            }
//            int diff= nums[j]-nums[i];
//            if(diff==k){
//                String s= nums[i]+","+nums[j];
//                if(!set.contains(s)){
//                    set.add(s);
//                    count++;
//                }
//                i++;
//                j++;
//            }
//            else if (diff<k)
//                j++;
//            else
//                i++;
//        }
//        return count;
//    }

}
