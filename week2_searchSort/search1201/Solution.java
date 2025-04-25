package week2_searchSort.search1201;
//1201. Ugly Number III
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        An ugly number is a positive integer that is divisible by a, b, or c.
//
//        Given four integers n, a, b, and c, return the nth ugly number.
//        Example 1:
//
//        Input: n = 3, a = 2, b = 3, c = 5
//        Output: 4
//        Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
//        Example 2:
//
//        Input: n = 4, a = 2, b = 3, c = 4
//        Output: 6
//        Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
//        Example 3:
//
//        Input: n = 5, a = 2, b = 11, c = 13
//        Output: 10
//        Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
//
//
//        Constraints:
//
//        1 <= n, a, b, c <= 109
//        1 <= a * b * c <= 1018
//        It is guaranteed that the result will be in range [1, 2 * 109].

class Solution {

    // Time complexity o(logn)
    // hcf, lcm - o(1)
    // run binary search on n * min of all
    // for given x count each a,b,c multiple and subtract duplicates, add missed ones
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low=1;
        long high = Math.min(Math.min(a, b), c) * n ;
        while(low<high){
            long mid= (high+low)/2;
            long count =countMid(mid, a, b, c);
            System.out.println(count);
            if(count< n){
                low = mid+1;
            }else{
                high=mid;
            }
            System.out.println(low);
            System.out.println(high);

        }
        return (int)low;
    }

    private static long countMid(long mid, int a, int b, int c){
        return (mid/a)+(mid/b)+(mid/c)-(mid/lcm(a, b))
                -(mid/lcm(b, c))-(mid/lcm(c, a))+(mid/lcm(lcm(a, b), c));
    }

    private static long lcm(long a, long b){
        return (a*b)/hcf(a, b);
    }

    private static long hcf(long a, long b){
        if(b==0)
            return a;
        return hcf(b, a%b);
    }

}