package week2_searchSort.searchg3maxSubarraySize;

public class Solution {
    // Solution1: Binary search + sliding window o(nlogn)
//    Find mid of arr length, count sum of that window, if less l=mid+1 else r=mid-1 return r
//    public static int maxSubarraySize(int[] arr, int k){
//        int l=1;
//        int n = arr.length;
//        int h=n;
//        int latest=-1;
//        while(l<=h){
//            int mid=(l+h)/2;
//            if(isvalid(arr, k, mid, n))
//            {
//                latest=mid;
//                l=mid+1;
//            }else{
//                h=mid-1;
//            }
//        }
//        return latest;
//    }

    public static boolean isvalid(int[] arr, int k, int size, int n){
        int sum=0;
        for(int i=0; i< size; i++){
            sum+= arr[i];
        }
        if(sum> k)
            return false;
        for(int i=0, j=size; j<n; i++, j++){
            sum-= arr[i];
            sum+= arr[j];
            if(sum> k)
                return false;
        }
        return true;
    }

    // Approach is to find minimum subarray index of sum >k res-1 is final result
        public static int maxSubarraySize(int[] arr, int k){
            int s=0; int e=0;
            int n=arr.length;
            int sum=0;
            int minLen= n+1;
            while(e<n){
                sum+= arr[e];
                e++;
                if(sum>k){
                    minLen=Math.min(minLen, e-s);
                    sum-=arr[s];
                    s++;
                }
            }
            if(minLen - 1==0)
                return -1;
            return minLen-1;
        }
    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 4};
        int k = 14;
        System.out.println(maxSubarraySize(arr, k));
    }
}
