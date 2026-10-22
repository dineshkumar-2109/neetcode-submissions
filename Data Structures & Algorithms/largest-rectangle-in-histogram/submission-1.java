class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int left[]=new int[n];
        int right[]=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            left[i]=-1;
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(!s.isEmpty()){
                left[i]=s.peek();
            }
            s.push(i);
        }
        s.clear();
        int ans=0;
        for(int i=n-1;i>=0;i--){
            right[i]=n;
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(!s.isEmpty()){
                right[i]=s.peek();
            }
            s.push(i);
        }
        for(int i=0;i<n;i++){
            right[i]--;
            left[i]++;
            ans=Math.max(heights[i]*(right[i]-left[i]+1),ans);
        }
        return ans;
    }
}
