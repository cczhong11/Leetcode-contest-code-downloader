class Solution {
    public int reachNumber(int target) {
        if (target < 0) return reachNumber(-target);
        if (target == 0) return 0;
        int sum = 0, i = 1;
        while (sum < target || (sum - target) % 2 != 0)
            sum += i++;
        return i - 1;
    }
}