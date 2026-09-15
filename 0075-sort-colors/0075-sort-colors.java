class Solution {
    public void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void sortColors(int[] arr) {
        int l = 0;
        int m = 0;
        int h = arr.length-1;
        while(m<=h){
            if(arr[m]==0){
                swap(arr,m,l);
                m++;
                l++;
            }
            else if(arr[m]==1) m++;
            else{
                swap(arr,m,h);
                h--;
            }
        }
    }
}