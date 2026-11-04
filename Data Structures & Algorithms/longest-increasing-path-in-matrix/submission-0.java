class Solution {
    int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
    int n;
    int m;
    public int dfs(int i,int j,int [][]matrix,int [][]dp){
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int res=1;
        for(int []d:directions){
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni<0||nj<0||ni>=n||nj>=m||matrix[ni][nj]<=matrix[i][j]){
                continue;
            }
            res=Math.max(res,1+dfs(ni,nj,matrix,dp));
        }
        return dp[i][j]=res;

    }
    public int longestIncreasingPath(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res=Math.max(res,dfs(i,j,matrix,dp));
            }
        }
        return res;
    }
}
