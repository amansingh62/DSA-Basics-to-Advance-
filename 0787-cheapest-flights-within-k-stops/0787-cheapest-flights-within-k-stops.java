class Solution {
    static class Node {
        int city, cost, stops;

        Node(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int[] f : flights){
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.cost - b.cost
        );

        pq.offer(new Node(src, 0, 0));

        int[][] best = new int[n][k + 2];
        for(int i = 0; i < n; i++){
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }

        best[src][0] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int city = curr.city;
            int cost = curr.cost;
            int stops = curr.stops;

            if(city == dst) return cost;
            if(stops > k) continue;

            for(int[] next : graph.get(city)){
                int nextCity = next[0];
                int price = next[1];
                int newCost = cost + price;

                if(newCost < best[nextCity][stops + 1]){
                     best[nextCity][stops + 1] = newCost;
                    pq.offer(new Node(nextCity, newCost, stops + 1));
                }
            }
        }

        return -1;
    }
}