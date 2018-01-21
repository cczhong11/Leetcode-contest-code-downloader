public class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
        
        for (int i = 0; i < nums.length;) {
            int end = i;
            while (end < nums.length && nums[end] == nums[i]) {
                end++;
            }
            
            int cnt = end - i;
            for (int j = list.size() - 1; j >= 0 && cnt > 0; j--) {
                if (list.get(j).peekLast() != nums[i] - 1) {
                    break;
                }
                list.get(j).addLast(nums[i]);
                cnt--;
            }
            
            for (int k = 0; k < cnt; k++) {
                LinkedList<Integer> tmp = new LinkedList<Integer>();
                tmp.add(nums[i]);
                list.add(tmp);
            }
            
            i = end;
        }
        
        for (LinkedList<Integer> sub : list) {
            if (sub.size() < 3) {
                return false;
            }
        }
        return true;
    }
}