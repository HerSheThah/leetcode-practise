package week3_arrayString.arrayg6rearrange;

//Modify an array such that if ‘arr[i]’ is ‘j’ then arr[j] becomes i
//        Last Updated : 29 Mar, 2025
//        Given an array arr[] of size n, where all elements are distinct and fall within the range 0 to n-1. The task is to modify arr[] such that if arr[i] = j, then it gets transformed into arr[j] = i.
//
//        Examples:
//
//        Input: arr[] = [1, 3, 0, 2]
//        Output: 2 0 3 1
//        Explanation: Since arr[0] = 1, update arr[1] to 0
//        Since arr[1] = 3, update arr[3] to 1
//        Since arr[2] = 0, update arr[0] to 2
//        Since arr[3] = 2, update arr[2] to 3
//
//
//        Input: arr[] = [2, 0, 1, 4, 5, 3]
//        Output: 1 2 0 5 3 4
//        Explanation: Since arr[0] = 2, update arr[2] to 0
//        Since arr[1] = 0, update arr[0] to 1
//        Since arr[2] = 1, update arr[1] to 2
//        Since arr[3] = 4, update arr[4] to 3
//        Since arr[4] = 5, update arr[5] to 4
//        Since arr[5] = 3, update arr[3] to 5
//
//
//        Input: arr[] = [3, 2, 1, 0]
//        Output: 3 2 1 0
//        Explanation: Since each element is already at its correct index, the array remains unchanged.
//

public class Solution {
    public static void rearrange(int[] num){
        for(int i=0; i< num.length;i++){
            int index= num[i];
            int v=i;
            while(index>=0 && num[index]>=0){
                int nex= num[index];
                if(v==0)
                    num[index]=-num.length;
                else
                    num[index]=-v;
                v=index;
                index=nex;
            }
        }
        for(int i=0; i< num.length ; i++)
        {
            if(num[i]== -num.length)
                num[i]=0;
            else
                num[i]=-num[i];
        }
    }
}
