class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        boolean[] bloom = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int x = flowers[i];
            bloom[x] = true;

            int left = x - k - 1;
            int right = x + k + 1;

            if (left >= 1 && bloom[left]) {
                int countNotBloom = 0;
                for (int j = left + 1; j < x; j++) {
                    if (bloom[j]) {
                        break;
                    } else {
                        countNotBloom++;
                    }
                }
                if (countNotBloom == k) {
                    return i + 1;
                }
            }

            if (right <= n && bloom[right]) {
                int countNotBloom = 0;
                for (int j = x + 1; j < right; j++) {
                    if (bloom[j]) {
                        break;
                    } else {
                        countNotBloom++;
                    }
                }

                if (countNotBloom == k) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}