class Solution {
    public int maxSubArray(int[] nums) {
        int  ans=Integer.MIN_VALUE;
        int currSum=0;
        for(int num:nums){
            currSum+=num;
            ans=Math.max(ans,currSum);
            if(currSum<0){
                currSum=0;
            }
        }
        return ans;
    }
}
