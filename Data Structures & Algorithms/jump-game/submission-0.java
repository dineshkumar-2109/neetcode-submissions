class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean dp[]=new boolean[n];
        dp[n-1]=true;
        for(int i=n-2;i>=0;i--){
            dp[i]=false;
            for(int j=i+1;j<Math.min(n,i+nums[i]+1);j++){
                if(dp[j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
