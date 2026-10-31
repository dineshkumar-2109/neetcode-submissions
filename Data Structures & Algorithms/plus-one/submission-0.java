class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> ans=new ArrayList<>();
        int carry=1;
        
        for(int i=digits.length-1;i>=0;i--){
            int val=digits[i]+carry;
            ans.add(val%10);
            carry=val/10;
        }
        if(carry!=0){
            ans.add(carry);
        }
        int n=ans.size();
        int []res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=ans.get(n-1-i);
        }
        return res;
    }
}
