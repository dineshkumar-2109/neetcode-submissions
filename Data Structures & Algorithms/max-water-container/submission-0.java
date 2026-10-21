class Solution {
    public int maxArea(int[] heights) {
        int res=0;
        int i=0;
        int j=heights.length-1;
        while(i<j){
            res=Math.max(Math.min(heights[i],heights[j])*Math.abs(j-i),res);
            if(heights[i]<=heights[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return res;
    }
}
