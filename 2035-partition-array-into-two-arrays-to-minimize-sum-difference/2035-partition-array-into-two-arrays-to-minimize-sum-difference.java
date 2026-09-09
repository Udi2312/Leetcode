class Solution {

    void generate(int[] nums, int i, int count, int sum,
                  List<List<Integer>> sums) {

        if (i == nums.length) {
            sums.get(count).add(sum);
            return;
        }

        // Skip
        generate(nums, i + 1, count, sum, sums);

        // Pick
        generate(nums, i + 1, count + 1, sum + nums[i], sums);
    }

    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int[] leftArr = new int[n];
        int[] rightArr = new int[n];

        for (int i = 0; i < n; i++) {
            leftArr[i] = nums[i];
            rightArr[i] = nums[i + n];
        }

        // sums[k] = all subset sums obtained by choosing k elements
        List<List<Integer>> leftSums = new ArrayList<>();
        List<List<Integer>> rightSums = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            leftSums.add(new ArrayList<>());
            rightSums.add(new ArrayList<>());
        }

        generate(leftArr, 0, 0, 0, leftSums);
        generate(rightArr, 0, 0, 0, rightSums);

        // Required for binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums.get(i));
        }

        int answer = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {

            List<Integer> left = leftSums.get(k);
            List<Integer> right = rightSums.get(n - k);

            for (int leftSum : left) {

                double target = (double) totalSum / 2 - leftSum;

                int pos = Collections.binarySearch(
                    right,
                    (int) Math.ceil(target)
                );

                if (pos < 0) {
                    pos = -pos - 1;
                }

                // Candidate >= target
                if (pos < right.size()) {
                    int selectedSum = leftSum + right.get(pos);

                    answer = Math.min(
                        answer,
                        Math.abs(totalSum - 2 * selectedSum)
                    );
                }

                // Candidate < target
                if (pos > 0) {
                    int selectedSum = leftSum + right.get(pos - 1);

                    answer = Math.min(
                        answer,
                        Math.abs(totalSum - 2 * selectedSum)
                    );
                }
            }
        }

        return answer;
    }
}