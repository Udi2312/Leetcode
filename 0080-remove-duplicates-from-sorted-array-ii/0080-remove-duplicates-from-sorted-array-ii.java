class Solution {
    public int removeDuplicates(int[] arr) {
        int l = 0;
        int r = 0;
        while(r < arr.length){
            int ct = 1;
            while(r + 1<arr.length && arr[r] == arr[r+1]){
                r++;
                ct++;
            }
            for(int i = 0; i<Math.min(2,ct); i++){
                arr[l++] = arr[r];
            }
            r++;
        }
        return l;
    }
}