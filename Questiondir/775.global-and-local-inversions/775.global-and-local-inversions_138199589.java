class Solution {
    public boolean isIdealPermutation(int[] A) {
        int localRe = 0;
        for (int i = 0; i < A.length -1; i++) {
            if (A[i] > A[i+1]) localRe++;
        }

        int globalRe = mergeSort(A, 0, A.length);
        return globalRe == localRe;
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l + 1 >= r) return 0;
        int mid = l + (r - l) / 2;
        int cnt = mergeSort(nums, l, mid);
        cnt += mergeSort(nums, mid, r);
        int[] tmpNums = new int[r-l];

        int i = l;
        int j = mid;
        int t = mid;
        int k = 0;
        while (i < mid) {
            while (j < r && nums[i] < (long)nums[j]) j++;
            while (t < r && nums[i] < nums[t]) tmpNums[k++] = nums[t++];
            cnt += r - j;
            tmpNums[k++] = nums[i++];
        }
        System.arraycopy(tmpNums, 0, nums, l, k);
        return cnt;
    }
}