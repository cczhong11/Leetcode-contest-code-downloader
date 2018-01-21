public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] sums = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            sums[i] = (i>0?sums[i-1]:0) + nums[i];
        }

        double max = (double)Integer.MIN_VALUE;
        for(int k2 =k; k2 <=Math.min(2*k, nums.length); k2++) {
            int localSum = Integer.MIN_VALUE;
            for(int i=k2-1; i<nums.length; i++) {
                int j = i-k2;
                int sum = sums[i] - (j>=0?sums[j]:0);
                localSum = Math.max(localSum, sum);
            }
            double avg = localSum / (double)k2;
            max = Math.max(max, avg);
        }

        return max;
        
    }
}