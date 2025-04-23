package week2_searchSort.searchg2kthsmallest;

import java.util.Arrays;

public class Solution {
    public static int kthSmallest(int[] arr, int k){
        int min =Arrays.stream(arr).min().getAsInt();
        int max= Arrays.stream(arr).max().getAsInt();
        while(min<=max){
            int mid = (min+(max-min))/2;
            int countLess=0;
            int countEqual=0;
            for(int i=0; i< arr.length; i++){
                if(arr[i]< mid)
                    countLess++;
                else if (arr[i]== mid)
                    countEqual++;
            }
            if(countLess< k && countLess+ countEqual==k)
                return mid;
            if(countLess>= k)
                max=mid-1;
            else if(countLess<k && countLess+countEqual<k)
                min=mid+1;
        }
        return arr[min];
    }

    public static void main(String[] args) {
        int[] arr= new int[]{7, 10, 4, 3, 20, 15};
        int k =3;
        System.out.println(kthSmallest(arr, k));
    }
}
