public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(!set.add(num)) {
                result[0] = num;
            }
        }
        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}