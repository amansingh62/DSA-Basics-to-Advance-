class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int INF = (int)1e9;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for(int[] e : edges){
            int u = e[0], v = e[1], w = e[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int city = -1;
        int minCount = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i != j && dist[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= minCount){
            minCount = count;
            city = i;
        }
        }
        return city;
    }
    
}