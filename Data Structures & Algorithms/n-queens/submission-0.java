class Solution {
    public boolean check(char[][]queens,int r,int c){
        for(int ind=0;ind<queens[0].length;ind++){
            if(queens[r][ind]=='Q') return false;
            
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (queens[i][j] == 'Q') return false;
        }
        
        for (int i = r, j = c; i < queens.length && j >= 0; i++, j--) {
            if (queens[i][j] == 'Q') return false;
        }
        return true;
        
    }
    public void solve(char [][]queens,int ind,List<List<String>> result){
        if(ind==queens[0].length){
            createList(queens,result);
            return ;
        }
        for(int i=0;i<queens.length;i++){
            if(check(queens,i,ind)){
                queens[i][ind]='Q';
                solve(queens,ind+1,result);
                queens[i][ind]='.';

            }
        }
        return ;
    }
    public void createList(char[][]queens,List<List<String>> result){
        List<String>ans=new ArrayList<>();
        for(int i=0;i<queens.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<queens[0].length;j++){
                sb.append(queens[i][j]);
            }
            ans.add(sb.toString());

        }
        result.add(new ArrayList<>(ans));
    }
    public List<List<String>> solveNQueens(int n) {
        char [][]queens=new char[n][n];
        for(char row[]:queens){
            Arrays.fill(row,'.');
        }
        List<List<String>> result=new ArrayList<>();
        solve(queens,0,result);
        return result;
        
        

    }
}
