package week3_arrayString.arrayg8findSwapValues;

import java.util.HashSet;
//Swapping pairs make sum equal
//        Difficulty: MediumAccuracy: 23.94%Submissions: 132K+Points: 4Average Time: 20m
//        Given two arrays of integers a[] and b[], the task is to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.
//
//        Examples :
//
//        Input: a[] = [4, 1, 2, 1, 1, 2], b[] = [3, 6, 3, 3]
//        Output: true
//        Explanation: Sum of elements in a[] = 11, Sum of elements in b[] = 15, To get same sum from both arrays, we can swap following values: 1 from a[] and 3 from b[]
//        Input: a[] = [5, 7, 4, 6], b[] = [1, 2, 3, 8]
//        Output: true
//        Explanation: We can swap 6 from array a[] and 2 from array b[]
//        Input: a[] = [3, 3], b[] = [6, 5, 6, 6]
//        Output: false
//        Constraints:
//        1 ≤ a.size() ≤ 106
//        1 ≤ b.size() ≤ 106
//        1 ≤ a[i] ≤ 103
//        1 ≤ b[i] ≤ 103
class Solution {
    boolean findSwapValues(int[] a, int[] b) {
        int sum1=0;
        int sum2=0;
        int i=0;
        HashSet<Integer> hash1= new HashSet<>();
        HashSet<Integer> hash2= new HashSet<>();
        while(i< a.length && i< b.length){
            sum1+=a[i];
            sum2+= b[i];
            hash1.add(a[i]);
            hash2.add(b[i]);
            i++;
        }
        int j=i;
        while(i<a.length){
            hash1.add(a[i]);
            sum1+= a[i++];

        }
        while(j<b.length){
            hash2.add(b[j]);
            sum2+= b[j++];
        }
        if(sum1==sum2)
            return true;
        int diff= Math.abs(sum1-sum2);
        if(diff%2!=0)
            return false;
        diff/=2;
        if(sum1> sum2){
            for(Integer item: hash1){
                if(hash2.contains(item-diff))
                    return true;
            }
        }else if (sum2> sum1){
            for(Integer item: hash2){
                if(hash1.contains(item-diff))
                    return true;
            }
        }

        return false;
    }
}