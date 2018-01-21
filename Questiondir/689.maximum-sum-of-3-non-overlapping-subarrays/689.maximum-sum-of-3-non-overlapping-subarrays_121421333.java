class Solution {
    class Answer {
        public int sum = 0;
        public List<Integer> pos = new ArrayList<>();
    }
    int[] getPreSum(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
            if (i != 0) ans[i] += ans[i - 1];
        }
        return ans;
    }
    int sum(int[] pre, int start, int end) {
        if (start == 0) return pre[end];
        return pre[end] - pre[start - 1];
    }
    Answer select(Answer ans1, Answer ans2) {
        if (ans1 == null) {
            return ans2;
        }
        if (ans2 == null) {
            return ans1;
        }
        if (ans1.sum > ans2.sum) return ans1;
        if (ans1.sum < ans2.sum) return ans2;
        if (ans1.pos.toString().compareTo(ans2.pos.toString()) < 0) return ans1;
        return ans2;
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] presum = getPreSum(nums);
        Answer[][] ans = new Answer[4][n];
        Answer finalAns = null;
        Arrays.fill(ans[0], new Answer());
        for (int i = 1; i <= 3; i++) {
            for (int j = i * k - 1; j < n; j++) {
                Answer curr = new Answer();
                if (j - k >= 0) {
                    curr.sum += ans[i-1][j - k].sum;
                    curr.pos.addAll(ans[i-1][j - k].pos);
                }
                curr.sum += sum(presum, j - k + 1, j);
                curr.pos.add(j - k + 1);

                Answer last = j != i * k - 1 ? ans[i][j - 1] : null;
                ans[i][j] = select(curr, last);
                if (i == 3) {
                    finalAns = select (finalAns, ans[i][j]);
                }
            }
        }
        int[] ret = new int[3];
        for (int i = 0; i < 3; i++) ret[i] = finalAns.pos.get(i);
        return ret;
    }
}