
class PrefixTree {
    class Trie{
        Trie []children;
        boolean isEndOfWord;
        Trie(){
            children=new Trie[26];
            isEndOfWord=false;
        }
    }
    Trie head;

    public PrefixTree() {
        head=new Trie();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        Trie curr=head;
        for(int i=0;i<word.length();i++){
            int a=word.charAt(i)-'a';
            if(curr.children[a]==null){
                return false;
            }
            curr=curr.children[a];
        }
        return curr.isEndOfWord==true;
    }

    public boolean startsWith(String word) {
        Trie curr=head;
        for(int i=0;i<word.length();i++){
            int a=word.charAt(i)-'a';
            if(curr.children[a]==null){
                return false;
            }
            curr=curr.children[a];
        }
        return true;
    }
}
