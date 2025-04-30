package week2_searchSort.sortg3segregateEvenOdd;

import java.util.Arrays;
//Segregate Even and Odd numbers
//        Difficulty: BasicAccuracy: 42.11%Submissions: 33K+Points: 1
//        Given an array arr, write a program segregating even and odd numbers. The program should put all even numbers first in sorted order, and then odd numbers in sorted order.
//
//        Note:- You don't have to return the array, you have to modify it in-place.
//
//        Example:
//
//        Input: arr[] = [12, 34, 45, 9, 8, 90, 3]
//        Output: [8, 12, 34, 90, 3, 9, 45]
//        Explanation: Even numbers are 12, 34, 8 and 90. Rest are odd numbers.
//        Input: arr[] = [0, 1, 2, 3, 4]
//        Output: [0, 2, 4, 1, 3]
//        Explanation: 0 2 4 are even and 1 3 are odd numbers.
//        Input: arr[] = [10, 22, 4, 6]
//        Output: [10, 22, 4, 6]
//        Explanation: Here all elements are even, so no need of segregataion
//        Constraints:
//        1 ≤ arr.size() ≤ 106
//        0 ≤ arr[i] <=105
class Solution {
    // o(nlogn)
    // Using 2 pointer move odd to one side, even to other side,
    // then sort even and odd part seperately
    void segregateEvenOdd(int arr[]) {
        int n = arr.length;
        int l=0;
        int r=n-1;
        while(l<r){
            while(l< n && arr[l]%2==0)
                l++;
            while(r>=0 && arr[r]%2!=0)
                r--;
            if(l<r)
            {
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
            }
        }
        Arrays.sort(arr, 0, l);
        Arrays.sort(arr, l, n);

    }
}
