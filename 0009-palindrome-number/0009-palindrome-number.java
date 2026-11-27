class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x >= 0 && x <= 9) return true;
        int y = x;
        int d = 0;
        while(y>=1){
            y /= 10;
            d++;
        }
        int arr[] = new int[d];
        for(int i = 0; i<d; i++){
            arr[i] = x%10;
            x /= 10;
        }
        int i = 0;
        int j = d-1;
        while(i<j){
            if(arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}