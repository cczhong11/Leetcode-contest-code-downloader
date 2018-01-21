public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> ones = new HashMap<>();
        Map<Integer, Integer> twos = new HashMap<>();
        Map<Integer, Integer> threes = new HashMap<>();
        
        for (int num: nums) {
            int v = num - 1;
            if (ones.containsKey(v) && ones.get(v) > 0) {
                ones.put(v, ones.get(v) - 1);
                twos.put(num, twos.getOrDefault(num, 0) + 1);
            } else if (twos.containsKey(v) && twos.get(v) > 0) {
                twos.put(v, twos.get(v) - 1);
                threes.put(num, threes.getOrDefault(num, 0) + 1);
            } else if (threes.containsKey(v) && threes.get(v) > 0) {
                threes.put(v, threes.get(v) - 1);
                threes.put(num, threes.getOrDefault(num, 0) + 1);
            } else {
                ones.put(num, ones.getOrDefault(num, 0) + 1);
            }
        }
        //System.out.println(ones);
        //System.out.println(twos);
        for (int n: ones.values()) {
            if (n > 0) return false;
        }
        for (int n: twos.values()) {
            if (n > 0) return false;
        }
        return true;
    }
}