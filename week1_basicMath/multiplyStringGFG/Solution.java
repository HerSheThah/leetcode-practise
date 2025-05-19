package week1_basicMath.multiplyStringGFG;
//Multiply two strings
//        Difficulty: MediumAccuracy: 20.06%Submissions: 237K+Points: 4Average Time: 20m
//        Given two numbers as strings s1 and s2. Calculate their Product.
//        Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. There can be zeros in the begining of the numbers. You don't need to specify '+' sign in the begining of positive numbers.
//
//        Examples:
//
//        Input: s1 = "0033", s2 = "2"
//        Output: "66"
//        Explanation: 33 * 2 = 66
//        Input: s1 = "11", s2 = "23"
//        Output: "253"
//        Explanation: 11 * 23  = 253
//        Input: s1 = "123", s2 = "0"
//        Output: "0"
//        Explanation: Anything multiplied by 0 is equal to 0.
//        Constraints:
//        1 ≤ s1.size() ≤ 103
//        1 ≤ s2.size() ≤ 103
class Solution {
    // Time complexity - o (s1.len * s2.len)
    public String multiplyStrings(String s1, String s2) {

        // handle '-' sign
        boolean isNeg=false;
        if(s1.charAt(0)=='-' && s2.charAt(0)=='-'){
            s1= s1.substring(1);
            s2= s2.substring(1);
        }
        else if (s1.charAt(0)=='-'){
            isNeg=true;
            s1 = s1.substring(1);
        }
        else if (s2.charAt(0)=='-'){
            isNeg=true;
            s2 = s2.substring(1);
        }


        // handle prefix '0' characters
        int k=0;
        while(k<s1.length() &&  s1.charAt(k)=='0'){
            k++;
        }
        if(k==s1.length())
            return "0";
        s1=s1.substring(k);
        k=0;
        while(k<s2.length() &&  s2.charAt(k)=='0'){
            k++;
        }
        if(k==s2.length())
            return "0";
        s2=s2.substring(k);

        // multiplication logic update each index by adding with prev no in index
        int[] mul= new int[s1.length()+ s2.length()];
        for(int i=s1.length()-1; i>=0; i--){
            for(int j=s2.length()-1; j>=0; j--){
                int res= ((s1.charAt(i)-'0') * (s2.charAt(j)-'0'))+mul[i+j+1];
                int rem= res%10;
                int next= res/10;
                mul[i+j+1]=rem;
                mul[i+j]=mul[i+j]+next;
            }
        }
        String res="";
        if(isNeg)
            res+='-';
        for(int i=0; i<mul.length; i++){
            if(i==0 && mul[i]==0)
                continue;
            res+= mul[i];
        }
        return res;

    }
}
