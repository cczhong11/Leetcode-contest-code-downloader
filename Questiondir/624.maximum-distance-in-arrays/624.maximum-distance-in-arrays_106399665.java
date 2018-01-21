public class Solution {
    public int maxDistance(int[][] arrays) {
        int n = arrays.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[][] mm = new int[n][];
        for(int i = 0; i < n; ++i) {
            mm[i] = new int[]{arrays[i][0], arrays[i][arrays[i].length-1]};
            min = Math.min(min, mm[i][0]);
            max = Math.max(max, mm[i][1]);
        }
        Arrays.sort(mm, (a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        if(mm[0][1] != max) return max-min;
        else {
            int temp = max-mm[1][0];
            Arrays.sort(mm, (a,b)->(a[1]==b[1]?b[0]-a[0]:b[1]-a[1]));
            if(mm[0][0] != min) return max-min;
            else {
                temp = Math.max(temp, mm[1][1] - min);
                return temp;
            }
        }
        
    }
}