package week4_recursionBacktrack.bracketChallenge;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        StringBuilder res=new StringBuilder();
        int[] arr= new int[]{0};
        Stack<String> s= new Stack<>();
        validBracket(N, N, M, M,arr, res, "", "");
    }


    private static void validBracket(int open1, int close1, int open2, int close2,
                                     int[] count, StringBuilder res, String cur, String s1){
        if(open1==0 && close1==0 &&open2==0 &&close2==0){
            res.append(cur);
            // res.append(" ");
            System.out.println(cur);
            return;
        }

        if(open1>close1 || open2> close2 )
            return;

        if(open1>0){
            validBracket(open1-1, close1, open2, close2, count, res, cur+"(", s1+"(");
        }
        if(close1>0 && s1.length()>0 && s1.charAt(s1.length()-1)=='('){
            validBracket(open1, close1-1, open2, close2, count, res, cur+")", s1.substring(0, s1.length()-1));
        }
        if(open2>0){
            validBracket(open1, close1, open2-1, close2, count, res, cur+"{", s1+"{");

        }
        if(close2>0 && s1.length()>0 && s1.charAt(s1.length()-1)=='{'){
            validBracket(open1, close1, open2, close2-1, count, res, cur+"}",  s1.substring(0, s1.length()-1));
        }
    }
}


