class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i<s.length(); i++){
            if(st.size() == 0) st.push(s.charAt(i));
            else{
                char ch = s.charAt(i);
                if(ch == '('){
                st.push(ch);
                sb.append(ch);
                }
                else{
                    if(st.size() > 1){
                     st.pop();
                     sb.append(ch);
                    }
                    else st.pop();
                }
            }
        }
        return sb.toString();
    }
}