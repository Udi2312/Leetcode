class Solution {
    public int maxProfit(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int pro  = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
                max = arr[i];
                pro = Math.max(pro,max-min);
                continue;
            }
            if(arr[i] > max){
                max = arr[i];
                pro = Math.max(pro,max-min);
            }
        }
        return pro;
    }
}