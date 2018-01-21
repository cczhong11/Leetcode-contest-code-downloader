public class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int dup = 0;
        long sum = 0;
        for(int n: nums){
            if(set.contains(n)){
                dup = n;
            }
            set.add(n);
            sum+=n;
        }
        int len = nums.length;
        int mis = (int)((long)len*(len+1)/2 - sum + dup);
        return new int[]{dup, mis};
    }
}