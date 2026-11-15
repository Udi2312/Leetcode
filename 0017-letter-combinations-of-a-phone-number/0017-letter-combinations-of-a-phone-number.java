class Solution {
    public void helper(String arr[] , List<String> ans , int i, String digits, StringBuilder sb){
        if(i >= digits.length()){
            ans.add(sb.toString());
            return;
        }
        int c = digits.charAt(i) - '0';
        for(char ch : arr[c].toCharArray()){
            sb.append(ch);
            helper(arr , ans , i+1, digits, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String arr[] = new String[10];
        arr[0] = "";
        arr[1] = "";
        arr[2] = "abc";
        arr[3] = "def";
        arr[4] = "ghi";
        arr[5] = "jkl";
        arr[6] = "mno";
        arr[7] = "pqrs";
        arr[8] = "tuv";
        arr[9] = "wxyz";
        helper(arr , ans , 0, digits, new StringBuilder());
        return ans;
    }
}