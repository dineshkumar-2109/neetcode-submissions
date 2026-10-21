class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        HashSet<Character>set=new HashSet<>();
        for(char a:s.toCharArray()){
            set.add(a);
        }
        int res=0;
        for(char a:set){
            int count=0,j=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==a){
                    count++;
                }
                while((i-j+1)-count>k){
                    if(s.charAt(j)==a){
                        count--;
                    }
                    j++;
                }
                res=Math.max(i-j+1,res);
                
            }
        }
        return res;
    }
}