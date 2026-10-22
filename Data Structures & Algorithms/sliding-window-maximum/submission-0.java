class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<>();
        int n=nums.length;
        int ans[]=new int[n-k+1];
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty()&&nums[dq.getLast()]<nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            int ind=i+1-k;
            if(ind>=0&&ind>dq.getFirst()){
                dq.removeFirst();
            }

            if(ind>=0){
                ans[ind]=nums[dq.getFirst()];
            }
        }
        return ans;
    }
}
