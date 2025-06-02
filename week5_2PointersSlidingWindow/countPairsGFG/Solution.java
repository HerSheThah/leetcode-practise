package week5_2PointersSlidingWindow.countPairsGFG;

public class Solution {
    // Solution1
    // Two pointers approach where if sum is equal
    // keep decrementing temp right pointer till its not equal and do count++;
    //then increment left
    // Time => o(n)
//    public static int countPairs(int[] arr, int target){
//        int l=0;
//        int r=arr.length-1;
//        int count=0;
//        while(l<r){
//
//            if(arr[l]+arr[r]> target)
//                r--;
//            else if (arr[l]+ arr[r]< target)
//                l++;
//            else{
//                int rp=r-1;
//                count++;
//                while(arr[rp]==arr[rp+1] && l<rp){
//                    count++;
//                    rp--;
//                }
//                l++;
//            }
//        }
//        return count;
//    }

    // Solution2
    public static int countPairs(int[] arr, int target){
        int l=0;
        int r=arr.length-1;
        int count=0;
        while(l<r){

            if(arr[l]+arr[r]> target)
                r--;
            else if (arr[l]+ arr[r]< target)
                l++;
            else{
                int le=arr[l];
                int re=arr[r];
                int lc=0; int rc=0;
                while(l<=r && arr[l]==le){
                    l++;
                    lc++;
                }
                while(l<=r && arr[r]==re){
                    r--;
                    rc++;
                }
                if(le==re){
                    // If both l and r pointers points to the same element
                    count+=(lc*(lc-1))/2;
                }else{
                    count += (lc*rc);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr= new int[]{-1, 10, 10, 12, 15};
        System.out.println(countPairs(arr, 125));
    }
}
