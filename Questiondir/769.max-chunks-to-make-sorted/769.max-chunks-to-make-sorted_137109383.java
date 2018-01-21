class Solution {
    public int maxChunksToSorted(int[] arr) {

        int n = arr.length;
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> posSet = new HashSet<>();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            numSet.add(arr[i]);
            posSet.add(i);

            if (okay(numSet, posSet)) {
                ans++;
                numSet = new HashSet<>();
                posSet = new HashSet<>();
            }
        }

        return ans;
    }

    private boolean okay(Set<Integer> numSet, Set<Integer> posSet) {
        for (int d : numSet) {
            if (!posSet.contains(d)) return false;
        }
        return true;
    }
}