class Solution {
    public int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int minSwaps(int[] arr) {
        int n = arr.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> {
            int sumA = digitSum(arr[a]);
            int sumB = digitSum(arr[b]);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(arr[a], arr[b]);
        });
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] || idx[i] == i) continue;
            int j = i;
            int cycle = 0;
            while (!vis[j]) {
                vis[j] = true;
                j = idx[j];
                cycle++;
            }

            ans += cycle - 1;
        }
        return ans;
    }
}
