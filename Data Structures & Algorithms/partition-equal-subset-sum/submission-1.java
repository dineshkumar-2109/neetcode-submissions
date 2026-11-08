class Solution {
    public boolean solve(int i,int []nums,int target,Boolean dp[][]){
        if(i==nums.length){
            return target==0;
        }
        if(target<0){
            return false;
        }
        if(dp[i][target]!=null){
            return dp[i][target];
        }
        
        dp[i][target]=solve(i+1,nums,target-nums[i],dp)||solve(i+1,nums,target,dp);
        return dp[i][target];

    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int target=0;
        for(int num:nums){
            target+=num;
        }
        if(target%2!=0){
            return false;
        }
        target=target/2;
        Boolean dp[][]=new Boolean[n][target+1];
        solve(0,nums,target,dp);
        return dp[0][target];
    }
}
