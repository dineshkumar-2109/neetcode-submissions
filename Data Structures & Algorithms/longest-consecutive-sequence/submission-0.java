class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;
        for(int num:nums){
            set.add(num);
        }
        int count=0;
        for(int i=0;i<n;i++){
            int val=nums[i];
            int currCount=1;
            if(set.contains(val-1)){
                continue;
            }
            while(set.contains(val+1)){
                val+=1;
                currCount++;
            }
            count=Math.max(count,currCount);
        }
        return count;
    }
}
