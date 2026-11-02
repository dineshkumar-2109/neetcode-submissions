class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        double ans=1;
        long p = Math.abs((long)n);
        while(p>0){
            if((p&1)==1){
                ans=ans*x;
            }
            x=x*x;
            p>>=1;

        }
        return n>=0? ans: 1/ans;
    }
}
