class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int left = -10, right = 2000000;
        
        while(right-left>1) {
            int middle = (left + right) / 2;
            int pairsBelow = numberOfDistancesNoGreaterThan(nums, middle);
            if(pairsBelow<k) left = middle;
            else right = middle;
        }
        
        return right;
    }
    
    public int numberOfDistancesNoGreaterThan(int[] nums, int bar) {
        Arrays.sort(nums);
        return numberOfDistancesNoGreaterThan(nums, 0, nums.length, bar);
    }
    
    public int numberOfDistancesNoGreaterThan(int[] nums, int begin, int end, int bar) {
        // assume nums is already sorted
        int n = end - begin;
        if(n<10) {
            int ret = 0;
            for(int i=begin;i<end-1;i++) for(int j=i+1;j<end;j++) {
                if(nums[j]-nums[i]<=bar) ret += 1;
            }
            return ret;
        }
        
        int middle = (begin + end) / 2;
        int ret = numberOfDistancesNoGreaterThan(nums, begin, middle, bar)
                    + numberOfDistancesNoGreaterThan(nums, middle, end, bar);
        int i = begin, j = middle;
        while(i<middle && nums[j]-nums[i]>bar) i++;
        while(i<middle) {
            while(j+1<end && nums[j+1]-nums[i]<=bar) j++;
            ret += (j+1-middle);
            i += 1;
        }
        return ret;
        
    }
}