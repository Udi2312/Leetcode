    class Solution {
        int ans;
        public int longestConsecutive(int[] nums) {
            ans = 0;
            HashSet<Integer> st = new HashSet<>();
            for(int num : nums) st.add(num);
            int count = 0;
            for(int num : st){
                if(st.contains(num-1)) continue;
                else{
                    count++;
                    num++;
                    while(st.contains(num)){
                        count++;
                        num++;
                    }
                    ans = Math.max(ans , count);
                    count = 0;
                }
            }
            return ans;
        }
    }