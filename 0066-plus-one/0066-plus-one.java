class Solution {
    public int[] plusOne(int[] arr) {
        int n = arr.length;
        arr[n-1] += 1;
        int carry = arr[n-1]/10;
        arr[n-1] = arr[n-1] % 10;
        if(carry == 0) return arr;
        else{
            int j = n-2;
            while(carry != 0 && j >= 0){
                arr[j] += carry;
                carry = arr[j]/10;
                arr[j] = arr[j]%10;
                j--;
            }
            if(carry != 0 && j < 0){
                int ans[] = new int[n+1];
                ans[0] = 1;
                int k = 1;
                while(k<n){
                    ans[k++] = arr[k-1];
                }
                return ans;
            }
            return arr;
        }

    }
}