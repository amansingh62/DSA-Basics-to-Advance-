class Solution {
    private boolean hasCycle = false;

    private void dfs(int node, List<List<Integer>> adj, int[] state, Stack<Integer> stack){
        if(state[node] == 1){
            hasCycle = true;
            return;
        }

        if(state[node] == 2) return;

        state[node] = 1;

        for(int neigh : adj.get(node)){
            dfs(neigh, adj, state, stack); 
        }

        state[node] = 2; 
        stack.push(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course); 
        }

        int[] state = new int[numCourses]; 
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < numCourses; i++){
           if(state[i] == 0){
               dfs(i, adj, state, stack);
           }
        }

        if(hasCycle) return new int[0];

        int[] order = new int[numCourses];
        int index = 0;

        while(!stack.isEmpty()){
            order[index++] = stack.pop();
        }

        return order;
    }
}
