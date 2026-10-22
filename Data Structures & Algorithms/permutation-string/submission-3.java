class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int first[]=new int[26];
        int second[]=new int[26];
        int n=s1.length();
        int m=s2.length();
        if(n>m){
            return false;
        }
        for(int i=0;i<n;i++){
            first[s1.charAt(i)-'a']++;
            second[s2.charAt(i)-'a']++;
        }
        int matches=0;
        for(int i=0;i<26;i++){
            if(first[i]==second[i]){
                matches++;
            }
        }
        for(int i=n;i<m;i++){
            if(matches==26){
                return true;
            }
            int right=s2.charAt(i)-'a';
            int left=s2.charAt(i-n)-'a';
            second[right]++;
            if(first[right]==second[right]){
                matches++;
            }else if(first[right]+1==second[right]){
                matches--;
            }
            second[left]--;
            if(first[left]==second[left]){
                matches++;
            }else if(first[left]-1==second[left]){
                matches--;
            }
        }
        return matches==26;
        
    }
}
