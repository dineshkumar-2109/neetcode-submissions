class WordDictionary {
    class Trie{
        Trie []children;
        boolean isEndOfWord;
        Trie(){
            children=new Trie[26];
            isEndOfWord=false;
        }
    }
    Trie head;
    public WordDictionary() {
        head=new Trie();
    }

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
    public boolean find(String word,Trie curr,int ind){
        if(ind==word.length()){
            if(curr.isEndOfWord==false){
                return false;
            }else{
                return true;
            }
            
        }
        if(word.charAt(ind)!='.'){
            int a=word.charAt(ind)-'a';
            if(curr.children[a]==null){
                return false;
            }
            if(find(word,curr.children[a],ind+1)){
                return true;
            }
        }else{
            
            for(int i=0;i<26;i++){
                if(curr.children[i]!=null&&find(word,curr.children[i],ind+1)){
                   return true;
                }
            }
        }
        return false;

    }
    public boolean search(String word) {
        Trie curr=head;
        return find(word,curr,0);
    }
    
}
