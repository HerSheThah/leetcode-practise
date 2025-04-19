package week3_arrayString.string1614;

class Solution {
    public int maxDepth(String s) {
        int count=0;
        int maxcount=0;
        for(int i=0; i< s.length();i++){
            char ch= s.charAt(i);
            if(ch=='(')
                count++;
            else if (ch==')'){
                maxcount= Math.max(count, maxcount);
                count--;
            }
        }
        maxcount= Math.max(count, maxcount);
        return maxcount;
    }
}