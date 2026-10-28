class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []p:prerequisites){
            adj.get(p[0]).add(p[1]);
        }
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!dfs(i,adj,visited)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int ind,List<List<Integer>> adj,boolean visited[]){
        if(visited[ind]){
            return false;
        }
        visited[ind]=true;
        for(int next:adj.get(ind)){
            if(!dfs(next,adj,visited)){
                return false;
            }
        }
        adj.set(ind,new ArrayList<>());
        visited[ind]=false;
        return true;
    }
}
