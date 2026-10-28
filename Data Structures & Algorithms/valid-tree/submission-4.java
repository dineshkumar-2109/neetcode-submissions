class Solution {
    class Union{
        int parent[];
        int rank[];
        int components;
        public Union(int n){
            parent=new int[n];
            rank=new int[n];
            components=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
            }

        }
        public int find(int x){
            if(parent[x]!=x){
                parent[x]= find(parent[x]);
            }
            return parent[x];
        }
        public boolean union(int a,int b){
            int rootA=find(a);
            int rootB=find(b);
            if(rootA==rootB) return false;
            if(rank[rootA]>rank[rootB]){
                parent[rootB]=rootA;
                
            }else if(rank[rootA]<rank[rootB]){
                parent[rootA]=rootB;
                
            }else{
                parent[rootB]=rootA;
                rank[rootA]++;
            }
            components--;
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length> n - 1) {
            return false;
        }
        Union u=new Union(n);
        for(int edge[]:edges){
            if(!u.union(edge[0],edge[1])){
                return false;
            }
        }
        return u.components==1;
    }
}
