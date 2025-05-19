package week2_searchSort.countSmaller315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // Time is o(n log n)
    // maintain a index arr of original indexes, everytime swap happens update the index as well
    // whenever left> right in merge in that index (original index position) update right count [i.e value lesser than cur]
    static int[] res;
    static int[] index;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result= new ArrayList<>();
        index= new int[nums.length];
        res= new int[nums.length];
        for(int i=0; i< nums.length; i++){
            index[i]=i;
        }
        mergeSort(nums, 0, nums.length-1);
        for(int i=0; i< nums.length;i++){
            result.add(res[i]);
        }
        System.out.println(Arrays.toString(nums));
        return result;
    }

    private void mergeSort(int[] nums, int l, int r){
        if(l==r)
            return;
        int mid= (l+r)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r){
        int[] larr= new int[mid-l+1];
        int[] lindex= new int[mid-l+1];
        int[] rarr= new int[r-mid];
        int[] rindex= new int[r-mid];

        int k=0;
        for(int i=l; i<=mid; i++){
            larr[k]=arr[i];
            lindex[k++]=index[i];
        }
        k=0;
        for(int i=mid+1; i<=r; i++){
            rarr[k]=arr[i];
            rindex[k++]=index[i];
        }
        int i=0;int j=0; k=l;
        int rightCount=0;
        while(i<(mid-l+1) && j<(r-mid)){
            if(larr[i]<= rarr[j]){
                arr[k]=larr[i];
                index[k]=lindex[i];
                res[lindex[i]]+=rightCount;
                k++;
                i++;

            }else{
                arr[k]=rarr[j];
                index[k++]=rindex[j++];
                rightCount++;

            }
        }
        while(i<(mid-l+1)){
            arr[k]=larr[i];
            index[k]=lindex[i];
            res[lindex[i]]+= rightCount;
            k++;
            i++;
        }
        while(j<(r-mid)){
            arr[k]=rarr[j];
            index[k]=rindex[j];
            k++;
            j++;
        }
    }
}