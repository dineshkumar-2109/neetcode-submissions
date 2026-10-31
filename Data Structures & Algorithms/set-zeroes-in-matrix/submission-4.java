class Solution {
    public void setZeroes(int[][] nums) {
        int n=nums.length;
        int m=nums[0].length;
        boolean rowZero=false;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (nums[i][j] == 0) {
                    nums[0][j] = 0;
                    if (i > 0) {
                        nums[i][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }
        for(int i=1;i<n;i++){
            if(nums[i][0]==0){
                for(int j=0;j<m;j++){
                    nums[i][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            if(nums[0][i]==0){
                for(int j=0;j<n;j++){
                    nums[j][i]=0;
                }
            }
        }
        if (nums[0][0] == 0) {
            for (int r = 0; r < n; r++) {
                nums[r][0] = 0;
            }
        }

        if (rowZero) {
            for (int c = 0; c < m; c++) {
                nums[0][c] = 0;
            }
        }
    
    }
}
