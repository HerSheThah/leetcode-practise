package week1_basicMath.countSquaresGFG;
//Count Squares
//        Difficulty: BasicAccuracy: 41.44%Submissions: 147K+Points: 1
//        Given a positive integer n, find the number of perfect squares that are less than n in the sample space of perfect squares. The sample space consists of all perfect squares starting from 1 (i.e., 1, 4, 9, 16, 25, …)
//
//        Examples :
//
//        Input: n = 9
//        Output: 2
//        Explanation: 1 and 4 are the only Perfect Squares less than 9. So, the Output is 2.
//        Input: n = 3
//        Output: 1
//        Explanation: 1 is the only Perfect Square less than 3. So, the Output is 1.
//        Constraints:
//        1 <= n <= 108

class Solution {
    //Solution1 O(root(n))
    // static int countSquares(int n) {
    //     int count=0;
    //     for(int i=1; i*i<n ; i++){
    //         count++;
    //     }
    //     return count;
    // }


    // Solution2 o(1)
    static int countSquares(int n) {
        return (int)Math.sqrt(n-1);
    }
}
