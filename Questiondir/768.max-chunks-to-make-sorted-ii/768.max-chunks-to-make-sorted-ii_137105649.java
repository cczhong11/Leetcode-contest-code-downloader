class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] minToRight = new int[arr.length];
        minToRight[arr.length-1] = Integer.MAX_VALUE;
        for (int index = arr.length-2; index >= 0; index--) minToRight[index] = Math.min(minToRight[index+1], arr[index+1]);
        int result = 0;
        int max = 0;
        for (int index = 0; index < arr.length; index++) {
            max = Math.max(max, arr[index]);
            if (max <= minToRight[index]) result++;
        }
        return result;
    }
}