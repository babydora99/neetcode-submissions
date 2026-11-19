//Topological Sorting + BFS (Kahn's Algorithm)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];

        //create adjacency list
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }    
        //Build graph
        for(int[] pre:prerequisites){
            int course=pre[0];
            int prerequisite=pre[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        //Add courses with indegree 0
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] res=new int[numCourses];
        int index=0;

        //Topological sorting using bfs
        while(!q.isEmpty()){
            int curr=q.poll();
            res[index++]=curr;
            for(int next:adj.get(curr)){
                indegree[next]--;

                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
        //Check for cycle
        if(index!=numCourses){
            return new int[0];
        }
        return res;
    }
}
