class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        for(int i=n-1;i>=0;i--){
            dp[i]=Math.max(i+1>=n?0:dp[i+1],nums[i]+(i+2>=n?0:dp[i+2]));
        }
        return dp[0];
    }
}
