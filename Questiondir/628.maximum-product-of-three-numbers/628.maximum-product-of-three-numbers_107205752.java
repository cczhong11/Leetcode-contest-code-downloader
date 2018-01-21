import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        int i,j,k,n = nums.length;
        Arrays.sort(nums);
        int []x = nums;
        return Math.max(x[n-1]*x[n-2]*x[n-3],x[0]*x[1]*x[n-1]);
    }
}