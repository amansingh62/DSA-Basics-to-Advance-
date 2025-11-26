class Solution {
    class DSU {
        int[] parent;

        DSU(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px != py){
                parent[px] = py;
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(n);

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.union(i, j);
                }
            }
        }

        int components = 0;
        for(int i = 0; i < n; i++){
            if(dsu.find(i) == i){
                components++;
            }
        }

        return n - components;
    }
}
