public class Solution {
    public int maxDistance(int[][] arrays) {
        if (arrays == null || arrays.length < 2) {
            return 0;
        }
        
        int index0 = 0, index1 = 0, index2 = 0, index3 = 0;
        Integer min0 = null, min1 = null, max0 = null, max1 = null;
        
        for (int i = 0; i < arrays.length; i++) {
            int curr = arrays[i][0];
            if (min0 == null) {
                index0 = i;
                min0 = curr;
            } else if (min0 >= curr) {
                min1 = min0;
                index1 = index0;
                min0 = curr;
                index0 = i;
            } else if (min1 == null || min1 > curr) {
                min1 = curr;
                index1 = i;
            }
            
            curr = arrays[i][arrays[i].length - 1];
            if (max0 == null) {
                index2 = i;
                max0 = curr;
            } else if (max0 <= curr) {
                max1 = max0;
                index3 = index2;
                max0 = curr;
                index2 = i;
            } else if (max1 == null || max1 < curr) {
                max1 = curr;
                index3 = i;
            }
        }
        
        //System.out.println(index0 + "\t" + min0 + "\t" + index2 + "\t" + max0);
        if (index0 != index2) {
            return max0 - min0;
        } else {
            return Math.max(max0 - min1, max1 - min0);
        }
    }
}