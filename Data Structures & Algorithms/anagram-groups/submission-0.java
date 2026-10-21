class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char []word=s.toCharArray();
            Arrays.sort(word);
            String res=Arrays.toString(word);
            map.computeIfAbsent(res,k->new ArrayList<>()).add(s);
        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
