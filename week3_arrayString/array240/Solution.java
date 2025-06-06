package week3_arrayString.array240;
//240. Search a 2D Matrix II
//        Solved
//        Medium
//        Topics
//        Companies
//        Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
//        Integers in each row are sorted in ascending from left to right.
//        Integers in each column are sorted in ascending from top to bottom.
//        Example 1:
//        Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//        Output: true
//        Example 2:
//        Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//        Output: false
//
//
//        Constraints:
//
//        m == matrix.length
//        n == matrix[i].length
//        1 <= n, m <= 300
//        -109 <= matrix[i][j] <= 109
//        All the integers in each row are sorted in ascending order.
//        All the integers in each column are sorted in ascending order.
//        -109 <= target <= 109

class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {

//        Solution1 m+n
        int r= 0;
        int c= matrix[0].length-1;
        while(r<matrix.length&&  c>=0 ){
            int cur=matrix[r][c];
            if(cur== target)
                return true;
            if(target< cur)
                c--;
            else
                r++;
        }
        return false;

//        Solution2: mlogn
//        int row=0;
//        int l=0;
//        int r= matrix[0].length-1;
//        while(row< matrix.length){
//            while(l>=0 && l<= r){
//                int m= (l+r)/2;
//                System.out.println(matrix[row][m]);
//                int el= matrix[row][m];
//                if(target==el)
//                    return true;
//                if(target< el)
//                    r=m-1;
//                else
//                    l=m+1;
//            }
//            row++;
//            l--;
//        }
//        return false;
    }

}