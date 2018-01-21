class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<2) return 0;
        long prod = 1;
        int n = nums.length;
        int i = 0, j = 0;
        int ret = 0;
        while(i<n) {
            if(prod < k) {
                if (j==n) {
                    // System.out.println("Adding " + i +","+j+" and return");
                    ret += ((j-i) * (j-i+1) / 2);
                    return ret;
                }
                prod *= nums[j];
                j += 1;
            } else {
                j -= 1;
                prod /= nums[j];
                if(i==j) {
                    if (prod!=1) throw new RuntimeException("Product from "+i+" to "+(j-1)+" is not 1.");
                    i += 1;
                    j += 1;
                } else {
                    // System.out.println("Adding " + i +","+j+" ");
                    ret += (j-i);
                    prod /= nums[i];
                    i += 1;
                }
            }
        }
        return ret;
    }
}

/*

[10,5,2,6]
100
[2,2,2,2]
1
[5,5,5,5]
25
[5,5,5,5]
126

*/