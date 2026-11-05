class Solution {
    public int dfs(int i,int coins[],int amount,int [][]dp){
        if(i==0){
            if(amount%coins[0]==0){
                return dp[i][amount]=1;
            }else{
                return dp[i][amount]=0;
            }
        }
        if(amount==0){
            return dp[i][amount]=1;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }

        int res=0;
        if(coins[i]<=amount){
            res+=dfs(i,coins,amount-coins[i],dp);
        }
        res+=dfs(i-1,coins,amount,dp);
        return dp[i][amount]=res;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        dfs(n-1,coins,amount,dp);
        return dp[n-1][amount];
    }
}
