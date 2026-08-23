class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sum1 = 0, cnt1 = 0; // first half: sum of fixed digits, count of '?'
        int sum2 = 0, cnt2 = 0; // second half

        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') cnt1++;
            else sum1 += c - '0';
        }
        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') cnt2++;
            else sum2 += c - '0';
        }

        int totalQ = cnt1 + cnt2;

        // If total number of '?' is odd, Alice always wins.
        if (totalQ % 2 == 1) return true;

        // Even case: Bob can neutralize any excess '?' by mirroring moves.
        // He wins only if the current sum difference exactly matches
        // what the extra '?' pairs (each forced to sum to 9) would need to offset it.
        int diff = sum1 - sum2;
        int need = 9 * (cnt2 - cnt1) / 2;

        return diff != need; // true => Alice wins, false => Bob wins
    }
}