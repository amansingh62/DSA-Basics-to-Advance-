class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(hasCycle(i, graph, visited)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> graph, int[] visited){
        visited[course] = 1;

        for(int next : graph.get(course)){
            if(visited[next] == 1){
                return true;
            }

            if(visited[next] == 0 && hasCycle(next, graph, visited)){
                return true;
            }
        } 

        visited[course] = 2;
        return false;
    }


}