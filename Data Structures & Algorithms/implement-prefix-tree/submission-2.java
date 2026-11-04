class TrieNode{
    HashMap<Character,TrieNode> children=new HashMap<>();
    boolean endsWith=false;
}
class PrefixTree {
    private TrieNode root;
    public PrefixTree(){
        root=new TrieNode();
    }


    public void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            curr.children.putIfAbsent(c,new TrieNode());
            curr=curr.children.get(c);
        }
        curr.endsWith=true;
    }

    public boolean search(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr=curr.children.get(c);
        }
        return curr.endsWith;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char c:prefix.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr=curr.children.get(c);
        }
        return true;
    }
}
