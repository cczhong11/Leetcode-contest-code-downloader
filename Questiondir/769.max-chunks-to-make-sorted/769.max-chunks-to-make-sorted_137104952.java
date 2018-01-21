class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int result = 0;
        for (int index = 0; index < arr.length; index++) {
            max = Math.max(max, arr[index]);
            if (max == index) result++;
        }
        return result;
    }
}