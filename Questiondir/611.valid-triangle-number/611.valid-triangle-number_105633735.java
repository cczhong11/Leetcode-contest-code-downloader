public class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] == 0) continue;
            int k = nums.length - 1;
            for(int j = nums.length - 2; j >= i + 1; j--){
                while(1L*nums[i] + nums[j] <= nums[k] && k > j ) k--;
                sum += k - j;
            }
        }
        return sum;
    }
}