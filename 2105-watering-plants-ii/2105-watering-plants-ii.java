class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0, j = plants.length - 1;
        int a = capacityA, b = capacityB;

        int refills = 0;

        while(i < j){
            if(a < plants[i]){
                refills++;
                a = capacityA;
            }

            a -= plants[i];
            i++;

            if(b < plants[j]){
                refills++;
                b = capacityB;
            }

            b -= plants[j];
            j--;
        }

        if(i == j){
            if(Math.max(a, b) < plants[i]){
                refills++;
            }
        }

        return refills;
    }
}