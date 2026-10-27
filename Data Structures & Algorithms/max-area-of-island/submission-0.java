class Solution {
    private int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
    private int n;
    private int m;
    public int bfs(int i,int j,int[][]grid){
        Queue<int[]> q=new LinkedList<>();
        grid[i][j]='0';
        q.add(new int[]{i,j});
        int cnt=1;
        while(!q.isEmpty()){
            int []curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            for(int d[]:directions){
                int ni=x+d[0];
                int nj=y+d[1];
                if(ni>=0&&nj>=0&&ni<n&&nj<m&&grid[ni][nj]==1){
                    cnt++;
                    q.add(new int[]{ni,nj});
                    grid[ni][nj]=0;
                }
            
            }
        }
        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid){
        n=grid.length;
        m=grid[0].length;
        int area=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    area=Math.max(bfs(i,j,grid),area);
                    
                }
            }
        }
        return area;
    }
}

