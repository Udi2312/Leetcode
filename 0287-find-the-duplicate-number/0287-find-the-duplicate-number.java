class Solution {
    public int findDuplicate(int[] arr) {
        int s = arr[0];
        int f = arr[0];
        s = arr[s];
        f = arr[arr[f]];
        while(s != f){
        s = arr[s];
        f = arr[arr[f]];
        }
        s = arr[0];
        while(s != f){
            s = arr[s];
            f = arr[f];
        }
        return s;
    }
}