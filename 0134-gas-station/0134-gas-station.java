class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gassum = 0;
        int costsum = 0;
        for(int e : gas){
            gassum += e;
        }
        for(int e : cost){
            costsum += e;
        }
        if(gassum < costsum) return -1;
        int res = 0;
        int total = 0;
        for(int i = 0; i<gas.length; i++){
            total += gas[i]-cost[i];
            if(total < 0){
                total = 0;
                res = i+1;
            }
        }
        return res;
    }
}