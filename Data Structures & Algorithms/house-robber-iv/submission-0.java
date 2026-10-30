class Solution {
    public int minCapability(int[] nums, int k) {
        int l=nums[0];
        int r=nums[0];
        for(int num:nums){
            r=Math.max(r,num);
            l=Math.min(l,num);
        }
        int ans=0;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(canRob(nums,k,mid)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean canRob(int []nums,int k,int limit){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=limit){
                count++;
                i++;
            }
        }
        return count>=k;
    }
}
