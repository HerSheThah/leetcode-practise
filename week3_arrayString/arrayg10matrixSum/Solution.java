package week3_arrayString.arrayg10matrixSum;
//Sum of all Submatrices of a Given Matrix
//        Last Updated : 27 Jan, 2023
//        Given a NxN 2-D matrix, the task to find the sum of all the submatrices.
//
//        Examples:
//
//        Input :  arr[] = {{1, 1},
//        {1, 1}};
//        Output : 16
//        Explanation:
//        Number of sub-matrices with 1 elements = 4
//        Number of sub-matrices with 2 elements = 4
//        Number of sub-matrices with 3 elements = 0
//        Number of sub-matrices with 4 elements = 1
//
//        Since all the entries are 1, the sum becomes
//        sum = 1 * 4 + 2 * 4 + 3 * 0 + 4 * 1 = 16
//
//        Input : arr[] = {{1, 2, 3},
//        {4, 5, 6},
//        {7, 8, 9}}
//        Output : 500
public class Solution {

    // Solution-1 o(n6)
//    public static int matrixSum(int[][] matrix){
//        int n = matrix.length;
//        int sum=0;
//        for(int i1=0; i1<n; i1++){
//            for(int j1=0; j1<n; j1++){
//                for(int i2=i1; i2<n; i2++){
//                    for(int j2=j1; j2<n; j2++){
//                        for(int i=i1; i<=i2; i++){
//                            for(int j = j1; j<=j2; j++){
//                                sum+=matrix[i][j];
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return sum;
//    }
    public static int matrixSum(int[][] matrix){
        int sum=0;
        int n = matrix.length;
        for(int i=0; i<n; i++ ){
            for (int j =0; j< n; j++){
                int topleft= (i+1)*(j+1);
                int bottomdown = (n-i)*(n-j);
                sum+= (topleft+bottomdown*matrix[i][j]);
            }
        }
        return sum;
    }

}
