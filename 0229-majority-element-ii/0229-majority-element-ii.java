class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int f1 = 0;
        int f2 = 0;
        int ans1 = 0;
        int ans2 = 0;
        int n = nums.length;
        for(int i = 0; i<nums.length; i++){
            if(ans1 == nums[i] && f1 > 0) f1++;
            else if(ans2 == nums[i] && f2 > 0) f2++;
            else if(f1==0){
                ans1 = nums[i];
                f1 = 1;
            }
           else if(f2==0){
                ans2 = nums[i];
                f2 = 1;
            }

            else{
                f1--;
                f2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            if(num==ans1) count1++;
            if(num==ans2) count2++;
        }
       if(count1 > n/3) ans.add(ans1);
       if(count2 > n/3 && ans1 != ans2) ans.add(ans2);
        return ans;
    }
    }
