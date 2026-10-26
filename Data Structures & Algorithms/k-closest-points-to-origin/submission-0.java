class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int []point:points){
            int x=point[0];
            int y=point[1];
            pq.add(new int[]{x,y,x*x+y*y});

        }
        int [][]result=new int[k][2];
        int i=0;
        while(i<k){
            int curr[]=pq.poll();
            result[i][0]=curr[0];
            result[i][1]=curr[1];
            i++;

        }
        return result;

    }
}
