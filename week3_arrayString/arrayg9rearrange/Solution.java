package week3_arrayString.arrayg9rearrange;

import java.util.Arrays;

//Rearrange Array Alternately
//        Difficulty: MediumAccuracy: 35.15%Submissions: 253K+Points: 4
//        Given an array of positive integers. Your task is to rearrange the array elements alternatively i.e. first element should be the max value, the second should be the min value, the third should be the second max, the fourth should be the second min, and so on.
//        Note: Modify the original array itself. Do it without using any extra space. You do not have to return anything.
//
//        Examples:
//
//        Input: arr[] = [1, 2, 3, 4, 5, 6]
//        Output: [6, 1, 5, 2, 4, 3]
//        Explanation: Max element = 6, min = 1, second max = 5, second min = 2, and so on... The modified array is: [6, 1, 5, 2, 4, 3]
//        Input: arr[]= [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110]
//        Output: [110, 10, 100, 20, 90, 30, 80, 40, 70, 50, 60]
//        Explanation: Max element = 110, min = 10, second max = 100, second min = 20, and so on... Modified array is : [110, 10, 100, 20, 90, 30, 80, 40, 70, 50, 60]
//        Input: arr[]= [1]
//        Output: [1]
//        Constraints:
//        1 <= arr.size <= 106
//        1 <= arr[i] <= 106
class Solution {
    // Solution1 o(n2)
//    public static void rearrange(int arr[]) {
//        for(int i=0; i< arr.length; i++){
//            // max
//            if(i%2==0){
//                int max= i;
//                for(int j=i+1; j<arr.length; j++){
//                    if(arr[j]> arr[max])
//                        max=j;
//                }
//                if(max!=i){
//                    int temp = arr[max];
//                    arr[max]=arr[i];
//                    arr[i]=temp;
//                }
//            }
//            // min
//            else{
//                int min= i;
//                for(int j=i+1; j<arr.length; j++){
//                    if(arr[j]< arr[min])
//                        min=j;
//                }
//                if(min!=i){
//                    int temp = arr[min];
//                    arr[min]=arr[i];
//                    arr[i]=temp;
//                }
//            }
//        }
//
//    }

    // Solution2 o(n logn)
    public static void rearrange(int arr[]) {
        int n=arr.length;
        if(n<=1)
            return;
        Arrays.sort(arr);
        int min=0;
        int max= n-1;
        int maxvalue= arr[n-1]+1;

        for(int i=0; i< n; i++){
            if(i%2==0){
                arr[i]+= (arr[max]% maxvalue)*maxvalue;
                max--;
            }else{
                arr[i]+= (arr[min]% maxvalue)*maxvalue;
                min++;
            }
        }

        for(int i=0; i< n; i++){
            arr[i]=arr[i]/maxvalue;
        }



    }
}