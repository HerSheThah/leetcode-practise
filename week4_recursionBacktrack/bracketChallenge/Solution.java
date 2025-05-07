package week4_recursionBacktrack.bracketChallenge;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int N=1;
        int M=1;
        StringBuilder res=new StringBuilder();
        int[] arr= new int[]{0};
        Stack<String> s= new Stack<>();
        validBracket(N, N, M, M,arr, res, "", s);
        System.out.println(res);
    }

    private static void validBracket(int open1, int close1, int open2, int close2,
                                     int[] count, StringBuilder res, String cur, Stack<String> s){
        System.out.print("cur"+cur+" ");
        System.out.println(open1+" "+close1+" "+open2+" "+close2);

        if(open1==0 && close1==0 &&open2==0 &&close2==0){
            res.append(cur);
            res.append(" ");
            return;
        }
        if(open1>close1 || open2> close2 )
//                || (open1==close1 && close2>open2) || (open2==close2 && close1>open1))
            return;
        if(open1>0){
            s.push("(");
            validBracket(open1-1, close1, open2, close2, count, res, cur+"(", s);
        }
        if(close1>0){
            if(!s.isEmpty() && s.peek().equals("("))
                validBracket(open1, close1-1, open2, close2, count, res, cur+")", s);
            else
                return;
        }
        if(open2>0){
            s.push("{");
            validBracket(open1, close1, open2-1, close2, count, res, cur+"{", s);

        }
        if(close2>0){
            if(!s.isEmpty() && s.pop().equals("{"))
                validBracket(open1, close1, open2, close2-1, count, res, cur+"}", s);
            else
                return;
        }
    }
}


