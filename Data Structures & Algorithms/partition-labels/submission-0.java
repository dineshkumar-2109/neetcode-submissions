class Solution {
    public List<Integer> partitionLabels(String s) {
        int c[]=new int[26];
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']=i;
        }
        List<Integer> result=new ArrayList<>();
        int i=0,j=0,r=0;
        while(i<s.length()){
            r=c[s.charAt(i)-'a'];
            while(r!=i){
                i++;
                r=Math.max(r,c[s.charAt(i)-'a']);
            }
            result.add(i-j+1);
            i++;
            j=i;
        }
        return result;

    }
}
