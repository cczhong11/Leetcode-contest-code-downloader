public class Solution {
    public int maxDistance(int[][] arrays) {
        
        if(arrays == null || arrays.length == 0) return 0;
        int ans = 0;
        boolean first = true;
        int min = 0, max = 0;
        for(int i=0; i<arrays.length; i++) {
            int[] array = arrays[i];
            if(array == null || array.length <=0) continue;
            int curMin = array[0];
            int curMax = array[0];
            for(int num: array) {
                curMin = Math.min(curMin, num);
                curMax = Math.max(curMax, num);
            }
            
            if(first) {
                first = false;
                min = curMin;
                max = curMax;
            } else {
                ans = Math.max(Math.abs(max - curMin), ans);
                ans = Math.max(Math.abs(min - curMax), ans);
            }
            min = Math.min(curMin, min);
            max = Math.max(curMax, max);
        }

        return ans;
    }
}