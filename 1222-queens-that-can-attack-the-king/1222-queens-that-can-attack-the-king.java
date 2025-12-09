class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Set<String> set = new HashSet<>();

        for(int[] q : queens){
            set.add(q[0] + "," + q[1]);
        } 

        List<List<Integer>> result = new ArrayList<>();

        int[][] dir = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        for(int[] d : dir){
          int r = king[0];
          int c = king[1];

          while(true){
            r += d[0];
            c += d[1];

            if(r < 0 || r >= 8 || c < 0 || c >= 8){
              break;
            }

            if(set.contains(r + "," + c)){
                result.add(Arrays.asList(r, c));
                break;
            }
          }
        }

        return result;
    }
}