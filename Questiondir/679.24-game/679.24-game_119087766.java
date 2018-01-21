class Solution {
    public boolean judgePoint24(int[] nums) {
        double[] doubleNums = new double[4];
        for (int i = 0; i < 4; i++) doubleNums[i] = (double) nums[i];
        return judgeRec(doubleNums);
    }

    boolean judgeRec(double[] nums) {
        if (nums.length == 1) return Math.abs(24 - nums[0]) < 2 * Double.MIN_VALUE;
        double[] res = new double[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                double numA = nums[i];
                double numB = nums[j];

                int nextIndex = 0;
                for (int k = 0; k < nums.length; k++) {
                    if (k == i || k == j) continue;
                    res[nextIndex++] = nums[k];
                }
                res[nextIndex] = numA + numB;
                if (judgeRec(res)) return true;

                res[nextIndex] = numA * numB;
                if (judgeRec(res)) return true;

                res[nextIndex] = numA - numB;
                if (judgeRec(res)) return true;

                res[nextIndex] = numB - numA;
                if (judgeRec(res)) return true;

                if (numB != 0) {
                    res[nextIndex] = numA / numB;
                    if (judgeRec(res)) return true;
                }

                if (numA != 0) {
                    res[nextIndex] = numB / numA;
                    if (judgeRec(res)) return true;
                }
            }
        }
        return false;
    }
}