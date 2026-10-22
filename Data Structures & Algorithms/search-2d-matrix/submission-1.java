class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0;
        int r=(n*m)-1;
        while(l<=r){
            int mid=l+((r-l)>>1);
            
            if(matrix[mid/m][mid%m]==target){
                return true;
            }
            if(matrix[mid/m][mid%m]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }
}
