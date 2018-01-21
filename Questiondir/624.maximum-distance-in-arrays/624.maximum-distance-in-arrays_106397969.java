public class Solution {
    public int maxDistance(int[][] arrays) {
        int n = arrays.length;
        ArrayList<int[]> ln = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] arr = arrays[i];
            if (arr.length == 0) continue;
            int[] cur = new int [] {arr[arr.length-1], i};
            ln.add(cur);
        }
        Collections.sort(ln, (a, b) -> (a[0] - b[0]));
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = arrays[i];
            if (arr.length == 0) continue;
            int s = arr[0];
            int j = ln.size()-1;
            while (ln.get(j)[1] == i) j--;
            max = Math.max(max, ln.get(j)[0]-s);
        }
        return max;
    }
}