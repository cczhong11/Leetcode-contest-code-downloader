public class Solution {
    public int[] findErrorNums(int[] nums) {
		Set<Integer> allNums = new HashSet<Integer>();
		for (int i = 1; i <= nums.length; i++) {
			allNums.add(i);
		}
		int[] result = new int[2];
		for (int num : nums) {
			if (!allNums.remove(num)) {
				result[0] = num;
			}
		}
		result[1] = allNums.iterator().next();
		return result;
    }
}