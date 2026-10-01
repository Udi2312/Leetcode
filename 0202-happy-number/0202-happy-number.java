class Solution {
    HashSet<Integer> st  = new HashSet<>();
    public boolean isHappy(int n) {
        // st = new HashSet<>();
        int num = n;
        int next = 0;
        while(num > 0){
            int curr = num%10;
            next += curr * curr;
            num = num/10;
        }
        if(next == 1) return true;
        else{
            if(st.contains(next)) return false;
            st.add(next);
            return isHappy(next);
        }
    }
}