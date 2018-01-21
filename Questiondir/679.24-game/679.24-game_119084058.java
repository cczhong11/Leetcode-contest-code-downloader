class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> dNums = new ArrayList<>();
        for (int num : nums) dNums.add((double)num);
        return judgePoint(dNums);
    }
    
    public boolean judgePoint(List<Double> nums) {
        int n = nums.size();
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 0.00001;
        } else {
            for (int i = 0; i < n; ++i) {
                for (int j =  i + 1; j < n; ++j) {
                    List<Double> next = new ArrayList<>(nums);
                    next.remove(j); next.remove(i);
                    next.add(nums.get(i) + nums.get(j));
                    if (judgePoint(next)) return true;
                    next.remove(next.size() - 1);
                    next.add(nums.get(i) * nums.get(j));
                    if (judgePoint(next)) return true;
                    next.remove(next.size() - 1);
                    next.add(nums.get(i) / nums.get(j));
                    if (judgePoint(next)) return true;
                    next.remove(next.size() - 1);
                    next.add(Math.abs(nums.get(i) - nums.get(j)));
                    if (judgePoint(next)) return true;
                    next.remove(next.size() - 1);
                    next.add(nums.get(j) / nums.get(i));
                    if (judgePoint(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
            return false;
        }
    }
}