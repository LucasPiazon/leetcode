/**
 * @author chelsea
 * @date 2019-11-25
 */
public class Q74 {

    public static void main(String[] args) {
    }

   static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix==null||matrix.length==0||matrix[0].length==0){
                return false;
            }
            int len=matrix.length*matrix[0].length;
            int start=0;
            int end=len-1;
            while(start+1<end){
                int mid=start+(end-start)/2;
                if(matrix[getX(mid,matrix)][getY(mid,matrix)]==target){
                    return true;
                }else if(matrix[getX(mid,matrix)][getY(mid,matrix)]>target){
                    end =mid;
                }else{
                    start=mid;
                }
            }
            if(matrix[getX(start,matrix)][getY(start,matrix)]==target){
                return true;
            }
            if(matrix[getX(end,matrix)][getY(end,matrix)]==target){
                return true;
            }
            return false;
        }

        private int getX(int n,int[][] matrix){
            return n/matrix[0].length;
        }

        private int getY(int n,int[][] matrix){
            return  n%matrix[0].length;
        }
    }
}
