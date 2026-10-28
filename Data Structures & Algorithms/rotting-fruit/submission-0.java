class Solution {
    public int orangesRotting(int[][] grid) {
        int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int minutes=-1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++ ){
                int []curr=q.poll();
                int x=curr[0];
                int y=curr[1];
                for(int d[]:directions){
                    int ni=x+d[0];
                    int nj=y+d[1];
                    if(ni<0||nj<0||ni>=n||nj>=m||grid[ni][nj]!=1){
                       continue;
                    }
                    grid[ni][nj]=2;
                    fresh--;
                    q.add(new int[]{ni,nj});
                }
            }
            minutes++;
        }
        return fresh==0?minutes:-1;
    }
}
