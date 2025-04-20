package week3_arrayString.arrayg4minSwap;


//Minimum swaps and K together
//        Difficulty: MediumAccuracy: 26.0%Submissions: 136K+Points: 4
//        Given an array arr and a number k. One can apply a swap operation on the array any number of times, i.e choose any two index i and j (i < j) and swap arr[i] , arr[j] . Find the minimum number of swaps required to bring all the numbers less than or equal to k together, i.e. make them a contiguous subarray.
//
//        Examples :
//
//        Input: arr[] = [2, 1, 5, 6, 3], k = 3
//        Output: 1
//        Explanation: To bring elements 2, 1, 3 together, swap index 2 with 4 (0-based indexing), i.e. element arr[2] = 5 with arr[4] = 3 such that final array will be- arr[] = [2, 1, 3, 6, 5]
//        Input: arr[] = [2, 7, 9, 5, 8, 7, 4], k = 6
//        Output: 2
//        Explanation: To bring elements 2, 5, 4 together, swap index 0 with 2 (0-based indexing) and index 4 with 6 (0-based indexing) such that final array will be- arr[] = [9, 7, 2, 5, 4, 7, 8]
//        Input: arr[] = [2, 4, 5, 3, 6, 1, 8], k = 6
//        Output: 0
//        Constraints:
//        1 ≤ arr.size() ≤ 106
//        1 ≤ arr[i] ≤ 106
//        1 ≤ k ≤ 106

class Solution {
    // Solution1
//    int minSwap(int[] arr, int k) {
//        // Complete the function
//        int swap=0;
//        int less=-1;
//        int high=-1;
//        for(int i=0; i< arr.length;i++){
//            if(arr[i]<=k && (less==-1 || less==i-1))
//                less=i;
//            else if (arr[i]> k)
//                high=i;
//            else{
//                if(high==-1)
//                    continue;
//                else if (high>less){
//                    int temp=arr[less+1];
//                    arr[less+1]=arr[i];
//                    arr[i]=temp;
//                    high=i;
//                    less++;
//                    swap++;
//                }
//
//            }
//        }
//        return swap;
//    }

    // Solution2
    int minSwap(int[] arr, int k) {
        int count=0;
        for(int i=0; i< arr.length; i++){
            if(arr[i]<=k)
                count++;
        }

        int bad=0;
        for(int i=0; i< count; i++){
            if(arr[i]>k)
                bad++;
        }

        int min= bad;
        for(int i=0, j=count; j<arr.length; j++, i++){
            if(arr[i]>k)
                bad--;
            if(arr[j]> k)
                bad++;
            min= Math.min(min, bad);
        }

        return min;
    }
}
