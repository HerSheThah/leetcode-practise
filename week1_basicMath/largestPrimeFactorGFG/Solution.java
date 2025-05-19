package week1_basicMath.largestPrimeFactorGFG;
//Largest prime factor
//        Difficulty: MediumAccuracy: 27.25%Submissions: 110K+Points: 4
//        Given a number n, your task is to find the largest prime factor of n.
//
//        Examples:
//
//        Input: n = 5
//        Output: 5
//        Explanation: The prime factorization of 5 is just 5. Therefore, the largest prime factor is 5.
//        Input: n = 24
//        Output: 3
//        Explanation: The prime factorization of 24 is 23×3. Among the prime factors (2, 3), the largest is 3.
//        Input: n = 13195
//        Output: 29
//        Explanation: The prime factorization of 13195 is 5×7×13×29. The largest prime factor is 29.
//        Constraints:
//        2 <= n <= 109
class Solution {

    // time -> o(n)
    static int largestPrimeFactor(int n) {
        int latest=Integer.MIN_VALUE;
        if(isPrime(n))
            return n;
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                if(isPrime(i))
                    latest= Math.max(latest, i);
                int rem=n/i;
                if(rem !=i  && isPrime(rem)){
                    latest= Math.max(latest, rem);
                }
            }
        }

        return latest;

    }

    static boolean isPrime(int n){
        for(int i=2; i*i<=n; i++){
            if(n%i==0)
                return false;

        }
        return true;
    }
}

// time -> o(root n)
//class Solution {
//    public static int largestPrimeFactor(int n){
//        int large=1;
//
//        if(n%2==0){
//            large=2;
//            while(n%2==0){
//                n=n/2;
//            }
//        }
//        for(int i=3; i*i<=n;i=i+2){
//            if(n%i==0)
//            {
//                large=i;
//                while(n%i==0){
//                    n=n/i;
//                }
//            }
//        }
//        if(n>1){
//            large=n;
//        }
//        return large;
//
//    }
//
//}