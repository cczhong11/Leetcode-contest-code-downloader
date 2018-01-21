class Solution {
    public int dominantIndex(int[] nums) {
        int max1=-1;
        int max2=-1;
        int max1p=0;
        int max2p=0;
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]>=max1)
            {
                max2=max1;
                max2p=max1p;
                max1=nums[i];
                max1p=i; 
            }
            else if (nums[i]>=max2)
            {
                max2=nums[i];
                max2p=i;
            }
            //System.out.println(max1+" "+max2);
        }
        if (max1/2>=max2)
            return max1p;
        else
            return -1;
    }
}