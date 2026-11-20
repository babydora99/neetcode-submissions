class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[n+1];

        //Initially,every node is its own parent
        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            //If both nodes belongs to the same group,this edge creates a cycle
            if(find(u)==find(v)){
                return edge;
            }
            //otherwise ,merge their groups
            union(u,v);
        }
        return new int[0];
    }
    //find representative with path compression
    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }    
        return parent[x];
    }
    //union by rank
    private void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);

        if(rank[rootX]<rank[rootY]){
            parent[rootX]=rootY;
        }else if(rank[rootX]>rank[rootX]){
            parent[rootY]=rootX;
        }else{
            parent[rootY]=rootX;
            rank[rootX]++;
        }
    }
}
