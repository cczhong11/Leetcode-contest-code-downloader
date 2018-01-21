public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int product = 1;
        //If we can return a positive number, return the largest positive number
        for(int i = nums.length-3; i < nums.length; i++){
            product *= nums[i];
        }
        int product2 = 1;
        for(int i = 0; i < 2; i++){
            product2 *= nums[i];
        }
        product2 *= nums[nums.length-1];
        int product3 = nums[0];
        for(int i = nums.length-2; i < nums.length; i++){
            product3 *= nums[i];
        }
        return Math.max(product3, Math.max(product, product2));
        //If we can only return a negative number, return the smallest negative number
    }
}