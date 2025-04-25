package week3_arrayString.stringg1validparanthesis;

public class Solution {
    // Solution1 O(2^n)
    public static int validParanthesis(int n ){
        if(n%2==1)
            return 0;
        return check(n/2, n/2, new int[]{0});
    }

    public static int check(int l, int r, int count[]){
        if(l==0 && r==0)
        {
            count[0]++;
            return count[0];
        }
        if(l> r)
            return 0;
        if(l>0)
            check(l-1, r, count);
        if(r>0)
            check(l, r-1, count);
        return count[0];
    }

    public static void main(String[] args) {
        int n =8;
        System.out.println(validParanthesis(n));

    }
}
