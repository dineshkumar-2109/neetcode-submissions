class Solution {
    private int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
    private int n;
    private int m;
    public void bfs(int i,int j,char[][]grid){
        Queue<int[]> q=new LinkedList<>();
        grid[i][j]='0';
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int []curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            for(int d[]:directions){
                int ni=x+d[0];
                int nj=y+d[1];
                if(ni>=0&&nj>=0&&ni<n&&nj<m&&grid[ni][nj]=='1'){
                    q.add(new int[]{ni,nj});
                    grid[ni][nj]='0';
                }
            
            }
        }
    }
    public int numIslands(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    bfs(i,j,grid);
                    island++;
                }
            }
        }
        return island;
    }
}
