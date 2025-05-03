package week1_basicMath.lcmAndGcdGFG;


class Solution {
    // Time complexity o(log min(a,b)) space=>o(1)
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int gcd= gcd(a, b);
        int lcm= (a*b)/gcd;
        return new int[]{lcm, gcd};

    }

    public static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}
