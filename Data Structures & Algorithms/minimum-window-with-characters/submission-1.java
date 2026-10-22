class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tMap=new HashMap<>();
        HashMap<Character,Integer> sMap=new HashMap<>();
        for(char a:t.toCharArray()){
            tMap.put(a,tMap.getOrDefault(a,0)+1);
        }
        int need=0,have=tMap.size();
        int j=0,ans=Integer.MAX_VALUE;
        int []res={-1,-1};
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            sMap.put(a,sMap.getOrDefault(a,0)+1);
            if(tMap.containsKey(a)&&sMap.get(a).equals(tMap.get(a))){
                need++;
            }
            while(need==have){
                if(i-j+1<ans){
                    res[0]=j;
                    res[1]=i;
                    ans=i-j+1;
                }
                char b=s.charAt(j);
                sMap.put(b,sMap.getOrDefault(b,0)-1);
                if(tMap.containsKey(b)&&sMap.get(b)<tMap.get(b)){
                    need--;
                }
                j++;
            }
        }
        return ans==Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);
    }
}
