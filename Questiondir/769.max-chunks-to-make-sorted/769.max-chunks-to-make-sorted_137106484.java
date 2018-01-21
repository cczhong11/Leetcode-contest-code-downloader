class Solution {
    public int maxChunksToSorted(int[] nums) {
        int n = nums.length;
        if(n <= 1){
          return n;
        }
        int res = 0;
        int[] min = new int[n];
        min[n - 1] = Integer.MAX_VALUE;
        for(int i = n - 2; i >= 0; i--){
            min[i] = Math.min(min[i + 1], nums[i + 1]);
        }
        //System.out.println(Arrays.toString(min));
          int max = Integer.MIN_VALUE;
          for(int i = 0; i < n; i++){
              max = Math.max(nums[i], max);
              if(max < min[i]){
                  res++;
              }
          }
        return res;
    }
}