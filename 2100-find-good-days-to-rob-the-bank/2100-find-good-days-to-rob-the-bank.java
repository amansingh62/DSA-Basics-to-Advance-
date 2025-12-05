class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> result = new ArrayList<>();
        
        if(time == 0){
            for(int i = 0; i < n; i++){
                result.add(i);
            }
            return result;
        }

        int[] nonInc = new int[n + 1];
        int[] nonDec = new int[n + 1];

        for(int i = 1; i < n; i++){
            if(security[i] <= security[i - 1]){
            nonInc[i] = nonInc[i - 1] + 1;
        }
        }

        for(int i = n - 2; i >= 0; i--){
            if(security[i] <= security[i + 1]){
                nonDec[i] = nonDec[i + 1] + 1;
            }
        }

        for(int i = 0; i < n; i++){
            if(nonInc[i] >= time && time <= nonDec[i]){
                result.add(i);
            }
        }
        return result;
    }
}