public class Solution {
    public boolean isPossible(int[] nums) {
        List<Sequence> sequences = new ArrayList<Sequence>();
        for (int i = 0; i < nums.length; ++i) {
            Sequence toUse = null;
            for (Sequence s : sequences) {
                if (s.lastNum == nums[i] - 1) {
                    if (toUse == null) toUse = s;
                    else if (s.totalAdded < toUse.totalAdded) toUse = s;
                }
            }
            if (toUse == null) {
                Sequence newSequence = new Sequence(1, nums[i]);
                sequences.add(newSequence);
            } else {
                toUse.lastNum = nums[i];
                toUse.totalAdded = toUse.totalAdded + 1;
            }
        }
        
        for (Sequence s : sequences) {
            if (s.totalAdded < 3) return false;
        }
        return true;
    }
    
    private class Sequence {
        public int totalAdded;
        public int lastNum;
        public Sequence(int a, int b) {
            totalAdded = a;
            lastNum = b;
        }
        
        public int hashCode() {
            return totalAdded * 2 + lastNum * 3;
        }
        
        public boolean equals(Object o) {
            if (!(o instanceof Sequence)) return false;
            Sequence s = (Sequence) o;
            return totalAdded == s.totalAdded && lastNum == s.lastNum;
        }
    }
}