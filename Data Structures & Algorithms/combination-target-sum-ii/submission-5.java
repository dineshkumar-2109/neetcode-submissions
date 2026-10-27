
class Solution {
    public void solve(int []nums,int i,Set<List<Integer>> ans,List<Integer> curr,int target){

        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0||i>=nums.length){
            return;
        }
        
        
        for(int j=i;j<nums.length;j++){
            if(nums[j]>target){
                break;
            }
            if(j>i &&nums[j]==nums[j-1]){
                continue;
            }
            curr.add(nums[j]);
            solve(nums,j+1,ans,curr,target-nums[j]);
            curr.remove(curr.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Set<List<Integer>> ans =new HashSet<>();
        Arrays.sort(nums);
        solve(nums,0,ans,new ArrayList<>(),target);
        return new ArrayList<>(ans);
    }
}

