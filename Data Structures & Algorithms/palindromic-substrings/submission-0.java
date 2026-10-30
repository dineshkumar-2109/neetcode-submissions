class Solution {
    public int countSubstrings(String s) {
        
        StringBuilder sb=new StringBuilder("#");
        for(char a:s.toCharArray()){
            sb.append(a).append("#");
        }
        int n=sb.length();
        int l=0,r=0;
        int p[]=new int[n];
        for(int i=0;i<n;i++){
            p[i]=(i<r)?Math.min(r-i,p[l+r-i]):0;
            while(i+p[i]+1<n&&i-p[i]-1>=0&&sb.charAt(i+p[i]+1)==sb.charAt(i-p[i]-1)){
                p[i]++;
            }
            if(i+p[i]>r){
                l=i-p[i];
                r=i+p[i];
            }
        }
        int ans=0;
        for(int i=0;i<p.length;i++){
            ans+=((p[i]+1)/2);
        }
        return ans;
        

    }
}
