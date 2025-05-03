package week1_basicMath.commonFactors2427;
//2427. Number of Common Factors
//        Solved
//        Easy
//        Topics
//        Companies
//        Hint
//        Given two positive integers a and b, return the number of common factors of a and b.
//        An integer x is a common factor of a and b if x divides both a and b.
//        Example 1:
//
//        Input: a = 12, b = 6
//        Output: 4
//        Explanation: The common factors of 12 and 6 are 1, 2, 3, 6.
//        Example 2:
//
//        Input: a = 25, b = 30
//        Output: 2
//        Explanation: The common factors of 25 and 30 are 1, 5.
//        Constraints:
//
//        1 <= a, b <= 1000
class Solution {
    // Solution1=> o(min(a, b))
    // loop through min of 2 elements
    // public int commonFactors(int a, int b) {
    //     int min=Math.min(a, b);
    //     int count=0;
    //     for(int i=1; i<=min;i++){
    //         if(a%i==0 && b%i==0)
    //             count++;
    //     }
    //     return count;
    // }

    // Solution2=> o(hcf(a, b))
    // find hcf and loop only till hcf => o(logn)
    public int commonFactors(int a, int b) {
        int gcd=gcd(a, b);
        int count=0;
        for(int i=1; i<=gcd;i++){
            if(a%i==0 && b%i==0)
                count++;
        }
        return count;
    }

    private static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}