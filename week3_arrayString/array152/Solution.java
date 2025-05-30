package week3_arrayString.array152;

//152. Maximum Product Subarray
//        Solved
//        Medium
//        Topics
//        Companies
//        Given an integer array nums, find a subarray that has the largest product, and return the product.
//
//        The test cases are generated so that the answer will fit in a 32-bit integer.
//
//
//
//        Example 1:
//
//        Input: nums = [2,3,-2,4]
//        Output: 6
//        Explanation: [2,3] has the largest product 6.
//        Example 2:
//
//        Input: nums = [-2,0,-1]
//        Output: 0
//        Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
//
//
//        Constraints:
//
//        1 <= nums.length <= 2 * 104
//        -10 <= nums[i] <= 10
//        The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
public class Solution {
    public int maxProduct(int[] nums) {
        // Solution1 o(n2)
        // int max= nums[0];
        // for(int i=0; i< nums.length; i++){
        //     int cursum = nums[i];
        //     max= Math.max(cursum, max);
        //     for(int j =i+1; j<nums.length;j++){
        //         cursum*= nums[j];
        //         max= Math.max(cursum, max);
        //     }
        // }
        // return max;

        // Solution2
        int maxAll= nums[0];
        int min= nums[0];
        int max= nums[0];
        for(int i=1; i< nums.length; i++){
            int num= nums[i];

            if(num<0){
                int temp=min;
                min=max;
                max= temp;
            }
            max= Math.max(nums[i], max*num);
            min= Math.min(nums[i], min*num);

            maxAll= Math.max(max, maxAll);
        }
        return maxAll;
    }
}
