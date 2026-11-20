//DFS + Adjacency List
class Solution {
    public int countComponents(int n, int[][] edges) {
        //Create adjacency list
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //Build undirected graph
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited=new boolean[n];
        int count=0;

        //check every node
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,adj,visited);
            }
        }
        return count;
    }
    private void dfs(int node,List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;
        for(int neigh:adj.get(node)){
            if(!visited[neigh]){
                dfs(neigh,adj,visited);
            }
        }
    }
}
