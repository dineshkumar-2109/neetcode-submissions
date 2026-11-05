class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []time:times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }
        int dist[]=new int [n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        
        Queue<Integer>q=new LinkedList<>();
        q.add(k);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int next[]:adj.get(curr)){
                if(dist[curr]+next[1]<dist[next[0]]){
                    dist[next[0]]=dist[curr]+next[1];
                    q.add(next[0]);
                }
            }
        }
        int maxTime=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            maxTime=Math.max(maxTime,dist[i]);
        }
        return maxTime;
    }
}
