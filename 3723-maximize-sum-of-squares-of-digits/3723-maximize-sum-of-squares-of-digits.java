class Solution {
    public String maxSumOfSquares(int num, int sum) {
         if(sum > num * 9) return "";
        char[] arr = new char[num];
        int nines = sum / 9;
        int rem = sum % 9;
        int k = 0;
        for(int i = 0; i<nines; i++) arr[k++] = '9';
        if(k < num) arr[k++] = (char)('0' + rem);
        while(k < num){
            arr[k++] = '0';
        }
        StringBuilder sb = new StringBuilder("");
        for(char c : arr) sb.append(c);
        return sb.toString();
    }
}