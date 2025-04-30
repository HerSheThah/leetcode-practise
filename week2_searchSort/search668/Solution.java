package week2_searchSort.search668;
//668. Kth Smallest Number in Multiplication Table
//        Solved
//        Hard
//        Topics
//        Companies
//        Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).
//
//        Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.
//
//        Example 1:
//
//
//        Input: m = 3, n = 3, k = 5
//        Output: 3
//        Explanation: The 5th smallest number is 3.
//        Example 2:
//
//
//        Input: m = 2, n = 3, k = 6
//        Output: 6
//        Explanation: The 6th smallest number is 6.
//
//
//        Constraints:
//
//        1 <= m, n <= 3 * 104
//        1 <= k <= m * n
class Solution {
    // Solution1
    // More time & memory space- o(m*n), time- o(m*n)
    // public int findKthNumber(int m, int n, int k) {
    //     int[] arr=new int[m*n];
    //     int z=0;
    //     for(int i=1;i<=m; i++){
    //         for(int j =1; j<=n;j++){
    //             arr[z++]=i*j;
    //         }
    //     }
    //     Arrays.sort(arr);
    //     return arr[k-1];
    // }

    // Solution2 o(mlog(m*n))
    // find mid point count no <= midpoint, calculate each row level
//    if count< l=mid+1 else r=mid
    public int findKthNumber(int m, int n, int k){
        int l=1; int r= m*n;
        while(l < r){
            int mid= l+(r-l)/2;
            int count =counting(m, n, mid);
            if(count< k)
                l=mid+1;
            else
                r=mid;
        }
        return l;
    }

    private static int counting(int m , int n , int mid){
        int count =0;
        for(int i=1; i<=m; i++){
            count += Math.min(mid/i, n);
        }
        return count;
    }
}