class Solution {
    public boolean isPalindrome(String s) {
        String result=s
        .replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int n=result.length();
        for(int i=0;i<n/2;i++){
            if(result.charAt(i)!=result.charAt(n-1-i)){
                return false;
            }
        }
        return true;

    }
}
