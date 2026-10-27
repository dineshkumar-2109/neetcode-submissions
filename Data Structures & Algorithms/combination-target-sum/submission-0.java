class Solution {
    public void solve(int []nums,int i,List<List<Integer>> ans,List<Integer> curr,int target){

        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0||i>=nums.length){
            return;
        }
        
        curr.add(nums[i]);
        solve(nums,i,ans,curr,target-nums[i]);
        curr.remove(curr.size()-1);
        solve(nums,i+1,ans,curr,target);
        
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans =new ArrayList<List<Integer>>();
        solve(nums,0,ans,new ArrayList<>(),target);
        return ans;
    }
}
