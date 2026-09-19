class Solution {
    int count = 0;
    public void mergesort(int[] nums , int i , int j){
        if(i>=j) return;
        int mid = i + (j-i)/2;
        mergesort(nums,i,mid);
        mergesort(nums,mid+1,j);

        countpairs(nums,i,mid,j);
        merge(nums,i,mid,j);
    }
    public void merge(int[] nums, int l, int mid, int r){
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            nums[l + x] = temp[x];
        }
    }
    public void countpairs(int[] nums, int l, int mid, int r){
        int j = mid + 1;
        for(int i = l; i<=mid; i++){
            while(j<=r && (long)nums[i] > 2L * nums[j]){
                j++;
            }
            count += j-(mid+1);
        }
    }
    public int reversePairs(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return count;
    }
}