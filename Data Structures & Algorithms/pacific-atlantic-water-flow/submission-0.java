class Solution {
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        boolean [][]pacific=new boolean[n][m];
        boolean [][]atlantic=new boolean[n][m];
        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();
        for (int c = 0; c < m; c++) {
            pacQueue.add(new int[]{0, c});
            atlQueue.add(new int[]{n - 1, c});
        }
        for (int r = 0; r < n; r++) {
            pacQueue.add(new int[]{r, 0});
            atlQueue.add(new int[]{r, m - 1});
        }
        bfs(pacQueue, pacific, heights);
        bfs(atlQueue, atlantic, heights);
            
        
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j]&&atlantic[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }
    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            ocean[r][c] = true;
            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < heights.length && nc >= 0 &&
                    nc < heights[0].length && !ocean[nr][nc] &&
                    heights[nr][nc] >= heights[r][c]) {
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
