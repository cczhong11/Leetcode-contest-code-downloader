public class Solution {
    int[][] nums;

    public int[] smallestRange(int[][] nums) {
        int[] res = {-100000, 100000};
        this.nums=  nums;

        Set<Integer> vis = new HashSet<>();

        for (int i = 0; i < nums.length; i ++) {
            for (int v : nums[i]) {
                if (vis.contains(v)) continue;
                vis.add(v);
                
                int s = v, t = v;
                boolean ok = true;
                for (int j = 0; j < nums.length; j ++) {
                    int len = nums[j].length;
                    if (nums[j][len - 1] < s) {
                        ok = false;
                        break;
                    }
                    int pos = Arrays.binarySearch(nums[j], t);
                    if (pos >= 0 || - pos - 1 >= nums[j].length) {
                        continue;
                    }
                    int pp = - pos - 1;
                    if (pp > 0 && s <= nums[j][pp - 1] && nums[j][pp - 1] <= t) {
                        continue;
                    }
                    t = Math.max(t, nums[j][- pos - 1]);
                }

                if (ok) {
                    int[] one = {s, t};
                    update(one, res);
                }
            }
        }
        return res;
    }

    void update(int[] a, int[] b) {
        int da = a[1] - a[0];
        int db = b[1] - b[0];
        if (da < db) {
            b[0] = a[0];
            b[1] = a[1];
            return;
        }
        if (da > db) return;

        if (a[0] < b[0]) {
            b[0] = a[0];
            b[1] = a[1];
        }
    }
}