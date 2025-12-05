class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int[] prefixN = new int[n + 1];
        int[] prefixY = new int[n + 1];

        for(int i = 0; i < n; i++){
            prefixN[i + 1] = prefixN[i] + (customers.charAt(i) == 'N' ? 1 : 0);
            prefixY[i + 1] = prefixY[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        int totalY = prefixY[n];
        int bestPenalty = Integer.MAX_VALUE;
        int bestHour = 0;

        for(int j = 0; j <= n; j++){
           int openPenalty = prefixN[j];
           int closedPenalty = totalY - prefixY[j];
           int penalty = openPenalty + closedPenalty;

           if(penalty < bestPenalty){
            bestPenalty = penalty;
            bestHour = j;
        }
        }

        return bestHour;
    }
}