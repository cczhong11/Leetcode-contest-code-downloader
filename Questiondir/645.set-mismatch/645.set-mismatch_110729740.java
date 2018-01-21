public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int s = n*(n+1)/2;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int a = -1;
        for(int i = 0; i< n ; i++){
            sum += nums[i];
            if(set.contains(nums[i])){
                a = nums[i];
            }else{
                set.add(nums[i]);
            }
        }
        int[] r = new int[2];
        r[0] =a;
        r[1] = a+s-sum;
        return r;
        
        
        
    }
}