public class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] b=new int[2];
        for (int i=1;i<n;i++)
            if (nums[i]==nums[i-1]) b[0]=nums[i];
        for (int i=1;i<n;i++)
            if (nums[i]==nums[i-1]+2) b[1]=nums[i]-1;
        if (nums[0]==2) b[1]=1;
        if (nums[n-1]!=n) b[1]=n;
        return b;
    }
}