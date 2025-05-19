package week2_searchSort.nthMagicalNumber878;
//878. Nth Magical Number
//        Solved
//        Hard
//        Topics
//        Companies
//        A positive integer is magical if it is divisible by either a or b.
//        Given the three integers n, a, and b, return the nth magical number. Since the answer may be very large, return it modulo 109 + 7.
//        Example 1:
//
//        Input: n = 1, a = 2, b = 3
//        Output: 2
//        Example 2:
//
//        Input: n = 4, a = 2, b = 3
//        Output: 6
//        Constraints:
//        1 <= n <= 109
//        2 <= a, b <= 4 * 104


class Solution {
    // Time complexity => o(logn)
    // From 1 to high( least no *n)  check the mid number count using inclusion exclusion
    // i.e number/a + number/b - (common divisible number count num/lcm(a, b))
    // handle long step step possible
    static int mod=1_000_000_007;
    public int nthMagicalNumber(int n, int a, int b){
        long l=1;
        long h = (long)n* Math.min(a, b);
        while(l<h){
            long mid= l+(h-l)/2;
            long count = mid/a + mid/b - mid/lcm(a, b);
            if(count< n)
                l=mid+1;
            else
                h=mid;
        }
        return (int)(l%mod);
    }

    private long lcm(int a, int b){
        return (a*b)/hcf(a, b);
    }

    private long hcf(int a, int b){
        if(b==0) return a;
        return hcf(b, a%b);
    }
}