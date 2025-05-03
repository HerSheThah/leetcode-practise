package week4_recursionBacktrack.isPowerofTwo231;

//231. Power of Two
//        Solved
//        Easy
//        Topics
//        Companies
//        Given an integer n, return true if it is a power of two. Otherwise, return false.
//
//        An integer n is a power of two, if there exists an integer x such that n == 2x.
//
//
//
//        Example 1:
//
//        Input: n = 1
//        Output: true
//        Explanation: 20 = 1
//        Example 2:
//
//        Input: n = 16
//        Output: true
//        Explanation: 24 = 16
//        Example 3:
//
//        Input: n = 3
//        Output: false
//
//
//        Constraints:
//
//        -231 <= n <= 231 - 1
//
//
//        Follow up: Could you solve it without loops/recursion?
class Solution {
    // TODO Solution1 Time o(1) Space o(1) => Power Funcion
    // check pow till 2^31 if it matches n
//    public boolean isPowerOfTwo(int n) {
//        for(int i=0; i< 31; i++){
//            if(Math.pow(2, i)==n)
//                return true;
//        }
//        return false;
//
//    }
    //********************************************************

    // TODO Solution2 Time o(logn) Space o(1) => divide by 2
    // use while loop to check reminder and divide by 2
//    public boolean isPowerOfTwo(int n) {
//        if(n<=0)
//            return false;
//        while(n>0){
//            if(n==1)
//                return true;
//            if(n%2!=0)
//                break;
//            n/=2;
//        }
//        return false;
//    }
    //********************************************************
    // TODO Solution3 Time o(logn) Space o(1) => left shift
    // 2, 4, 6, 8, 32 will only have 1 bit, keep shifting bit and check if it equals to n
//    public boolean isPowerOfTwo(int n) {
//
//        if(n<=0)
//            return false;
//        int x=1;
//        while(x<=n){
//            if(x==n) return true;
//            if(x> Integer.MAX_VALUE/2) break;
//            x=x<<1;
//        }
//        return false;
//    }
    //********************************************************
    // TODO Solution4 Time o(1) Space o(1) => ceil and floor
    // ceil, floor will always be equal for pow of 2.
//    public boolean isPowerOfTwo(int n) {
//            return Math.ceil(Math.log(n)/Math.log(2))==
//                    Math.floor(Math.log(n)/Math.log(2));
//    }
    //********************************************************
    // TODO Solution5 Time o(1) Space o(1) => and operator
    // 8=>1000 7=>0111 result is 0 n& n-1 will always be 0 for pow of 2
//    public boolean isPowerOfTwo(int n) {
//        return (n>=0) && (n& (n-1))==0;
//    }
    //********************************************************
    // TODO Solution6 Time o(logn) Space o(1) => count 1s bit count
    // pow of 2 will only have 1 bit value, count bit value check if its 1
    // 8=> 1000 16=> 10000 10=>1010
//    public boolean isPowerOfTwo(int n) {
//
//        if(n<=0)
//            return false;
//        return Integer.bitCount(n)==1;
//    }
    //********************************************************
    // TODO Solution7 Time o(1) Space o(1) => modulo of n
    // pow of 2 will always divide 2^31
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return 1<<30 % n==0;
    }
    //********************************************************

    // Solution8 Time o(logn) Space o(logn)
//    recursively divide n by 2 and check reminder
//    public boolean isPowerOfTwo(int n) {
//        System.out.println(n);
//        if(n==1)
//            return true;
//        if(n<=0 || n%2!=0)
//            return false;
//        return isPowerOfTwo(n/2);
//    }
}