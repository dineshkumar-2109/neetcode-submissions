class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1000000);
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            for(int j=Math.min(n-1,i+nums[i]);j>i;j--){
                
                dp[i]=Math.min(dp[i],1+dp[j]);
            }
        }
        return dp[0]==1000000?-1:dp[0];
    }
}

