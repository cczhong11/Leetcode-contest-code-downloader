public class Solution {
    public int maxDistance(int[][] arrays) {
        int result = 0;
        int min = arrays[0][0];
        int max = arrays[0][arrays[0].length-1];
        for(int i=1; i<arrays.length; i++){
            result = Math.max(result, Math.abs(max - arrays[i][0]));
            result = Math.max(result, Math.abs(arrays[i][arrays[i].length-1]-min));
            max = Math.max(max, arrays[i][arrays[i].length-1]);
            min = Math.min(min, arrays[i][0]);
        }
        return result;
        
    }
}