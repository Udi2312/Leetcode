class NumArray {
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        if(n > 0) build(nums , 0 , 0, n-1);
    }
    
    public void build(int[] nums , int idx , int l, int r){
        if(l == r){
            tree[idx] = nums[l];
            return;
        }
        int mid = (l + r)/2;
        build(nums , 2 * idx + 1, l , mid);
        build(nums , 2 * idx + 2, mid+1 , r);

        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }

    public int query(int idx , int st, int end , int left, int right){
        if(left > end || right < st) return 0;
        else if(left <= st && right >= end) return tree[idx];
        int mid = st + (end-st)/2;
        int lans = query(2*idx+1,st , mid , left, right);
        int rans = query(2*idx+2,mid+1 , end , left, right);
        return lans + rans;
    }
    public int sumRange(int left, int right) {
        return query(0 , 0, n-1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */