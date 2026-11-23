//BFS + Kahn's Algorithm (Topological Sort) + Graph
class Solution {
    public String foreignDictionary(String[] words) {
    List<Set<Integer>> adj=new ArrayList<>();

    //Initialize graph for 26 lowercase letters
    for(int i=0;i<26;i++){
        adj.add(new HashSet<>());
    }
    int[] indegree=new int[26];
    boolean[] present =new boolean[26];

    //Identify all unique char
    int uniqueCount=0;
    for(String word:words){
        for(char c:word.toCharArray()){
            if(!present[c-'a']){
                present[c-'a']=true;
                uniqueCount++;
            }
        }
    } 
    //Build graph by comparing adjacent words
    for(int i=0;i<words.length-1;i++){
        String first=words[i];
        String second=words[i+1];

        int len=Math.min(first.length(),second.length());
        int j=0;
        while(j<len && first.charAt(j)==second.charAt(j)){
            j++;
        }

        //Invalid prefix case
        if(j==len){
            if(first.length()>second.length()){
                return "";
            }
            continue;
        }

        //first diff characters give ordering
        int u=first.charAt(j)-'a';
        int v=second.charAt(j)-'a';

        //avoid duplicate edges
        if(adj.get(u).add(v)){
            indegree[v]++;
        }
    }

    //Kahn's BFS
    Queue<Integer> q=new LinkedList<>();

    for(int i=0;i<26;i++){
        if(present[i] && indegree[i]==0){
            q.offer(i);
        }
    }
    StringBuilder res=new StringBuilder();
    while(!q.isEmpty()){
        int curr=q.poll();
        res.append((char) (curr+'a'));

        for(int neigh:adj.get(curr)){
            indegree[neigh]--;

            if(indegree[neigh]==0){
                q.offer(neigh);
            }
        }
    }

    //Cycle detection
    if(res.length()!=uniqueCount){
        return "";
    }
    return res.toString();
    }
}