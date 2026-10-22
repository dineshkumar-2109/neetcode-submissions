class Solution {
    public boolean solve(int []piles,int h,int rate){
        int sum=0;
        for(int pile:piles){
            if(pile%rate!=0){
                sum++;
            }
            sum+=pile/rate;
        }
        return sum<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=piles[0];
        for(int pile:piles){
            r=Math.max(r,pile);
        }
        int ans=Integer.MAX_VALUE;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(solve(piles,h,mid)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}
