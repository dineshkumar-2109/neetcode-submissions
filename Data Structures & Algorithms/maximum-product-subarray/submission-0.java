class Solution {
    public int maxProduct(int[] nums) {
        int minProd=1;
        int maxProd=1;
        int n= nums.length;
        int res=nums[0];
        for(int i=0;i<n;i++){
            int temp=maxProd*nums[i];
            maxProd=Math.max(Math.max(maxProd*nums[i],minProd*nums[i]),nums[i]);
            minProd=Math.min(Math.min(temp,minProd*nums[i]),nums[i]);
            res=Math.max(res,maxProd);
        }
        return res;
    }
}
