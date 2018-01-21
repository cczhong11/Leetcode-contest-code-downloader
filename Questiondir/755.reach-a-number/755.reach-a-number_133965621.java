class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        for (int i = 1; i <= 100000; ++ i) {
            sum += i;
            if(sum == target) {
                return i;
            }
            if(sum > target) {
                if((sum - target) % 2 == 0) {
                    return i;
                }
                else {
                    return (i + 1) % 2 == 1 ? i + 1 : i + 2;
                }
            }
        }
        return -1;
    }
}