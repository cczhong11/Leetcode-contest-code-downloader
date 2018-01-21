public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int num1 = -1;
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                num1 = num;
        
            }else{
                set.add(num);
            }
            sum += num;
        }
        
        int diff = (1 + n) * n / 2 - sum;
        return new int[]{num1, num1 + diff};
    }
}