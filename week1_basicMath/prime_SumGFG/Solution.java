package week1_basicMath.prime_SumGFG;
//Sum of all prime numbers between 1 and n
//        Difficulty: EasyAccuracy: 18.71%Submissions: 62K+Points: 2Average Time: 15m
//        Given a positive integer n, compute and return the sum of all prime numbers between 1 and n (inclusive).
//
//        A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
//
//        Examples:
//
//        Input: n = 5
//        Output: 10
//        Explanation: 2, 3 and 5 are prime numbers between 1 and 5(inclusive), and their sum is 2 + 3 + 5 = 10.
//        Input: n = 10
//        Output: 17
//        Explanation: 2, 3, 5 and 7 are prime numbers between 1 and 10(inclusive), and their sum is 2 + 3 + 5 + 7 = 17.
//        Constraints:
//        1 <= n <= 105
class Solution {
//    Time => o(nloglogn)
    // for each prime map its multiple as prime=false;
//    and sum all primes
    public int prime_Sum(int n){
        boolean[] isNotPrime = new boolean[n+1];

        for(int i=2; i*i<=n; i++){
            if(!isNotPrime[i]){
                for(int j =i*i; j<=n ; j=j+i){
                    isNotPrime[j]=true;
                }
            }
        }
        int sum=0;
        for(int i=2; i<=n; i++){
            if(!isNotPrime[i])
                sum+=i;
        }
        return sum;
    }
}