class Solution {
    public boolean checkPossibility(int[] nums) {
        int[] arr = nums;
        boolean found = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (arr[i] <= arr[i+1]) continue;
            if (found) return false;
            if ((i == 0 || arr[i+1] >= arr[i-1]) || (i+1 == nums.length-1 || arr[i] <= arr[i+2] )) { found = true; continue; }
            return false;
        }
        return true;
    }
}