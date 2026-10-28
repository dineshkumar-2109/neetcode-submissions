class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int inDegree[]=new int[n];
        for(int p[]:prerequisites){
            adj.get(p[0]).add(p[1]);
            inDegree[p[1]]++;
        }
        
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int finish=0;
        int[] output = new int[n];
        while(!q.isEmpty()){
            int curr=q.poll();
            output[n-finish-1]=curr;
            finish++;
            for(int next:adj.get(curr)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    q.add(next);
                }
            }

        }
        if(finish!=n){
            return new int[0];
        }
        return output;
    }
}
