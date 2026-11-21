//DFS + Min Heap
class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();     
    List<String> res=new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //Build directed Graph
        for(List<String> ticket:tickets){
            String from=ticket.get(0);
            String to=ticket.get(1);

            adj.putIfAbsent(from,new PriorityQueue<>());
            adj.get(from).offer(to);
        }
        //Start DFS from JFK
        dfs("JFK");
        return res;
    }
    private void dfs(String airport){
        PriorityQueue<String> destination=adj.get(airport);
        while(destination!=null && !destination.isEmpty()){
            String next=destination.poll();
            dfs(next);
        }
        //Add airport after using all outgoing tickets
        res.add(0,airport);
    }
}
