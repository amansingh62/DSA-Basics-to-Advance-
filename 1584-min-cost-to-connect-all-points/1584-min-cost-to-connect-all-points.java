class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] -b[0]);
        pq.add(new int[]{0, 0});

        int result = 0;
        int connected = 0;

        while(connected < n){
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];

            if(visited[u]) continue;

            visited[u] = true;
            result += cost;
            connected++;

            for(int v = 0; v < n; v++){
                if(!visited[v]){
                    int dist = Math.abs(points[u][0] - points[v][0]) +
                               Math.abs(points[u][1] - points[v][1]);

                   pq.add(new int[]{dist, v}); 
                }
            }
        }
        return result;
    }
}