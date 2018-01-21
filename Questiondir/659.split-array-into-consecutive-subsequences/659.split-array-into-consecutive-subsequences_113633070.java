public class Solution {
    public boolean isPossible(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;
        int n = nums.length, last = nums[0], cur = 0;
        int[] l = new int[3], newl = new int[3];
        for(int i = 0; i < n; i++) {
            if(nums[i] != last) {
                if(l[0] != 0 || l[1] != 0)
                    return false;
                if(nums[i] != last + 1) {
                    if(newl[0] != 0 || newl[1] != 0)
                        return false;
                    newl[2] = 0;
                }
                l[0] = newl[0];
                l[1] = newl[1];
                l[2] = newl[2];
                newl[0] = 0;
                newl[1] = 0;
                newl[2] = 0;
                last = nums[i];
            } 
            if(l[0] != 0) {
                l[0]--;
                newl[1]++;
            } else if(l[1] != 0) {
                l[1]--;
                newl[2]++;
            } else if(l[2] != 0) {
                l[2]--;
                newl[2]++;
            } else {
                newl[0]++;
            }
        }
        if(l[0] != 0 || l[1] != 0 || newl[0] != 0 || newl[1] != 0)
           return false;
        return true;
    }
}