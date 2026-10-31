class Solution {
    public int[] countBits(int n) {
        int []res=new int [n+1];
        int i=1;
        while(i<n+1){
            int num=i;
            while(num>0){
                res[i]++;
                num&=(num-1);
            }
            i++;
        }
        return res;
    }
}
