import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Disprz {
    public static void main(String[] args) {
        int[] arr= new int[]{1, 2, 5,3, 5, 6, 7, 8,2, 1, 7, 9, 7, 6, 0};
        System.out.println(calculateCovid(arr));

    }

    public static String calculateCovid(int[] arr){
        HashMap<String, String> map= new HashMap<>();
        map.put("Alpha", "2R5D7R6U9");
        map.put("Beta", "3D9R7R6U1L2");
        map.put("Gamma", "7D1D7U9U0");
        map.put("Zeta", "0R2R7D8L4");

        int[][] matrix= new int[4][4];
        for(int i=0; i< arr.length; i++){
            matrix[i/4][i%4]=arr[i];
        }
        HashSet<String> set= new HashSet<>();
        for(Map.Entry<String, String> entry : map.entrySet()){
            if(isPatternMatch(matrix, entry.getValue())){
                set.add(entry.getKey());
            }
        }
        if(set.size()==0)
            return "Not Found";
        String res="";
        if(set.size()==1)
        {
            for(String s: set){
                res+=s;
            }
            return res;
        }
        res+="Hybrid:";
        for(String s:set)
            res=res+s+"|";
        return res.substring(0, res.length()-1);
    }

    public static boolean isPatternMatch(int[][] matrix, String pattern){
        int index=0;
        int firstNumber=pattern.charAt(index++)-'0';
        if(firstNumber <0 || firstNumber> 9) return false;
        int[] rowCol=findRowCol(firstNumber, matrix);
        if(rowCol[0]==-1) return false;
        int row=rowCol[0];
        int col=rowCol[1];
        while(index< pattern.length()){
            char direction= pattern.charAt(index++);
            switch (direction){
                case 'R':{
                    col++;
                    break;
                }
                case 'L':{
                    col--;
                    break;
                }
                case 'U':{
                    row--;
                    break;
                }
                case 'D':{
                    row++;
                    break;
                }
                default: return false;
            }
            int val= pattern.charAt(index++)-'0';
            if(row<0 || col<0 || row>3 || col>3 || val!= matrix[row][col]) return false;
        }
        return true;
    }

    private static int[] findRowCol(int number, int[][] matrix){
        for(int r=0; r< matrix.length; r++){
            for(int c=0; c<matrix[0].length; c++){
                if(matrix[r][c]==number)
                    return new int[]{r, c};
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean isDigit(char c){
        int val= c-'0';
        return val>=0 && val<10;
    }
}
