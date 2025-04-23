package week2_searchSort.searchg1findDuplicates;

import java.util.ArrayList;
import java.util.List;
//Array Duplicates
//        Difficulty: EasyAccuracy: 18.95%Submissions: 820K+Points: 2Average Time: 20m
//        Given an array arr of integers, find all the elements that occur more than once in the array. If no element repeats, return an empty array.
//
//        Examples:
//
//        Input: arr[] = [2, 3, 1, 2, 3]
//        Output: [2, 3]
//        Explanation: 2 and 3 occur more than once in the given array.
//        Input: arr[] = [0, 3, 1, 2]
//        Output: []
//        Explanation: There is no repeating element in the array, so the output is empty.
//        Input: arr[] = [2]
//        Output: []
//        Explanation: There is single element in the array. Therefore output is empty.
//        Constraints:
//        1 <= arr.size() <= 106
//        0 <= arr[i] <= 106
class Solution {

    // Solution1
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> res= new ArrayList<>();

        for(int i=0; i < arr.length ; i++){
            int index= Math.abs(arr[i])-1;
            if(arr[index]<0){
                res.add(index+1);
            }else{
                arr[index]=-arr[index];
            }
        }
        return res;
    }
}