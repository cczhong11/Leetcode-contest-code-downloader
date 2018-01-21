class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i]==B[j]) {
                    int temp = ans[i];
                    ans[i] = j;
                    for (int k = 0; k < i; k++) {
                        if (ans[k]==j)
                            ans[i] = temp;
                    }
                }
            }
        }
        return ans;
    }
}