class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        Map<String, Integer> pair = new HashMap<>();

        for(int i = 0; i < n; i++){
            String key = buildKey(grid[i]);
            pair.put(key, pair.getOrDefault(key, 0) + 1);
        }

        int count = 0;

        for(int c = 0; c < n; c++){
            int[] colArr = new int[n];

            for(int r = 0; r < n; r++){
                colArr[r] = grid[r][c];
            }
             
             String colKey = buildKey(colArr);

             if(pair.containsKey(colKey)){
                count += pair.get(colKey);
             }
        }
        return count;
    }

    private String buildKey(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int x : arr){
            sb.append(x).append(',');
        }
        return sb.toString();
    }
}