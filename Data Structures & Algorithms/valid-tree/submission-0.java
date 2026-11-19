//DFS + Cycle Detection
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        //Build adjacency list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        //start dfs from node 0
        dfs(0,adj,visited);
        //check whether all nodes are visited
        for(int i=0;i<n;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
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
