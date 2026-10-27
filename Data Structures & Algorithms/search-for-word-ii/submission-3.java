class Solution {
    class Trie{
        Trie []children;
        boolean isEndOfWord;
        Trie(){
            children=new Trie[26];
            isEndOfWord=false;
        }
    }
    Trie head=new Trie();
    private int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
    private int n;
    private int m;
    public void addWord(String word) {
        Trie curr=head;
        for(int i=0;i<word.length();i++){
            int a=word.charAt(i)-'a';
            if(curr.children[a]==null){
                curr.children[a]=new Trie();
            }
            curr=curr.children[a];
        }
        curr.isEndOfWord=true;
    }
    public List<String> findWords(char[][] board, String[] words) {
        n=board.length;
        m=board[0].length;
        Trie curr=head;
        for(String word:words){
            addWord(word);
        }
        boolean visited[][]=new boolean[n][m];
        List<String> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&curr.children[board[i][j]-'a']!=null){
                    dfs(i,j,ans,visited,curr.children[board[i][j]-'a'],""+board[i][j],board);
                }
            }
        }
        return ans;
    }
    public void dfs(int i,int j,List<String> ans,boolean [][]visited,Trie curr,String a,char[][]board){
        visited[i][j]=true;
        if(curr.isEndOfWord){
            ans.add(a);
            curr.isEndOfWord=false;
        }
        for(int d[]:directions){
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni>=0&&nj>=0&&ni<n&&nj<m&&!visited[ni][nj]&&curr.children[board[ni][nj]-'a']!=null){
                dfs(ni,nj,ans,visited,curr.children[board[ni][nj]-'a'],a+board[ni][nj],board);
                
            }
            
        }
        visited[i][j]=false;
        
    }
}
