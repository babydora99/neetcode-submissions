//Topological Sorting (Kahn’s Algorithm) with BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        //Add courses with no prerequisites
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int completed=0;
        //BFS
        while(!q.isEmpty()){
            int curr=q.poll();
            completed++;
            for(int next:adj.get(curr)){
                indegree[next]--;
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
        return completed==numCourses;
    }
}
