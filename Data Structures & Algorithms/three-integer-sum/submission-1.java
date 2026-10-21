class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }
            int j=i+1;
            int k=n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    result.add(new ArrayList<>(List.of(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                    while(j<k&&nums[k+1]==nums[k]){
                        k--;
                    }
                    while(j<k&&nums[j-1]==nums[j]){
                        j++;
                    }
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                    
                }else{
                    j++;
                    
                }
            }
        }
        return result;
    }
}
