class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        run(n, k, ans, 0);
        return ans;
    }
    
    private void run(int n, int k, int[] ans, int index) {
        int s = 1;
        int e = n;
        
        while (k > 2) {
            ans[index++] = s++;
            ans[index++] = e--;
            k -= 2;
        }

        if (k == 1) {
            for (int i = s; i <= e; i++) {
                ans[index++] = i;
            }
        }
        else {
            for (int i = s; i <= e - 2; i++) {
                ans[index++] = i;
            }
            ans[index++] = e;
            ans[index++] = e - 1;
        }
    }
}