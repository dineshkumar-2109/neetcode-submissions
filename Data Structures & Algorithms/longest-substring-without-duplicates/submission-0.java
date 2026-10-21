class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int j=0,ans=0;
        for(int i=0;i<n;i++){
            char a=s.charAt(i);
            map.put(a,map.getOrDefault(a,0)+1);
            while(i-j+1!=map.size()){
                char b=s.charAt(j);
                map.put(b,map.getOrDefault(b,0)-1);
                j++;
                if(map.get(b)==0){
                    map.remove(b);
                }
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}
