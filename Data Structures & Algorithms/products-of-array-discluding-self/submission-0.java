class Solution {
    public int[] productExceptSelf(int[] nums) {
        long prod=1;
        int zeros=0;
        int n=nums.length;
        for(int num:nums){
            if(num==0){
                zeros++;
            }else{
                prod*=num;
            }
        }
        if(zeros>1){
            return new int[n];
        }
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                res[i]=(int)prod;
            }else{
                if(zeros>0){
                    res[i]=0;
                }else{
                    res[i]=(int)(prod/nums[i]);
                }
            }
        }
        return res;

    }
}  
