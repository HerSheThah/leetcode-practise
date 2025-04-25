package week2_searchSort.searchg3maxSubarraySize;

public class Solution {
    // Solution1: Binary search + sliding window o(nlogn)
//    Find mid of arr length, count sum of that window, if less l=mid+1 else r=mid-1 return r

//    public static int maxSubarraySize(int[] arr, int k){
//        int l=1;
//        int r=arr.length;
//        int n=arr.length;
//        int maxIndex=-1;
//        while(l<=r){
//            int mid=(l+r)/2;
//            int sum=0;
//            for(int i=0; i< mid; i++){
//                sum+=arr[i];
//            }
//            int maxSum=sum;
//            for(int i=mid; i<=n-mid; i++){
//               sum= (sum-arr[i-mid])+arr[i];
//               maxSum= Math.max(sum, maxSum);
//            }
//            if(maxSum<=k){
//                if(maxIndex==-1)
//                    maxIndex=1;
//                else
//                    maxIndex++;
//                l=mid+1;
//            }else
//                r=mid-1;
//        }
//        return maxIndex;
//    }

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
                sum-=arr[s];
                s++;
                minLen=Math.min(minLen, e-s);
            }
        }
        if(minLen==n+1)
            return -1;
        return minLen-1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 4};
        int k = 14;
        System.out.println(maxSubarraySize(arr, k));
    }
}
