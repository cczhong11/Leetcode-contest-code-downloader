class Solution {
    int bit[] = null;
    boolean[] flower;
    int n;
    public int kEmptySlots(int[] flowers, int k) {
        n = flowers.length;
        bit = new int[n + 10];
        flower = new boolean[n + 10];
        int ans = 0;
        for (int pos : flowers) {
            ans++;
            update(pos);
            if (valid(pos - k - 1, pos) ||
                    valid(pos, pos + k + 1)) {
                return ans;
            }
        }
        return -1;
    }

    int lb(int x) {
        return x & -x;
    }
    void update(int x) {
        flower[x] = true;
        for (int i = x; i <= n; i+= lb(i)) {
            bit[i]++;
        }
    }
    
    int sum(int x) {
        int ans = 0;
        for (int i = x; i >= 1; i-=lb(i)) {
            ans += bit[i];
        }
        return ans;
    }
    private boolean valid(int x, int y) {
        if (x < 1 || x > n || y < 1 || y > n) return false;
        if (!flower[x] || !flower[y]) return false;
        return sum(x) + 1 == sum(y);
    }
}