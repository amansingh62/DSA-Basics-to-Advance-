class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(!bfs(graph, i, color)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int start, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neigh : graph[node]){
                if(color[neigh] == -1){
                    color[neigh] = 1 - color[node];
                    q.offer(neigh);
                } else if (color[neigh] == color[node]){
                return false;
            }
            } 
        }
        return true;
    }
}