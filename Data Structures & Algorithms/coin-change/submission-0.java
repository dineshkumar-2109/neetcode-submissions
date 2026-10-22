/*
class Solution {
    public int solve(int ind,int coins[],int amount){
        if(amount==0){
            return 0;
        }
        if(ind==0){
            if(amount%coins[ind]==0){
                return amount/coins[ind];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        if(coins[ind]<=amount){
            int val=solve(ind,coins,amount-coins[ind]);
            if(val==Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else{
                return 1+val;
            }
        }
        return solve(ind-1,coins,amount);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        
        int ans=solve(n-1,coins,amount);
        return ans==Integer.MAX_VALUE?-1:ans;

    }
}
*/

/*
class Solution {
    public int solve(int ind,int coins[],int amount,int dp[][]){
        if(amount==0){
            return dp[ind][amount]=0;
        }
        if(ind==0){
            if(amount%coins[ind]==0){
                return dp[ind][amount]=amount/coins[ind];
            }else{
                return dp[ind][amount]=Integer.MAX_VALUE;
            }
        }
        if(dp[ind][amount]!=-1){
            return dp[ind][amount];
        }
        if(coins[ind]<=amount){
            int val=solve(ind,coins,amount-coins[ind],dp);
            if(val==Integer.MAX_VALUE){
                return dp[ind][amount]=Integer.MAX_VALUE;
            }
            else{
                return dp[ind][amount]=1+val;
            }
        }
        return dp[ind][amount]=solve(ind-1,coins,amount,dp);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int []r:dp){
            Arrays.fill(r,-1);
        }
        int ans=solve(n-1,coins,amount,dp);
        return ans==Integer.MAX_VALUE?-1:ans;

    }
}
*/
class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[]=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];

    }
}
