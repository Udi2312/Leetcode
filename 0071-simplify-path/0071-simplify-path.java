    class Solution {
        public String simplifyPath(String path) {
            String arr[] = path.split("/");
            Stack<String> st = new Stack<>();
            for(String s : arr){
                if(s.equals(".") || s.equals("")) continue;
                if(s.equals("..")){
                    if(st.size() > 0) st.pop();
                }
                else{
                    st.push(s);
                }
            }
            if(st.size() == 0) return "/";
            String res = "";
            while(st.size() > 0){
                res = "/" + st.pop() + res;
            }
            return res;
        }
    }