class Solution {
    public void create(int left,int right,String  a,List<String> ans ){
        if(left==0&&right==0){
            ans.add(a);
        }
        if(left>0){
            create(left-1,right+1,a+"(",ans);

        }
        if(right>0){
            create(left,right-1,a+")",ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        create(n,0,"",ans);
        return ans;

        
    }
}