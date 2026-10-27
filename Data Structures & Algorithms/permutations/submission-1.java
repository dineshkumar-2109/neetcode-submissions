class Solution {
    public void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void solve(int []nums,int ind,List<List<Integer>> ans){
        if(ind==nums.length){
            List<Integer> ds = new ArrayList<>();
            for (int num : nums) {
                ds.add(num);
            }
            ans.add(ds);
            return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(nums,ind,i);
            solve(nums,ind+1,ans);
            swap(nums,ind,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(nums,0,ans);
        return ans;
    }
}
