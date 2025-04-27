package week2_searchSort.sortg2countInversion;
import java.util.Arrays;

//Count Inversions
//        Difficulty: MediumAccuracy: 16.93%Submissions: 653K+Points: 4
//        Given an array of integers arr[]. Find the Inversion Count in the array.
//        Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
//
//        Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
//        If an array is sorted in the reverse order then the inversion count is the maximum.
//
//        Examples:
//
//        Input: arr[] = [2, 4, 1, 3, 5]
//        Output: 3
//        Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
//        Input: arr[] = [2, 3, 4, 5, 6]
//        Output: 0
//        Explanation: As the sequence is already sorted so there is no inversion count.
//        Input: arr[] = [10, 10, 10]
//        Output: 0
//        Explanation: As all the elements of array are same, so there is no inversion count.
//        Constraints:
//        1 ≤ arr.size() ≤ 105
//        1 ≤ arr[i] ≤ 104
class Solution {
    // Time complex o(nlogn) ->
    // use merge sort, but when a(j)< a(i), a(i).length-i elements are lesser in value so add them to count
    public static int inversionCount(int[] arr) {
        // Your Code Here
        int[] count=new int[]{0};
        mergeSort(arr, count);
        return count[0];
    }

    private static int[] mergeSort(int[] arr, int[] count){
        if(arr.length==1)
            return arr;

        int mid= arr.length/2;
        int arr1[]= mergeSort(Arrays.copyOfRange(arr, 0, mid), count);
        int arr2[]= mergeSort(Arrays.copyOfRange(arr, mid, arr.length), count);
        return merge(arr1, arr2, count);
    }

    private static int[] merge(int[] arr1, int[] arr2, int[] count){
        int[] res= new int[arr1.length+arr2.length];
        int i=0;int j=0;int k=0;
        while(i<arr1.length && j < arr2.length){
            if(arr1[i]<= arr2[j]){
                res[k++]= arr1[i++];
            }else{
                res[k++]=arr2[j++];
                count[0]+= (arr1.length-i);
            }
        }
        while(i< arr1.length){
            res[k++]=arr1[i++];
        }
        while(j< arr2.length){
            res[k++]=arr2[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr));
    }
}