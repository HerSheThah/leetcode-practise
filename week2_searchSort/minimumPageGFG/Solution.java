package week2_searchSort.minimumPageGFG;
//Allocate Minimum Pages
//        Difficulty: MediumAccuracy: 35.51%Submissions: 268K+Points: 4Average Time: 35m
//        You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:
//        Each student receives atleast one book.
//        Each student is assigned a contiguous sequence of books.
//        No book is assigned to more than one student.
//        The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.
//
//        Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
//        Examples:
//
//        Input: arr[] = [12, 34, 67, 90], k = 2
//        Output: 113
//        Explanation: Allocation can be done in following ways:
//        [12] and [34, 67, 90] Maximum Pages = 191
//        [12, 34] and [67, 90] Maximum Pages = 157
//        [12, 34, 67] and [90] Maximum Pages = 113.
//        Therefore, the minimum of these cases is 113, which is selected as the output.
//        Input: arr[] = [15, 17, 20], k = 5
//        Output: -1
//        Explanation: Allocation can not be done.
//        Input: arr[] = [22, 23, 67], k = 1
//        Output: 112
//        Constraints:
//        1 <=  arr.size() <= 106
//        1 <= arr[i] <= 103
//        1 <= k <= 103
class Solution {
    // time complex o(nlogn)
    public static int findPages(int[] arr, int k) {
        if(k> arr.length)
            return -1;
        int low= arr[0];
        int high=arr[0];
        int latest=-1;
        for(int i=1; i< arr.length; i++){
            low= Math.max(low, arr[i]);
            high+=arr[i];
        }
        if(k==1)
            return high;
        // low is maximum of arr and high is sum of arr
        // with every mid see if its possible if yes try mid-1 (low number)
        // if not check the high number mid+1
        while(low<=high){
            int mid= (low+high)/2;
            if(isPossible(arr, k, mid)){
                latest=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return latest;
    }


    // check if k students can fit in with max sum value
    // for every arr[i] check if exceeds k and increment student
    // if student>k it exceeds.
    public static boolean isPossible(int[] arr, int k, int max){
        int count=0;
        int student=1;
        for(int i=0; i<arr.length; i++){
            if(count+ arr[i]> max){
                count=0;
                student++;
            }
            if(student>k)
                return false;
            count += arr[i];
        }
        return true;
    }
}