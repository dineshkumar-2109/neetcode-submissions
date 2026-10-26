class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:stones){
            pq.add(num);

        }
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            if(first==second){
                continue;
            }
            pq.add(first-second);
        }
        return pq.size()==1?pq.poll():0;
    }
}
