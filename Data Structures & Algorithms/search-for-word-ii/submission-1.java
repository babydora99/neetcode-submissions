class TrieNode{
    TrieNode[] children=new TrieNode[26];
    String word=null;
}

class Solution {

    private TrieNode root;
    private List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        root=new TrieNode();
        result=new ArrayList<>();

        //1.Insert all words into Trie
        for(String word:words){
            insert(word);
        }

        //2.Start DFS from every cell
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,root);
            }
        }
        return result; 
    }
    
    //Insert words to Trie
    private void insert(String word){
        TrieNode curr=root;

        for(char c:word.toCharArray()){
            int index=c-'a';

            if(curr.children[index]==null){
                curr.children[index]=new TrieNode();
            }
            curr=curr.children[index];
        }
        curr.word=word;
    }
    //dfs+Backtracking
    private void dfs(char[][] board,int r,int c,TrieNode node){
        if(board[r][c]=='#') return;
        char ch=board[r][c];
        int index=ch-'a';

        TrieNode child=node.children[index];

        //no matching Trie path
        if(child==null){
            return;
        }

        //complete word found
        if(child.word!=null){
            result.add(child.word);
            child.word=null;
        }

        //Mark current cell as visited
        board[r][c]='#';

        //Explore four directions
        //Up
        if(r>0){
            dfs(board,r-1,c,child);
        }

        //Down
        if(r<board.length-1){
            dfs(board,r+1,c,child);
        }

        //Left
        if(c>0){
            dfs(board,r,c-1,child);
        }

        //Right
        if(c<board[0].length-1){
            dfs(board,r,c+1,child);
        }
        
        //Restore original character
        board[r][c]=ch;
        //Remove exhausted Trie branches(pruning)
        if(child.word==null && isEmpty(child)){
            node.children[index]=null;
        }
    }
    private boolean isEmpty(TrieNode node){
        for(TrieNode child:node.children){
            if(child!=null){
                return false;
            }
        }
        return true;
    }
}
